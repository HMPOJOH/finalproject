package com.example.Weatherbasedcontent.Repositories;

public class City {
    private Integer id;
    private String name;

    public City(Integer id, String name,  Double longitude, Double latitude, String countryid) {
        this.id = id;
        this.name=name;

    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

}
