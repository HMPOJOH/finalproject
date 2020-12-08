package com.example.Weatherbasedcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class WeatherbasedcontentController {

    @Autowired
    private WeatherbasedcontentRepository productRepos;

    @GetMapping("/dummyweather")
    public String testSMHI(RestTemplate restTemplate, Model model) {
        //Stockholm geocode 59.325117	",	"Longitude"	:"	18.071093
        Weather weather = restTemplate.getForObject("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/18.071/lat/59.325/data.json", Weather.class);

        WeatherCalculator weatherCalc = new WeatherCalculator(weather);
        weatherCalc.getCurrentTemp();






        model.addAttribute("location", "Home");
        model.addAttribute("weather", weather);
        return "dummypage";
    }

}
