package com.example.Weatherbasedcontent.WeatherAPIWW;

public class Weather{
    private int id;
    private String main;
    private String description;
    private String icon;

    public int getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main=main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}