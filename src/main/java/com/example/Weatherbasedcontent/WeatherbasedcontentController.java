package com.example.Weatherbasedcontent;
import com.example.Weatherbasedcontent.WeatherAPIWW.ForecastDays;
import com.example.Weatherbasedcontent.WeatherAPIWW.WeatherAnalyzer;

import com.example.Weatherbasedcontent.Repositories.*;
import com.example.Weatherbasedcontent.SMHI.SMHIDays;
import com.example.Weatherbasedcontent.SMHI.Weather;
import com.example.Weatherbasedcontent.SMHI.WeatherAnalyzerBySMHIDay;
import com.example.Weatherbasedcontent.WeatherAPIWW.WeatherRoot;
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


    private WeatherAnalyzer analyzeWeatherAPI;

    @Autowired
    private ContentRepository productRepos;
    @Autowired
    private CityRepository locationRep;
    @Autowired
    private ParameterRepository prmRep;




    private WeatherRoot weatherFromAPI = new WeatherRoot();

    private List<City> possibleLocations = new ArrayList<City>();
    private List<Department> departments = new ArrayList<Department>();
    private int season = 0;

    @GetMapping("/setuppanel")
    public String setupPanel(HttpSession session, Model model) {
        possibleLocations = locationRep.getLocationsList();
        departments = prmRep.getDepList();

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


            //new API
            WeatherRoot weatherFromAPI =restTemplate.getForObject("https://api.openweathermap.org/data/2.5/forecast?q="+city+"&appid=0de04dc3bae5ebc08ee10c77aabe6215&units=metric", WeatherRoot.class);
            ForecastDays forecastDays = setTempForcastDay(smhidays); //should be deleted later

            analyzeWeatherAPI = new WeatherAnalyzer(weatherFromAPI, forecastDays);

            temperature = analyzeWeatherAPI.getTemp();
            tempCategory = analyzeWeatherAPI.getTempCategory(temperature);


            windSpeed = analyzeWeatherAPI.getWindSpeed();

            //Här är jag..
            seasonIdbyDateAndCountry = prmRep.getSeasonIdbyDateAndCountry(analyzeWeatherAPI.getDateForSpecificDay(), weatherFromAPI.getCity().getCountry());

            weatherCategoryId = analyzeWeatherAPI.getWeatherCategory();
            weatherImage = analyzeWeatherAPI.getWeatherCategoryImage(); //http://openweathermap.org/img/wn/10d@2x.png
            symbolText = analyzeWeatherAPI.getWeatherSymbolText();


        //desc, seasonid, weathersymbolid, tempid, department =
        int scenarioId = prmRep.getScenarioId(seasonIdbyDateAndCountry, weatherCategoryId, tempCategory, department);
        System.out.println("scenarioId:" + scenarioId);
        Scenario scenario = prmRep.getScenario(seasonIdbyDateAndCountry, weatherCategoryId, tempCategory, department);
        System.out.println(scenario.getDescription());
        //test contentcall
        List<Content> contentList = productRepos.getContentList(scenarioId, seasonIdbyDateAndCountry, department, weatherCategoryId);

        //Just to show the values - will rather be used in the Content lookup
        model.addAttribute("city", city);

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

    private ForecastDays setTempForcastDay(SMHIDays smhidays) {
        switch (smhidays) {
            case TODAY:
                return ForecastDays.TODAY;

            case TOMORROW:
                return ForecastDays.TOMORROW;

            case DAY_THREE:
                return ForecastDays.DAY_THREE;

            case DAY_FOUR:
                return ForecastDays.DAY_FOUR;


        }
           return ForecastDays.DAY_FIVE;


    }

}
