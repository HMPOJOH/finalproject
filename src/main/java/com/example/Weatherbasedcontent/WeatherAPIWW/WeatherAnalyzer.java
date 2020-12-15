package com.example.Weatherbasedcontent.WeatherAPIWW;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class WeatherAnalyzer {
    private ForecastDays forecastDays;
    private WeatherRoot weatherFromAPI;
    private int listIndex;

    public WeatherAnalyzer(WeatherRoot weatherFromAPI, ForecastDays forecastDays){
        this.forecastDays=forecastDays;
        this.weatherFromAPI=weatherFromAPI;

        listIndex=getIndex(forecastDays);
    }

    public Float getTemp(){

        return (float)weatherFromAPI.getList().get(listIndex).getMain().getTemp();
    }

    public int getWeatherCategory(){

        String mainWeather = weatherFromAPI.getList().get(listIndex).getWeather().get(0).getMain();
        int weatherId = weatherFromAPI.getList().get(listIndex).getWeather().get(0).getId();
        /*
        if	main		Cat	return
	Thunderstorm		windy	4
	Drizzle		rain	2
	Rain		rain	2
	Clear		sun	1
	cloud		cloud	6

	id
if	id(600->602)		snow	3
	id(613-622)		sleet	5

if	781			4
	else			6

         */

        System.out.println(weatherId);

        if (mainWeather.equals("Thunderstorm"))
                return 4;
        else if(mainWeather.equals("Drizzle"))
                return 2;
        else if(mainWeather.equals("Rain"))
            return 2;
        else if(mainWeather.equals("Clear"))
            return 1;
        else if(mainWeather.equals("Clouds"))
            return 6;
        else if(weatherId>=600
        && weatherId<=602)
            return 3;
        else if(weatherId>=613
                && weatherId<=622)
            return 5;
        else if(weatherId==781
                )
            return 4;





        return 6;
    }


    private int getIndex(ForecastDays forecastDays) {
    int index = 0;
        LocalDateTime lDTNow = LocalDateTime.now();
        System.out.println(forecastDays);

        switch (forecastDays) {
            case TODAY:
                index= 0;
                break;
            case TOMORROW:
                for (int i=0; i<weatherFromAPI.getList().size();i++){
                    if(isCorrectDay(i,lDTNow,1)) {
                        index = i;
                        break;
                    }
                }
                break;
            case DAY_THREE:
                for (int i=0; i<weatherFromAPI.getList().size();i++){
                    if(isCorrectDay(i,lDTNow,2)) {
                        index = i;
                        break;
                    }
                }

                break;
            case DAY_FOUR:
                for (int i=0; i<weatherFromAPI.getList().size();i++){
                    if(isCorrectDay(i,lDTNow,3)) {
                        index = i;
                        break;
                    }
                }
                break;
            case DAY_FIVE:
                for (int i=0; i<weatherFromAPI.getList().size();i++){
                    if(isCorrectDay(i,lDTNow,4)) {
                        index = i;
                        break;
                    }
                }

                break;

        }

        System.out.println("WWindex: " +index );
        return index;
    }

    private boolean isCorrectDay(int i, LocalDateTime lDTNow, int addDays) {


        if(formatDateTimePlusXDay(lDTNow, addDays).equals(weatherFromAPI.getList().get(i).getDt_txt().substring(0,13)))
            return true;
        else if(formatDateTimePlusXDayAndOneHour(lDTNow, addDays).equals(weatherFromAPI.getList().get(i).getDt_txt().substring(0,13)))
            return true;
        else if(formatDateTimePlusXDayAndTwoHours(lDTNow, addDays).equals(weatherFromAPI.getList().get(i).getDt_txt().substring(0,13)))
            return true;
        else
            return false;
    }

    private String formatDateTimePlusXDay(LocalDateTime lDTNow, int i) {
        return lDTNow.plusDays(i).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH"));
    }

    private String formatDateTimePlusXDayAndOneHour(LocalDateTime lDTNow, int i) {
        return lDTNow.plusDays(i).plusHours(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH"));
    }
    private String formatDateTimePlusXDayAndTwoHours(LocalDateTime lDTNow, int i) {
        return lDTNow.plusDays(i).plusHours(2).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH"));
    }


    public int getTempCategory(Float currentTemp) {
        if (currentTemp >= 28)
            return 1;
        else if (currentTemp >= 22 && currentTemp < 28)
            return 2;
        else if (currentTemp >= 4 && currentTemp < 22)
            return 5;
        else if (currentTemp >= -3 && currentTemp < 4)
            return 3;
        else
            return 4;
    }

    public float getWindSpeed() {

        return (float)weatherFromAPI.getList().get(listIndex).getWind().getSpeed();
    }

    public String getDateForSpecificDay() {
        return weatherFromAPI.getList().get(listIndex).getDt_txt();
    }

    public String getWeatherCategoryImage() {

        String picture = "";
        System.out.println("picture icon:"+ weatherFromAPI.getList().get(listIndex).getWeather().get(0).getIcon().equals("01n"));

        if (weatherFromAPI.getList().get(listIndex).getWeather().get(0).getIcon().equals("01n"))  //Converting night clear sky to day clear sky
            picture="01d";
        else
            picture = weatherFromAPI.getList().get(listIndex).getWeather().get(0).getIcon();

        return "https://openweathermap.org/img/wn/" + picture+ "@2x.png";
    }

    public String getWeatherDesc() {
        return weatherFromAPI.getList().get(listIndex).getWeather().get(0).getDescription();
    }
}
