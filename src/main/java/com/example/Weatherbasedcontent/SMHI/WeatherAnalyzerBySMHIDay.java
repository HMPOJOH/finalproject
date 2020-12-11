package com.example.Weatherbasedcontent.SMHI;
import com.example.Weatherbasedcontent.SMHI.Parameters;
import com.example.Weatherbasedcontent.SMHI.SMHIDays;
import com.example.Weatherbasedcontent.SMHI.TimeSeries;
import com.example.Weatherbasedcontent.SMHI.Weather;
import com.example.Weatherbasedcontent.WeatherSymbols;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class WeatherAnalyzerBySMHIDay {
    private Weather weather;
    private List<WeatherSymbols> weatherSymbols = new ArrayList<WeatherSymbols>();
    private SMHIDays smhiDay;
    private int timeSerieIndex;

    public WeatherAnalyzerBySMHIDay(Weather weather, SMHIDays smhiDay ) {
        this.weather = weather;
        this.smhiDay=smhiDay;
        setupWeatherSymbols();
        timeSerieIndex=getTimeSerieIndex(smhiDay);
    }


    /*

    INSERT INTO TEMPERATURE (DESCRIPTION) VALUES ('Hot');
INSERT INTO TEMPERATURE (DESCRIPTION) VALUES ('Warm');
INSERT INTO TEMPERATURE (DESCRIPTION) VALUES ('Cold');
INSERT INTO TEMPERATURE (DESCRIPTION) VALUES ('Very cold');
INSERT INTO TEMPERATURE (DESCRIPTION) VALUES ('Average');

Jättevarmt	- 28+
Varmt		- 22 - 27
Lite varmt	- 14 - 21
Lite kallt	- 4 - 13
Kallt		- 3 - -9
Jättekallt	- -10 ->
     */
    private void setupWeatherSymbols() {
        /*

        	Sunny
2	Rain
3	Snow
4	Windy
5	Sleet
6	All
         */

        weatherSymbols.add(new WeatherSymbols("Sunny",1,"https://img.icons8.com/office/30/000000/summer.png","Clear sky"));//1
        weatherSymbols.add(new WeatherSymbols("Sunny",1,"https://img.icons8.com/office/30/000000/summer.png","Nearly clear sky"));//2
        weatherSymbols.add(new WeatherSymbols("Sunny",1,"https://img.icons8.com/office/30/000000/summer.png","Variable cloudiness"));//3
        weatherSymbols.add(new WeatherSymbols("Sunny",1,"https://img.icons8.com/office/30/000000/summer.png","Halfclear sky"));//4
        weatherSymbols.add(new WeatherSymbols("Cloud",6,"https://img.icons8.com/office/30/000000/partly-cloudy-day--v1.png","Cloudy sky"));//5
        weatherSymbols.add(new WeatherSymbols("Cloud",6,"https://img.icons8.com/office/30/000000/clouds.png","Overcast"));//6
        weatherSymbols.add(new WeatherSymbols("Cloud",6,"https://img.icons8.com/office/30/000000/fog-night.png","Fog"));//7
        weatherSymbols.add(new WeatherSymbols("Rain",2,"https://img.icons8.com/office/30/000000/light-rain-2.png","Light rain showers"));//8
        weatherSymbols.add(new WeatherSymbols("Rain",2,"https://img.icons8.com/office/30/000000/moderate-rain.png","Moderate rain showers"));//9
        weatherSymbols.add(new WeatherSymbols("Rain",2,"https://img.icons8.com/office/30/000000/downpour.png","Heavy rain showers"));//10
        weatherSymbols.add(new WeatherSymbols("Rain",2,"https://img.icons8.com/office/30/000000/storm.png","Thunderstorm"));//11
        weatherSymbols.add(new WeatherSymbols("Sleet",5,"https://img.icons8.com/office/30/000000/sleet.png","Light sleet showers"));//12
        weatherSymbols.add(new WeatherSymbols("Sleet",5,"https://img.icons8.com/office/30/000000/sleet.png","Moderate sleet showers"));//13
        weatherSymbols.add(new WeatherSymbols("Sleet",5,"https://img.icons8.com/office/30/000000/sleet.png","Heavy sleet showers"));//14
        weatherSymbols.add(new WeatherSymbols("Snow",3,"https://img.icons8.com/office/30/000000/light-snow.png","Light snow showers"));//15
        weatherSymbols.add(new WeatherSymbols("Snow",3,"https://img.icons8.com/office/30/000000/snow.png","Moderate snow showers"));//16
        weatherSymbols.add(new WeatherSymbols("Snow",3,"https://img.icons8.com/office/30/000000/snow-storm.png","Heavy snow showers"));//17
        weatherSymbols.add(new WeatherSymbols("Rain",2,"https://img.icons8.com/office/30/000000/light-rain-2.png","Light rain"));//18
        weatherSymbols.add(new WeatherSymbols("Rain",2,"https://img.icons8.com/office/30/000000/moderate-rain.png","Moderate rain"));//19
        weatherSymbols.add(new WeatherSymbols("Rain",2,"https://img.icons8.com/office/30/000000/downpour.png","Heavy rain"));//20
        weatherSymbols.add(new WeatherSymbols("Rain",2,"https://img.icons8.com/office/30/000000/storm.png","Thunder"));//21
        weatherSymbols.add(new WeatherSymbols("Sleet",5,"https://img.icons8.com/office/30/000000/sleet.png","Light sleet"));//22
        weatherSymbols.add(new WeatherSymbols("Sleet",5,"https://img.icons8.com/office/30/000000/sleet.png","Moderate sleet"));//23
        weatherSymbols.add(new WeatherSymbols("Sleet",5,"https://img.icons8.com/office/30/000000/sleet.png","Heavy sleet"));//24
        weatherSymbols.add(new WeatherSymbols("Snow",4,"https://img.icons8.com/office/30/000000/light-snow.png","Light snowfall"));//25
        weatherSymbols.add(new WeatherSymbols("Snow",4,"https://img.icons8.com/office/30/000000/snow.png","Moderate snowfall"));//26
        weatherSymbols.add(new WeatherSymbols("Snow",4,"https://img.icons8.com/office/30/000000/snow-storm.png","Heavy snowfall"));//27


    }
    //from SMHI
    public Float getTemp() {


        Date date  =  weather.getTimeSeries()[timeSerieIndex].getValidTime();
        return  getTemperatureParameter(weather.getTimeSeries()[timeSerieIndex]).getValue();
    }

    private int getTimeSerieIndex(SMHIDays smhiDay) {
        int index = 0;
        //create a variable to compare
        LocalDateTime today13 = LocalDate.now().atTime(13,0);

        switch (smhiDay) {
            case TODAY:
                index= 0;
               break;
            case TOMORROW:
                System.out.println();
                for (int i=0; i<weather.getTimeSeries().length;i++){
                    if(formatDateTime(today13, 1).equals(formatDate(weather.getTimeSeries()[i]))) {
                        index = i;
                        break;
                    }
                }
                break;
            case DAY_THREE:
                for (int i=0; i<weather.getTimeSeries().length;i++){
                    if(formatDateTime(today13, 2).equals(formatDate(weather.getTimeSeries()[i]))) {
                        index = i;
                        break;
                    }
                }
                break;
            case DAY_FOUR:
                for (int i=0; i<weather.getTimeSeries().length;i++){
                    if(formatDateTime(today13, 5).equals(formatDate(weather.getTimeSeries()[i]))) {
                        index = i;
                        break;
                    }
                }
                break;
            case DAY_FIVE:
                for (int i=0; i<weather.getTimeSeries().length;i++){
                    if(formatDateTime(today13, 6).equals(formatDate(weather.getTimeSeries()[i]))) {
                        index = i;
                        break;
                    }
                }
                break;

        }

        System.out.println("SMHIindex: " +index );
        return index;
    }

    private String formatDate(TimeSeries timeSery) {

        SimpleDateFormat comparePattern = new SimpleDateFormat ("yyyy-MM-dd:HH");
        return comparePattern.format(timeSery.getValidTime());
    }

    private String formatDateTime(LocalDateTime today13, int days) {

        return today13.plusDays(days).format(DateTimeFormatter.ofPattern("yyyy-MM-dd:HH"));

    }


    //from SMHI
    public Integer getWeatherSymbolNumber(){
        return (int)(float)getWeatherStatusParameter(weather.getTimeSeries()[timeSerieIndex]).getValues()[0];
    }
    //from SMHI
    public Float getWindSpeed(){
        return getWindSpeedParameter(weather.getTimeSeries()[timeSerieIndex]).getValues()[0];
    }
    //internal lookup
    public String getWeatherCategory(int weatherSymbolNumber) {
        return weatherSymbols.get(weatherSymbolNumber-1).getCategory(); //list starts with 0
    }

    public int getWeatherCategoryId(int weatherSymbolNumber){
        return weatherSymbols.get(weatherSymbolNumber-1).getCategoryId(); //list starts with 0
    }

    //internal lookup
    public String getWeatherCategoryImage(int weatherSymbolNumber) {
        return weatherSymbols.get(weatherSymbolNumber-1).getImage();  //list starts with 0
    }
    //internal lookup
    public String getWeatherSymbolText(int weatherSymbolNumber) {
        return weatherSymbols.get(weatherSymbolNumber-1).getName();  //list starts with 0
    }

    public Date getDateFromTimeSerieOfChoice(){
        return weather.getTimeSeries()[timeSerieIndex].getValidTime();
    }



    //help method SMHI
    private Parameters getWeatherStatusParameter(TimeSeries timeSery) {
        for (int i=0; i < timeSery.getParameters().length;i++){
            if (timeSery.getParameters()[i].getName().equals("Wsymb2")) {

                return timeSery.getParameters()[i];
            }
        }

        return null;
    }

    //help method SMHI
    private Parameters getTemperatureParameter(TimeSeries timeSery) {

        for (int i=0; i < timeSery.getParameters().length;i++){
            if (timeSery.getParameters()[i].getName().equals("t")){

                return timeSery.getParameters()[i];
            }

        }

        return null;
    }

    //help method SMHI
    private Parameters getWindSpeedParameter(TimeSeries timeSery) {

        for (int i=0; i < timeSery.getParameters().length;i++){
            if (timeSery.getParameters()[i].getName().equals("ws")){

                return timeSery.getParameters()[i];
            }

        }

        return null;
    }


    public int getTempCategory(Float currentTemp) {
        if (currentTemp>=28)
            return 1;
        else if (currentTemp>=22 && currentTemp<28)
            return 2;
        else if (currentTemp>=4 && currentTemp<22)
            return 5;
        else if (currentTemp>=-3 && currentTemp<4)
            return 3;
        else
            return 4;


            /*


1	Hot
2	Warm
3	Cold
4	Very cold
5	Average


Jättevarmt	- 28+
Varmt		- 22 - 27
Lite varmt	- 14 - 21
Lite kallt	- 4 - 13
Kallt		- 3 - -9
Jättekallt	- -10 ->
     */
    }
}
