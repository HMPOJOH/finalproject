package com.example.Weatherbasedcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class WeatherbasedcontentController {

    @Autowired
    private WeatherbasedcontentRepository productRepos;
    @Autowired
    private LocationRepository locationRep;
    @Autowired
    private ParameterRepository prmRep;

    private Weather weatherFromSMHI = new Weather();
    private List<City> possibleLocations = new ArrayList<City>();
    private List<Department> departments = new ArrayList<Department>();
    private int season = 0;

    @GetMapping("/setuppanel")
    public String setupPanel(HttpSession session, Model model){
        possibleLocations = locationRep.getLocationsList();
        departments = prmRep.getDepList();
        model.addAttribute("weather", weatherFromSMHI);
        model.addAttribute("locations", possibleLocations);
        model.addAttribute("departments", departments);
        

        return "setuppanel";
    }



    @PostMapping("/index")
    public String index(HttpSession session, @RequestParam String city, int department, @RequestParam(required = false, defaultValue = "18.071093") double longitude, @RequestParam(required = false, defaultValue = "59.325117") double latitude, RestTemplate restTemplate, Model model) {

        longitude= locationRep.getLongitudeByCity(possibleLocations, city);
        latitude= locationRep.getLatitudeByCity(possibleLocations, city);
        String countryID = locationRep.getCountryIDByCity(possibleLocations, city);


        System.out.println("get weather start..");

        weatherFromSMHI = restTemplate.getForObject("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/"+longitude +"/lat/" + latitude+"/data.json", Weather.class);
        System.out.println("get weather end..");

        WeatherAnalyzer analyzeWeather = new WeatherAnalyzer(weatherFromSMHI);

        Float currentTemp = analyzeWeather.getCurrentTemp();
        Float currentWindSpeed = analyzeWeather.getCurrentWindSpeed();
        int currentWeatherSymbolnr = analyzeWeather.getCurrentWeatherSymbolNumber();


        //internal loolup time.format(DateTimeFormatter.ISO_DATE_TIME);
        Date currentDate = analyzeWeather.getCurrentDate();
        System.out.println(currentDate);


        int getCurrentSeasonId = prmRep.getSeasonIdbyDateAndCountry(currentDate, countryID);
        System.out.println("dep: "+department);
        System.out.println("seasonid "+ getCurrentSeasonId);
        System.out.println("weatherSymbolnr:"+currentWeatherSymbolnr);
        String currentWeatherCategory = analyzeWeather.getWeatherCategory(currentWeatherSymbolnr);

        System.out.println("weatherCategoryName:"+ currentWeatherCategory);
        int currentWeatherCategoryId = analyzeWeather.getWeatherCategoryId(currentWeatherSymbolnr);
        System.out.println("weatherCategoryId:"+ currentWeatherCategoryId);
        String currentWeatherImager = analyzeWeather.getWeatherCategoryImage(currentWeatherSymbolnr);
        String currentSymbolText = analyzeWeather.getCurrentWeatherSymbolText(currentWeatherSymbolnr);
        int temperatureCategory = analyzeWeather.getTempCategory(currentTemp);


        System.out.println("tempcat:" + temperatureCategory);
        //desc, seasonid, weathersymbolid, tempid, department =


        int scenarioId = prmRep.getScenarioId(getCurrentSeasonId,currentWeatherCategoryId,temperatureCategory,department);
        System.out.println("scenarioId:" + scenarioId);
        Scenario scenario = prmRep.getScenario(getCurrentSeasonId,currentWeatherCategoryId,temperatureCategory,department);
        System.out.println(scenario.getDescription());
        //test contentcall
        List<Content> contentList = productRepos.getContentList(scenarioId);

        //Just to show the values - will rather be used in the Content lookup
        model.addAttribute("city", city);
        model.addAttribute("weather", weatherFromSMHI);
        model.addAttribute("currentTemp", currentTemp);
        model.addAttribute("currentWindSpeed", currentWindSpeed);
        model.addAttribute("currentWeatherSymbolnr", currentWeatherSymbolnr);
        model.addAttribute("currentWeatherCategory", currentWeatherCategory);
        model.addAttribute("currentWeatherImage", currentWeatherImager);
        model.addAttribute("currentWeatherSymbolText", currentSymbolText);
        model.addAttribute("contentimage", contentList.get(0).getImage());
        model.addAttribute("country", countryID);
        model.addAttribute("tempcat", temperatureCategory);
        model.addAttribute("contentList", contentList);
        model.addAttribute("scenario", scenario.getDescription());






        return "index";
    }

}
