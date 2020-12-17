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

    @Autowired
    private ContentRepository contentRepos;
    @Autowired
    private CityRepository locationRep;
    @Autowired
    private ParameterRepository prmRep;

    private WeatherAnalyzer analyzeWeatherAPI;
    private WeatherRoot weatherFromAPI = new WeatherRoot();
    private ScenarioService scenarioService = new ScenarioService();

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
        //default values if API is down
        float temperature = 5.1f;
        int   tempCategory = 5; //avg
        float  windSpeed = 1.2f;
        int  seasonIdbyDateAndCountry = 2; //winter
        int weatherCategoryId = 6; //all clouds
        String  weatherImage = "http://openweathermap.org/img/wn/03d@2x.png"; //http://openweathermap.org/img/wn/10d@2x.png
        String  weatherDesc = "Clouds";
        String country="";

        try {
            WeatherRoot weatherFromAPI = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=0de04dc3bae5ebc08ee10c77aabe6215&units=metric", WeatherRoot.class);
            analyzeWeatherAPI = new WeatherAnalyzer(weatherFromAPI, forecastdays);
            temperature = analyzeWeatherAPI.getTemp();
            tempCategory = analyzeWeatherAPI.getTempCategory(temperature);
            windSpeed = analyzeWeatherAPI.getWindSpeed();
            seasonIdbyDateAndCountry = prmRep.decideSeason(analyzeWeatherAPI.getDateForSpecificDay(), weatherFromAPI.getCity().getCountry(), tempCategory);
            weatherCategoryId = analyzeWeatherAPI.getWeatherCategory();
            weatherImage = analyzeWeatherAPI.getWeatherCategoryImage(); //http://openweathermap.org/img/wn/10d@2x.png
            weatherDesc = analyzeWeatherAPI.getWeatherDesc();
            country=weatherFromAPI.getCity().getCountry();
        }
        catch (Exception e){
            System.out.println("API down, using default values for demo purpose");
        }

        //desc, seasonid, weathersymbolid, tempid, department =
        Scenario scenario = prmRep.getScenarioByValues(seasonIdbyDateAndCountry, weatherCategoryId, tempCategory, department);
        List<Content> contentList = contentRepos.getContentList(scenario.getId(), seasonIdbyDateAndCountry, department, weatherCategoryId);

        //Just to show the values - will rather be used in the Content lookup
        model.addAttribute("city", city);
        model.addAttribute("temperature", temperature);
        model.addAttribute("currentWindSpeed", windSpeed);
        model.addAttribute("currentWeatherImage", weatherImage);
        model.addAttribute("weatherdesc", weatherDesc);
        model.addAttribute("country", country);
        model.addAttribute("tempcat", tempCategory);
        model.addAttribute("weatherCategoryId", weatherCategoryId);
        model.addAttribute("contentList", contentList );
        model.addAttribute("scenario", scenario.getDescription());
        model.addAttribute("background", scenario.getBackground());

        System.out.println("------ Content list id--------");
        for (Content id:contentList)
            System.out.println(id.getId() + " " + id.getText());
        System.out.println("------Weather parameter-----------");
        System.out.println("country" + country);
        System.out.println("seasonid: "+seasonIdbyDateAndCountry );
        System.out.println("weathercat:" + weatherCategoryId);
        System.out.println("tempcat" + tempCategory);
        System.out.println("departmentid: "+ department);
        System.out.println("------Calculated scenario-----------");
        System.out.println("scenarioid: " + scenario.getId());
        System.out.println("scenario desc: " + scenario.getDescription());
        return "index";
    }

 @GetMapping("/addcontent/{scenarioId}")
    public String addContent(Model model, @PathVariable int scenarioId) {
        Scenario scenario = prmRep.getScenario(scenarioId);
        List<Scenario> scenarios = prmRep.getAllScenarios();
        List<Content> contentList = contentRepos.getContentListbyId(scenario.getId());

        model.addAttribute("scenarios", scenarios);
        model.addAttribute("scenarioId", scenarioId);
        model.addAttribute("scenarioDesc", scenario.getDescription());
        model.addAttribute("contentList", contentList);
        model.addAttribute("content", new Content());
        model.addAttribute("showPrev", scenarioId>1);
        model.addAttribute("showNext",scenarioId<scenarios.size()-1 );
        model.addAttribute("currentPage", scenarioId);

        return "addcontent";
    }

    @PostMapping("/savecontent/{scenarioId}")
    public String set(@ModelAttribute Content content, @PathVariable int scenarioId) {
        int contentId = contentRepos.addContent(content);

        contentRepos.addContentToScenario(contentId,scenarioId);
        return "redirect:/addcontent/{scenarioId}";
    }

    @GetMapping("/removecontent/{contentId}/{scenarioId}")
    public String set(@PathVariable int contentId, @PathVariable int scenarioId) {
        contentRepos.removeContentFromScenario(contentId,scenarioId);
        return "redirect:/addcontent/{scenarioId}";
    }

    @GetMapping("/scenarios")
    public String scenarios(HttpSession session, Model model) {
        List<Scenario> scenarios = prmRep.getAllScenarios();

        scenarios = scenarioService.updateScenarioQty(contentRepos.updateContentQtyPerScenario(scenarios), scenarios);
        model.addAttribute("scenarios", scenarios);
        return "scenarios";
    }
}
