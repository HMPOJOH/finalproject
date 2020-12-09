package com.example.Weatherbasedcontent;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

public class WeatherCalculator {
    private Weather weather;
    private List<WeatherSymbols> weatherSymbols = new ArrayList<WeatherSymbols>();

    public WeatherCalculator(Weather weather) {
        this.weather = weather;
        setupWeatherSymbols();
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

        weatherSymbols.add(new WeatherSymbols("Sunny","https://img.icons8.com/office/30/000000/summer.png","Clear sky"));//1
        weatherSymbols.add(new WeatherSymbols("Sunny","https://img.icons8.com/office/30/000000/summer.png","Nearly clear sky"));//2
        weatherSymbols.add(new WeatherSymbols("Sunny","https://img.icons8.com/office/30/000000/summer.png","Variable cloudiness"));//3
        weatherSymbols.add(new WeatherSymbols("Sunny","https://img.icons8.com/office/30/000000/summer.png","Halfclear sky"));//4
        weatherSymbols.add(new WeatherSymbols("Cloud","https://img.icons8.com/office/30/000000/partly-cloudy-day--v1.png","Cloudy sky"));//5
        weatherSymbols.add(new WeatherSymbols("Cloud","https://img.icons8.com/office/30/000000/clouds.png","Overcast"));//6
        weatherSymbols.add(new WeatherSymbols("Cloud","https://img.icons8.com/office/30/000000/fog-night.png","Fog"));//7
        weatherSymbols.add(new WeatherSymbols("Rain","https://img.icons8.com/office/30/000000/light-rain-2.png","Light rain showers"));//8
        weatherSymbols.add(new WeatherSymbols("Rain","https://img.icons8.com/office/30/000000/moderate-rain.png","Moderate rain showers"));//9
        weatherSymbols.add(new WeatherSymbols("Rain","https://img.icons8.com/office/30/000000/downpour.png","Heavy rain showers"));//10
        weatherSymbols.add(new WeatherSymbols("Rain","https://img.icons8.com/office/30/000000/storm.png","Thunderstorm"));//11
        weatherSymbols.add(new WeatherSymbols("Sleet","https://img.icons8.com/office/30/000000/sleet.png","Light sleet showers"));//12
        weatherSymbols.add(new WeatherSymbols("Sleet","https://img.icons8.com/office/30/000000/sleet.png","Moderate sleet showers"));//13
        weatherSymbols.add(new WeatherSymbols("Sleet","https://img.icons8.com/office/30/000000/sleet.png","Heavy sleet showers"));//14
        weatherSymbols.add(new WeatherSymbols("Snow","https://img.icons8.com/office/30/000000/light-snow.png","Light snow showers"));//15
        weatherSymbols.add(new WeatherSymbols("Snow","https://img.icons8.com/office/30/000000/snow.png","Moderate snow showers"));//16
        weatherSymbols.add(new WeatherSymbols("Snow","https://img.icons8.com/office/30/000000/snow-storm.png","Heavy snow showers"));//17
        weatherSymbols.add(new WeatherSymbols("Rain","https://img.icons8.com/office/30/000000/light-rain-2.png","Light rain"));//18
        weatherSymbols.add(new WeatherSymbols("Rain","https://img.icons8.com/office/30/000000/moderate-rain.png","Moderate rain"));//19
        weatherSymbols.add(new WeatherSymbols("Rain","https://img.icons8.com/office/30/000000/downpour.png","Heavy rain"));//20
        weatherSymbols.add(new WeatherSymbols("Rain","https://img.icons8.com/office/30/000000/storm.png","Thunder"));//21
        weatherSymbols.add(new WeatherSymbols("Sleet","https://img.icons8.com/office/30/000000/sleet.png","Light sleet"));//22
        weatherSymbols.add(new WeatherSymbols("Sleet","https://img.icons8.com/office/30/000000/sleet.png","Moderate sleet"));//23
        weatherSymbols.add(new WeatherSymbols("Sleet","https://img.icons8.com/office/30/000000/sleet.png","Heavy sleet"));//24
        weatherSymbols.add(new WeatherSymbols("Snow","https://img.icons8.com/office/30/000000/light-snow.png","Light snowfall"));//25
        weatherSymbols.add(new WeatherSymbols("Snow","https://img.icons8.com/office/30/000000/snow.png","Moderate snowfall"));//26
        weatherSymbols.add(new WeatherSymbols("Snow","https://img.icons8.com/office/30/000000/snow-storm.png","Heavy snowfall"));//27

    }
    //from SMHI
    public Float getCurrentTemp() {
        Date date  =  weather.getTimeSeries()[0].getValidTime();
        return  getTemperatureParameter(weather.getTimeSeries()[0]).getValue();
    }



    //from SMHI
    public Integer getCurrentWeatherSymbolNumber(){
        return (int)(float)getWeatherStatusParameter(weather.getTimeSeries()[0]).getValues()[0];
    }
    //from SMHI
    public Float getCurrentWindSpeed(){
        return getWindSpeedParameter(weather.getTimeSeries()[0]).getValues()[0];
    }
    //internal lookup
    public String getWeatherCategory(int weatherSymbolNumber) {
        return weatherSymbols.get(weatherSymbolNumber-1).getCategory(); //list starts with 0
    }
    //internal lookup
    public String getWeatherCategoryImage(int weatherSymbolNumber) {
        return weatherSymbols.get(weatherSymbolNumber-1).getImage();  //list starts with 0
    }
    //internal lookup
    public String getCurrentWeatherSymbolText(int weatherSymbolNumber) {
        return weatherSymbols.get(weatherSymbolNumber-1).getName();  //list starts with 0
    }

    public Date getCurrentDate (){
        return weather.getTimeSeries()[0].getValidTime();
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
