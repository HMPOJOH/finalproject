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
    private Weather weather = new Weather();
    private List<Locations> possibleLocations = new ArrayList<Locations>();
    private LocationRepository rep = new LocationRepository();



    @GetMapping("/setuppanel")
    public String setupPanel(HttpSession session, Model model){

        possibleLocations = rep.getLocationsList();
        model.addAttribute("weather", weather);
        model.addAttribute("locations", possibleLocations);
        return "setuppanel";
    }




    @PostMapping("/panel")
    public String testSMHI(HttpSession session, @RequestParam String city, @RequestParam(required = false, defaultValue = "18.071093") double longitude, @RequestParam(required = false, defaultValue = "59.325117") double latitude, RestTemplate restTemplate, Model model) {

        System.out.println(city);

        longitude= rep.getLongitudeByCity(city);
        latitude= rep.getLatitudeByCity(city);
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

        //Just to show the values - will rather be used in the Content lookup 
        model.addAttribute("city", city);
        model.addAttribute("weather", weather);
        model.addAttribute("currentTemp", currentTemp);
        model.addAttribute("currentWindSpeed", currentWindSpeed);
        model.addAttribute("currentWeatherSymbolnr", currentWeatherSymbolnr);
        model.addAttribute("currentWeatherCategory", currentWeatherCategory);
        model.addAttribute("currentWeatherImage", currentWeatherImager);
        model.addAttribute("currentWeatherSymbolText", currentSymbolText);


        return "panel";
    }

}
