package com.example.Weatherbasedcontent;

public class City {
    private Integer id;
    private String name;



    private Double longitude;
    private Double latitude;
    private String countryid;

    public City(Integer id, String name,  Double longitude, Double latitude, String countryid) {
        this.id = id;
        this.name=name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.countryid = countryid;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public String getCountryid() {
        return countryid;
    }
}
