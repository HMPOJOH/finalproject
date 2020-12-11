package com.example.Weatherbasedcontent.WeatherAPIWW;

import java.util.ArrayList;


public class WeatherRoot {
    private String cod;
    private int message;
    private int cnt;
    private ArrayList<List> list;
    private City city;

    public String getCod() {
        return cod;
    }

    public int getMessage() {
        return message;
    }

    public int getCnt() {
        return cnt;
    }

    public ArrayList<List> getList() {
        return list;
    }

    public City getCity() {
        return city;
    }
}




















