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
        Float currentTemp =  weather.getTimeSeries()[0].getParameters()[1].getValue();
        System.out.println(date + " " + currentTemp);

    }
}
