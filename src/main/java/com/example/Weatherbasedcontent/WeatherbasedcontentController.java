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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


    @GetMapping("/setuppanel")
    public String setupPanel(HttpSession session, Model model){

        possibleLocations = locationRep.getLocationsList();
        departments = prmRep.getDepList();
        model.addAttribute("weather", weather);
        model.addAttribute("locations", possibleLocations);
        model.addAttribute("departments", departments);
        return "setuppanel";
    }




    @PostMapping("/panel")
    public String testSMHI(HttpSession session, @RequestParam String city, @RequestParam(required = false, defaultValue = "18.071093") double longitude, @RequestParam(required = false, defaultValue = "59.325117") double latitude, RestTemplate restTemplate, Model model) {

        System.out.println(city);

        longitude= locationRep.getLongitudeByCity(city);
        latitude= locationRep.getLatitudeByCity(city);
        String countryID = locationRep.getCountryIDByCity(city);
        System.out.println("long:" +longitude);
        System.out.println("lat:" +latitude);
        weather = restTemplate.getForObject("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/"+longitude +"/lat/" + latitude+"/data.json", Weather.class);
        WeatherCalculator weatherCalc = new WeatherCalculator(weather);
        //SMHI
        Float currentTemp = weatherCalc.getCurrentTemp();
        Float currentWindSpeed = weatherCalc.getCurrentWindSpeed();
        int currentWeatherSymbolnr = weatherCalc.getCurrentWeatherSymbolNumber();


        //internal loolup
        String currentWeatherCategory = weatherCalc.getWeatherCategory(currentWeatherSymbolnr);
        String currentWeatherImager = weatherCalc.getWeatherCategoryImage(currentWeatherSymbolnr);
        String currentSymbolText = weatherCalc.getCurrentWeatherSymbolText(currentWeatherSymbolnr);
        int temperatureCategory = weatherCalc.getTempCategory(currentTemp);
        System.out.println(temperatureCategory);

       // int scenarioId = productRepos.getScenarioId(currentWeatherCategory,department,)
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

    @PostMapping("/index")
    public String index(HttpSession session, @RequestParam String city, @RequestParam(required = false, defaultValue = "18.071093") double longitude, @RequestParam(required = false, defaultValue = "59.325117") double latitude, RestTemplate restTemplate, Model model) {

        List<Content> contentList = productRepos.getContentList(3);


        model.addAttribute("contentList", contentList);


        return "index";
    }

}
