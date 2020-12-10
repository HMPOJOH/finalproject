package com.example.Weatherbasedcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.util.Calendar.YEAR;

@Controller
public class WeatherbasedcontentController {

    @Autowired
    private WeatherbasedcontentRepository productRepos;
    @Autowired
    private LocationRepository locationRep;
    @Autowired
    private ParameterRepository prmRep;

    private Weather weather = new Weather();
    private List<City> possibleLocations = new ArrayList<City>();
    private List<Department> departments = new ArrayList<Department>();
    private int season = 0;

    @GetMapping("/setuppanel")
    public String setupPanel(HttpSession session, Model model){

        possibleLocations = locationRep.getLocationsList();
        departments = prmRep.getDepList();
        //season = prmRep.getSeason('2020-12-08','SE'); I did the same in weatchercalc :) But i use date from timeseries instead..  //pJ
        //System.out.println("season " + season);
        model.addAttribute("weather", weather);
        model.addAttribute("locations", possibleLocations);
        model.addAttribute("departments", departments);
        return "setuppanel";
    }




    @PostMapping("/panel")

    //this is just for testing that we have all values we want
    public String testSMHI(HttpSession session,@RequestParam String department, @RequestParam String city, @RequestParam(required = false, defaultValue = "18.071093") double longitude, @RequestParam(required = false, defaultValue = "59.325117") double latitude, RestTemplate restTemplate, Model model) {

        System.out.println(city);

        longitude=possibleLocations.stream()
                .filter(x -> city.equals(x.getName())).findAny().orElse(null).getLongitude(); //locationRep.getLongitudeByCity(city);
        latitude= possibleLocations.stream()
                .filter(x -> city.equals(x.getName())).findAny().orElse(null).getLatitude();//locationRep.getLatitudeByCity(city);

        String countryID = locationRep.getCountryIDByCity(city);

        weather = restTemplate.getForObject("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/"+longitude +"/lat/" + latitude+"/data.json", Weather.class);
        WeatherCalculator weatherCalc = new WeatherCalculator(weather);
        //SMHI
        Float currentTemp = weatherCalc.getCurrentTemp();
        Float currentWindSpeed = weatherCalc.getCurrentWindSpeed();
        int currentWeatherSymbolnr = weatherCalc.getCurrentWeatherSymbolNumber();


        //internal loolup time.format(DateTimeFormatter.ISO_DATE_TIME);
        Date currentDate = weatherCalc.getCurrentDate();
        System.out.println(currentDate);


         int getCurrentSeasonId = productRepos.getCurrentSeasonId(currentDate, countryID);
        System.out.println("dep: "+department);
        System.out.println("seasonid "+ getCurrentSeasonId);
        System.out.println("weatherSymbolnr:"+currentWeatherSymbolnr);
        String currentWeatherCategory = weatherCalc.getWeatherCategory(currentWeatherSymbolnr);

        System.out.println("weatherCategoryName:"+ currentWeatherCategory);
        int currentWeatherCategoryId = weatherCalc.getWeatherCategoryId(currentWeatherSymbolnr);
        System.out.println("weatherCategoryId:"+ currentWeatherCategoryId);
        String currentWeatherImager = weatherCalc.getWeatherCategoryImage(currentWeatherSymbolnr);
        String currentSymbolText = weatherCalc.getCurrentWeatherSymbolText(currentWeatherSymbolnr);
        int temperatureCategory = weatherCalc.getTempCategory(currentTemp);


        System.out.println("tempcat:" + temperatureCategory);
        //desc, seasonid, weathersymbolid, tempid, department =


         int scenarioId = productRepos.getScenarioId(getCurrentSeasonId,currentWeatherCategoryId,temperatureCategory,department);
        System.out.println("scenarioId:" + scenarioId);
        //test contentcall
        List<Content> contentList = productRepos.getContentList(1);

        //Just to show the values - will rather be used in the Content lookup
        model.addAttribute("city", city);
        model.addAttribute("weather", weather);
        model.addAttribute("currentTemp", currentTemp);
        model.addAttribute("currentWindSpeed", currentWindSpeed);
        model.addAttribute("currentWeatherSymbolnr", currentWeatherSymbolnr);
        model.addAttribute("currentWeatherCategory", currentWeatherCategory);
        model.addAttribute("currentWeatherImage", currentWeatherImager);
        model.addAttribute("currentWeatherSymbolText", currentSymbolText);
        model.addAttribute("contentimage", contentList.get(0).getImage());
        model.addAttribute("country", countryID);
        model.addAttribute("tempcat", temperatureCategory);



        return "panel";
    }

    /*@PostMapping("/index")
    public String index(HttpSession session, @RequestParam String city, @RequestParam(required = false, defaultValue = "18.071093") double longitude, @RequestParam(required = false, defaultValue = "59.325117") double latitude, RestTemplate restTemplate, Model model) {

        List<Content> contentList = productRepos.getContentList(3);


        model.addAttribute("contentList", contentList);


        return "index";
    }*/

    @PostMapping("/index")
    public String index(HttpSession session, @RequestParam String city, int department, @RequestParam(required = false, defaultValue = "18.071093") double longitude, @RequestParam(required = false, defaultValue = "59.325117") double latitude, RestTemplate restTemplate, Model model) {

        System.out.println(city);

        longitude=possibleLocations.stream()
                .filter(x -> city.equals(x.getName())).findAny().orElse(null).getLongitude(); //locationRep.getLongitudeByCity(city);
        latitude= possibleLocations.stream()
                .filter(x -> city.equals(x.getName())).findAny().orElse(null).getLatitude();//locationRep.getLatitudeByCity(city);

        String countryID = locationRep.getCountryIDByCity(city);

        weather = restTemplate.getForObject("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/"+longitude +"/lat/" + latitude+"/data.json", Weather.class);
        WeatherCalculator weatherCalc = new WeatherCalculator(weather);
        //SMHI
        Float currentTemp = weatherCalc.getCurrentTemp();
        Float currentWindSpeed = weatherCalc.getCurrentWindSpeed();
        int currentWeatherSymbolnr = weatherCalc.getCurrentWeatherSymbolNumber();


        //internal loolup
        String currentWeatherCategory = weatherCalc.getWeatherCategory(currentWeatherSymbolnr);
        int currentWeatherCategoryId = weatherCalc.getWeatherCategoryId(currentWeatherSymbolnr);
        String currentWeatherImager = weatherCalc.getWeatherCategoryImage(currentWeatherSymbolnr);
        String currentSymbolText = weatherCalc.getCurrentWeatherSymbolText(currentWeatherSymbolnr);
        int temperatureCategory = weatherCalc.getTempCategory(currentTemp);
        System.out.println("tempcat:" + temperatureCategory);

        // int scenarioId = productRepos.getScenarioId(currentWeatherCategory,department,)
        //test contentcall
        List<Content> contentList = productRepos.getContentList(3);

        //Just to show the values - will rather be used in the Content lookup
        model.addAttribute("city", city);
        model.addAttribute("weather", weather);
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


        return "index";
    }

}
