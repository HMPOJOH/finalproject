package com.example.Weatherbasedcontent.WeatherAPIWW;

import java.util.ArrayList;

public class List{
    private int dt;
    private Main main;
    private ArrayList<Weather> weather;
    private Clouds clouds;
    private Wind wind;
    private int visibility;
    private double pop;
    private Sys sys;
    private String dt_txt;
    private Snow snow;
    private Rain rain;

    public int getDt() {
        return dt;
    }

    public Main getMain() {
        return main;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public int getVisibility() {
        return visibility;
    }

    public double getPop() {
        return pop;
    }

    public Sys getSys() {
        return sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public Snow getSnow() {
        return snow;
    }

    public Rain getRain() {
        return rain;
    }
}