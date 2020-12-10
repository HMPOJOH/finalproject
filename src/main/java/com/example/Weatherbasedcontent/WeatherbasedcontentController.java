package com.example.Weatherbasedcontent;

import com.example.Weatherbasedcontent.InternationalWeather.WeatherOutsideSE;
import com.example.Weatherbasedcontent.Repositories.*;
import com.example.Weatherbasedcontent.SMHI.SMHIDays;
import com.example.Weatherbasedcontent.SMHI.Weather;
import com.example.Weatherbasedcontent.SMHI.WeatherAnalyzerBySMHIDay;
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
    private WeatherOutsideSE weatherOutsideSE;
    private List<City> possibleLocations = new ArrayList<City>();
    private List<Department> departments = new ArrayList<Department>();
    private int season = 0;

    @GetMapping("/setuppanel")
    public String setupPanel(HttpSession session, Model model) {
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
        longitude = locationRep.getLongitudeByCity(possibleLocations, city);
        latitude = locationRep.getLatitudeByCity(possibleLocations, city);
        String countryID = locationRep.getCountryIDByCity(possibleLocations, city);
        float temperature = 0;
        int tempCategory = 0;
        float windSpeed = 0;
        int weatherSymbolNumber = 0;
        int seasonIdbyDateAndCountry = 0;
        String weatherCategory="";
        int weatherCategoryId = 0;
        String weatherImage="";
        String symbolText="";
        //Call SMHI API
        System.out.println("get weather start..");
        if (countryID.equals("SE")) {
            weatherFromSMHI = restTemplate.getForObject("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/" + longitude + "/lat/" + latitude + "/data.json", Weather.class);
            System.out.println("get weather end..");
            //Analyze SMHI weather for a specific day
            //Two inputs, SMHI weather + which day to analyze
            //get parameters
            WeatherAnalyzerBySMHIDay weatherByDay = new WeatherAnalyzerBySMHIDay(weatherFromSMHI, smhidays);
            temperature = weatherByDay.getTemp();
            tempCategory = weatherByDay.getTempCategory(temperature);
            windSpeed = weatherByDay.getWindSpeed();
            weatherSymbolNumber = weatherByDay.getWeatherSymbolNumber();
            seasonIdbyDateAndCountry = prmRep.getSeasonIdbyDateAndCountry(weatherByDay.getDateFromTimeSerieOfChoice(), countryID);
            weatherCategory = weatherByDay.getWeatherCategory(weatherSymbolNumber);
            weatherCategoryId = weatherByDay.getWeatherCategoryId(weatherSymbolNumber);
            weatherImage = weatherByDay.getWeatherCategoryImage(weatherSymbolNumber);
            symbolText = weatherByDay.getWeatherSymbolText(weatherSymbolNumber);
        } else if (countryID.equals("AU")) {
            //get parameters
            temperature = 40;
            tempCategory = 1;
            windSpeed = 2;
            weatherSymbolNumber = 1;
            seasonIdbyDateAndCountry = 1;
            weatherCategory = "Sunny";
            weatherCategoryId = 1;
            weatherImage = "https://img.icons8.com/office/30/000000/summer.png";
            symbolText = "Clear sky";
        }
     else if (countryID.equals("UK")) {
        //get parameters
        temperature = 4;
        tempCategory = 3;
        windSpeed = 2;
        weatherSymbolNumber = 20;
        seasonIdbyDateAndCountry = 4;
        weatherCategory = "Rain";
        weatherCategoryId = 2;
        weatherImage = "https://img.icons8.com/office/30/000000/downpour.png";
        symbolText = "Heavy rain";

        //just for testing!
            weatherOutsideSE = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=0de04dc3bae5ebc08ee10c77aabe6215&units=metric", WeatherOutsideSE.class);

            temperature = (float)weatherOutsideSE.getMain().getTemp();
            windSpeed = (float)weatherOutsideSE.getWind().getSpeed();
            weatherImage = "http://openweathermap.org/img/wn/"+weatherOutsideSE.getWeather().get(0).getIcon()+ "@2x.png";

            System.out.println(weatherOutsideSE.getName() + " " + weatherOutsideSE.getSys().getCountry());
            System.out.println(weatherOutsideSE.getMain().getTemp());
            System.out.println(weatherOutsideSE.getWeather().get(0).getMain() + " " + weatherOutsideSE.getWeather().get(0).getDescription() );
     }

     else if (countryID.equals("CA")) {
        //get parameters
        temperature = -10;
        tempCategory = 4;
        windSpeed = 2;
        weatherSymbolNumber = 26;
        seasonIdbyDateAndCountry = 2;
        weatherCategory = "Snow";
        weatherCategoryId = 4;
        weatherImage = "https://img.icons8.com/office/30/000000/snow.png";
        symbolText = "Moderate snowfall";
    }


        //desc, seasonid, weathersymbolid, tempid, department =
        int scenarioId = prmRep.getScenarioId(seasonIdbyDateAndCountry, weatherCategoryId, tempCategory, department);
        System.out.println("scenarioId:" + scenarioId);
        Scenario scenario = prmRep.getScenario(seasonIdbyDateAndCountry, weatherCategoryId, tempCategory, department);
        System.out.println(scenario.getDescription());
        //test contentcall
        List<Content> contentList = productRepos.getContentList(scenarioId, seasonIdbyDateAndCountry, department, weatherCategoryId);

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
