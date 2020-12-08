package com.example.Weatherbasedcontent;

public class Locations {

    private Double longitude;
    private Double latitude;
    private String City;

    public Locations(String city,  Double latitude, Double longitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        City = city;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }






}
