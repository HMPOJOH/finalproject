package com.example.Weatherbasedcontent;
import com.example.Weatherbasedcontent.WeatherAPIWW.ForecastDays;
import com.example.Weatherbasedcontent.WeatherAPIWW.WeatherAnalyzer;

import com.example.Weatherbasedcontent.Repositories.*;
import com.example.Weatherbasedcontent.WeatherAPIWW.WeatherRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    private List<String> possibleLocations = new ArrayList<String>();
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
    public String index(ForecastDays forecastdays, HttpSession session, @RequestParam String city, int department, @RequestParam(required = false, defaultValue = "18.071093") double longitude, @RequestParam(required = false, defaultValue = "59.325117") double latitude, RestTemplate restTemplate, Model model) {
        WeatherRoot weatherFromAPI =restTemplate.getForObject("https://api.openweathermap.org/data/2.5/forecast?q="+city+"&appid=0de04dc3bae5ebc08ee10c77aabe6215&units=metric", WeatherRoot.class);
        analyzeWeatherAPI = new WeatherAnalyzer(weatherFromAPI, forecastdays);
        float temperature = analyzeWeatherAPI.getTemp();
        int   tempCategory = analyzeWeatherAPI.getTempCategory(temperature);
        float  windSpeed = analyzeWeatherAPI.getWindSpeed();
        int  seasonIdbyDateAndCountry = prmRep.getSeasonIdbyDateAndCountry(analyzeWeatherAPI.getDateForSpecificDay(), weatherFromAPI.getCity().getCountry());
        int weatherCategoryId = analyzeWeatherAPI.getWeatherCategory();
        String  weatherImage = analyzeWeatherAPI.getWeatherCategoryImage(); //http://openweathermap.org/img/wn/10d@2x.png
        String  weatherDesc = analyzeWeatherAPI.getWeatherDesc();


        //desc, seasonid, weathersymbolid, tempid, department =
        Scenario scenario = prmRep.getScenariobyValues(seasonIdbyDateAndCountry, weatherCategoryId, tempCategory, department);
        System.out.println(scenario.getId());
        System.out.println(scenario.getDescription());
        //test contentcall
        List<Content> contentList = productRepos.getContentList(scenario.getId(), seasonIdbyDateAndCountry, department, weatherCategoryId);

        //Just to show the values - will rather be used in the Content lookup
        model.addAttribute("city", city);
        model.addAttribute("temperature", temperature);
        model.addAttribute("currentWindSpeed", windSpeed);
        model.addAttribute("currentWeatherImage", weatherImage);
        model.addAttribute("weatherdesc", weatherDesc);
        model.addAttribute("country", weatherFromAPI.getCity().getCountry());
        model.addAttribute("tempcat", tempCategory);
        System.out.println("tempcat" + tempCategory);
        model.addAttribute("contentList", contentList);
        System.out.println("country" + weatherFromAPI.getCity().getCountry());
        model.addAttribute("scenario", scenario.getDescription());
        System.out.println("scenarioid" + scenario.getId());
        System.out.println("weathercat" + weatherCategoryId);
        System.out.println("seasonid; "+seasonIdbyDateAndCountry );
        return "index";
    }

 @GetMapping("/addcontent/{scenarioId}")
    public String addContent(Model model, @PathVariable int scenarioId) {
        Scenario scenario = prmRep.getScenario(scenarioId);
        List<Content> contentList = productRepos.getContentListbyId(scenario.getId());
        model.addAttribute("scenarioId", scenarioId);
        model.addAttribute("scenarioDesc", scenario.getDescription());
        model.addAttribute("contentList", contentList);
        model.addAttribute("content", new Content());
        return "addcontent";
    }

    @PostMapping("/saveContent/{scenarioId}")
    public String set(@ModelAttribute Content content, @PathVariable int scenarioId) {
        System.out.println("add into scenario " + scenarioId);
        int contentId = productRepos.addContent(content);
        System.out.println("contentId added: " + contentId);
        return "addcontent";
    }

}
