package com.example.Weatherbasedcontent.WeatherAPIWW;

public class City{
    private int id;
    private String name;
    private Coord coord;
    private String country;
    private int population;
    private int timezone;
    private int sunrise;
    private int sunset;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coord getCoord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    public int getTimezone() {
        return timezone;
    }

    public int getSunrise() {
        return sunrise;
    }

    public int getSunset() {
        return sunset;
    }
}