package com.example.Weatherbasedcontent;

public class Locations {

    private Double longitude;
    private Double latitude;
    private String city;
    private String country;

    public Locations(String city,  Double latitude, Double longitude, String country) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.city = city;
        this.country =country;
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
        return city;
    }

    public void setCity(String city) {
        city = city;
    }






}
