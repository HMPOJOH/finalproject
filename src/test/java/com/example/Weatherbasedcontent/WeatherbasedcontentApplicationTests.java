package com.example.Weatherbasedcontent;

import com.example.Weatherbasedcontent.Repositories.*;
import com.example.Weatherbasedcontent.WeatherAPIWW.ForecastDays;
import com.example.Weatherbasedcontent.WeatherAPIWW.WeatherAnalyzer;
import com.example.Weatherbasedcontent.WeatherAPIWW.WeatherRoot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class WeatherbasedcontentApplicationTests {
	@Autowired
	private ParameterRepository prmRep;
	@Autowired
	private ContentRepository productRepos;

	//check that the external weather API is available
	@Test
	void isWeatherAvailable() {
		//do we get a response from the weather API
		RestTemplate restTemplate = new RestTemplate();
		WeatherAnalyzer analyzeWeatherAPI;
		WeatherRoot weatherFromAPI =restTemplate.getForObject("https://api.openweathermap.org/data/2.5/forecast?q=Stockholm&appid=0de04dc3bae5ebc08ee10c77aabe6215&units=metric", WeatherRoot.class);
		analyzeWeatherAPI = new WeatherAnalyzer(weatherFromAPI, ForecastDays.TODAY);
		float temperature = analyzeWeatherAPI.getTemp();
		System.out.println("temp in Stockholm: " + temperature);
		boolean result = false;
		if (temperature != 0)
			result = true;
		Assertions.assertTrue(result);
	}

	//check that at all 4 seasons exist in Season table
	@Test
	void checkSeason() {
		String seasonDesc = prmRep.getSeasonDesc(1);
		System.out.println("season desc " + seasonDesc);
		Assertions.assertEquals("Summer",seasonDesc);
		seasonDesc = prmRep.getSeasonDesc(2);
		Assertions.assertEquals("Winter",seasonDesc);
		seasonDesc = prmRep.getSeasonDesc(3);
		Assertions.assertEquals("Spring",seasonDesc);
		seasonDesc = prmRep.getSeasonDesc(4);
		Assertions.assertEquals("Autumn",seasonDesc);
	}

	// check that department list is not empty
	@Test
	void checkDepartments() {
		List<Department> department = prmRep.getDepList();
		Assertions.assertTrue(department.size() > 0);
	}

	// check that scenario list is not empty
	@Test
	void checkScenarios() {
		List<Scenario> scenarios = prmRep.getAllScenarios();
		Assertions.assertTrue(scenarios.size() > 0);
	}

	//check there is some content for each season
	/* comment this out since we right now dont have content for all seasons in database. Needs to be added.
	@Test
	void checkContentBySeason() {
		List<Content> content = productRepos.getSeasonFallback(1); // summer content
		Assertions.assertTrue(content.size() > 0);
		content = productRepos.getSeasonFallback(2); // winter content
		Assertions.assertTrue(content.size() > 0);
		content = productRepos.getSeasonFallback(3); // spring content
		Assertions.assertTrue(content.size() > 0);
		content = productRepos.getSeasonFallback(4); // autumn content
		Assertions.assertTrue(content.size() > 0);
	}
	*/
	 
}
