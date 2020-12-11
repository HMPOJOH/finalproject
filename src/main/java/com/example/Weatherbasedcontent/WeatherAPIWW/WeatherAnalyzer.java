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

        if (weatherFromAPI.getList().get(listIndex).getWeather().get(0).getMain().equals("Thunderstorm"))
                return 4;
        else if(weatherFromAPI.getList().get(listIndex).getWeather().get(0).getMain().equals("Drizzle"))
                return 2;
        else if(weatherFromAPI.getList().get(listIndex).getWeather().get(0).getMain().equals("Rain"))
            return 2;
        else if(weatherFromAPI.getList().get(listIndex).getWeather().get(0).getMain().equals("Clear"))
            return 1;
        else if(weatherFromAPI.getList().get(listIndex).getWeather().get(0).getMain().equals("Cloud"))
            return 6;
        else if(weatherFromAPI.getList().get(listIndex).getWeather().get(0).getId()>=600
        || weatherFromAPI.getList().get(listIndex).getWeather().get(0).getId()<=602)
            return 3;
        else if(weatherFromAPI.getList().get(listIndex).getWeather().get(0).getId()>=613
                || weatherFromAPI.getList().get(listIndex).getWeather().get(0).getId()<=622)
            return 5;
        else if(weatherFromAPI.getList().get(listIndex).getWeather().get(0).getId()==781
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

        return "https://openweathermap.org/img/wn/" + weatherFromAPI.getList().get(listIndex).getWeather().get(0).getIcon()+ "@2x.png";
    }

    public String getWeatherSymbolText() {
        return weatherFromAPI.getList().get(listIndex).getWeather().get(0).getDescription();
    }
}
