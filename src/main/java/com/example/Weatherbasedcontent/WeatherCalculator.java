package com.example.Weatherbasedcontent;
import java.util.Date;

import java.util.List;

public class WeatherCalculator {


    private Weather weather;

    public WeatherCalculator(Weather weather) {
        this.weather = weather;
    }


    public void getCurrentTemp() {



        Date date  =  weather.getTimeSeries()[0].getValidTime(); //Tue Dec 08 12:00:00 CET 2020
        Float currentTemp =  getTemperatureParameter(weather.getTimeSeries()[0]).getValue();

        Float currentWeatherStatusNumber = getWeatherStatusParameter(weather.getTimeSeries()[0]).getValues()[0];

        Float currentWindSpeedNumber = getWindSpeedParameter(weather.getTimeSeries()[0]).getValues()[0];



        System.out.println(date + " temp: " + currentTemp + " | symbolnumber: " + currentWeatherStatusNumber + " | wind speed: " + currentWindSpeedNumber);
        getWeatherCategory(currentWeatherStatusNumber);
    }

    private void getWeatherCategory(Float currentWeatherStatusNumber) {
        String[] weatherSymbolText = {"Clearsky",
                "Nearlyclearsky",
                "Variablecloudiness",
                "Halfclearsky",
                "Cloudysky",
                "Overcast",
                "Fog",
                "Lightrainshowers",
                "Moderaterainshowers",
                "Heavyrainshowers",
                "Thunderstorm",
                "Lightsleetshowers",
                "Moderatesleetshowers",
                "Heavysleetshowers",
                "Lightsnowshowers",
                "Moderatesnowshowers",
                "Heavysnowshowers",
                "Lightrain",
                "Moderaterain",
                "Heavyrain",
                "Thunder",
                "Lightsleet",
                "Moderatesleet",
                "Heavysleet",
                "Lightsnowfall",
                "Moderatesnowfall",
                "Heavysnowfall"};



        if (currentWeatherStatusNumber<=4.0 && currentWeatherStatusNumber>=1.0)
            System.out.println("Sunny");
        else if (currentWeatherStatusNumber<=11.0 && currentWeatherStatusNumber>=8)
            System.out.println("Rain");
        else
            System.out.println(weatherSymbolText[6]);
    }

    private Parameters getWeatherStatusParameter(TimeSeries timeSery) {
        for (int i=0; i < timeSery.getParameters().length;i++){
            if (timeSery.getParameters()[i].getName().equals("Wsymb2")) {
                System.out.println("weatherstatus parameter "+ i);
                return timeSery.getParameters()[i];
            }
        }

        return null;
    }

    private Parameters getTemperatureParameter(TimeSeries timeSery) {

        for (int i=0; i < timeSery.getParameters().length;i++){
            if (timeSery.getParameters()[i].getName().equals("t")){
                System.out.println("temperature parameter "+ i);
                return timeSery.getParameters()[i];
            }

        }

        return null;
    }


    private Parameters getWindSpeedParameter(TimeSeries timeSery) {

        for (int i=0; i < timeSery.getParameters().length;i++){
            if (timeSery.getParameters()[i].getName().equals("ws")){
                System.out.println("Wind Speed parameter "+ i);
                return timeSery.getParameters()[i];
            }

        }

        return null;
    }
}
