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


        System.out.println(date + " temp:" + currentTemp + " symbolnumber:" + currentWeatherStatusNumber);

    }

    private Parameters getWeatherStatusParameter(TimeSeries timeSery) {
        for (int i=0; i < timeSery.getParameters().length;i++){
            if (timeSery.getParameters()[i].getName().equals("Wsymb2")) {
                System.out.println("weatherstatus"+ i);
                return timeSery.getParameters()[i];
            }
        }

        return null;
    }

    private Parameters getTemperatureParameter(TimeSeries timeSery) {

        for (int i=0; i < timeSery.getParameters().length;i++){
            if (timeSery.getParameters()[i].getName().equals("t"))
                return timeSery.getParameters()[i];
        }

        return null;
    }
}
