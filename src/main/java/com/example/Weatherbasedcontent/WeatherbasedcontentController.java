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
    public String index(SMHIDays smhidays, HttpSession session, @RequestParam String city, int department, @RequestParam(required = false, defaultValue = "18.071093") double longitude, @RequestParam(required = false, defaultValue = "59.325117") double latitude, RestTemplate restTemplate, Model model) {
        System.out.println(smhidays);
        //Location
        longitude= locationRep.getLongitudeByCity(possibleLocations, city);
        latitude= locationRep.getLatitudeByCity(possibleLocations, city);
        String countryID = locationRep.getCountryIDByCity(possibleLocations, city);

        //Call SMHI API
        System.out.println("get weather start..");
        weatherFromSMHI = restTemplate.getForObject("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/"+longitude +"/lat/" + latitude+"/data.json", Weather.class);
        System.out.println("get weather end..");

        //Analyze SMHI weather for a specific day
        //Two inputs, SMHI weather + which day to analyze
        WeatherAnalyzerBySMHIDay weatherByDay = new WeatherAnalyzerBySMHIDay(weatherFromSMHI, smhidays);


        //get parameters
        Float temperature = weatherByDay.getTemp();
        int tempCategory = weatherByDay.getTempCategory(temperature);
        Float windSpeed = weatherByDay.getWindSpeed();
        int weatherSymbolNumber = weatherByDay.getWeatherSymbolNumber();

        int seasonIdbyDateAndCountry = prmRep.getSeasonIdbyDateAndCountry(weatherByDay.getDateFromTimeSerieOfChoice(), countryID);
        String weatherCategory = weatherByDay.getWeatherCategory(weatherSymbolNumber);
        int weatherCategoryId = weatherByDay.getWeatherCategoryId(weatherSymbolNumber);
        String weatherImage = weatherByDay.getWeatherCategoryImage(weatherSymbolNumber);
        String symbolText = weatherByDay.getWeatherSymbolText(weatherSymbolNumber);

        //desc, seasonid, weathersymbolid, tempid, department =
        int scenarioId = prmRep.getScenarioId(seasonIdbyDateAndCountry,weatherCategoryId,tempCategory,department);
        System.out.println("scenarioId:" + scenarioId);
        Scenario scenario = prmRep.getScenario(seasonIdbyDateAndCountry,weatherCategoryId,tempCategory,department);
        System.out.println(scenario.getDescription());
        //test contentcall
        List<Content> contentList = productRepos.getContentList(scenarioId,seasonIdbyDateAndCountry);

        //Just to show the values - will rather be used in the Content lookup
        model.addAttribute("city", city);
        model.addAttribute("weather", weatherFromSMHI);
        model.addAttribute("temperature", temperature);
        model.addAttribute("currentWindSpeed", windSpeed);
        model.addAttribute("weatherSymbolNumber", weatherSymbolNumber);
        model.addAttribute("weatherCategory", weatherCategory);
        model.addAttribute("currentWeatherImage", weatherImage);
        model.addAttribute("currentWeatherSymbolText", symbolText);
        model.addAttribute("country", countryID);
        model.addAttribute("tempcat", tempCategory);
        model.addAttribute("contentList", contentList);
        model.addAttribute("scenario", scenario.getDescription());






        return "index";
    }

}
