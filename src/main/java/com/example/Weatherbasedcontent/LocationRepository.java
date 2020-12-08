package com.example.Weatherbasedcontent;

import java.util.ArrayList;
import java.util.List;

public class LocationRepository {



    private List<Locations> locationsList = new ArrayList<Locations>();


    public LocationRepository(){
        locationsList.add(new Locations("Stockholm", 59.325117, 18.071093));
        locationsList.add(new Locations("Göteborg", 57.707232, 11.967017));
    }


    public List<Locations> getLocationsList() {
        return locationsList;
    }
}
