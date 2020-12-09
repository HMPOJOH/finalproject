package com.example.Weatherbasedcontent;

import java.util.ArrayList;
import java.util.List;

public class LocationRepository {



    private List<Locations> locationsList = new ArrayList<Locations>();


    public LocationRepository(){
        locationsList.add(new Locations("Stockholm", 59.325117, 18.071093, "SE"));
        locationsList.add(new Locations("Göteborg", 57.707232, 11.967017, "SE"));
        locationsList.add(new Locations("Malmö", 55.60617, 13.006, "SE"));
        locationsList.add(new Locations("Umeå", 63.830490, 20.265303, "SE"));
        locationsList.add(new Locations("Köpenhamn", 55.682,  2.524, "SE"));

    }


    public List<Locations> getLocationsList() {
        return locationsList;
    }

    public double getLongitudeByCity(String city) {
        for (int i=0;i<locationsList.size();i++)
            if (city.equals(locationsList.get(i).getCity()))
                return locationsList.get(i).getLongitude();

            return 0.0;

    }

    public double getLatitudeByCity(String city) {
        for (int i=0;i<locationsList.size();i++)
            if (city.equals(locationsList.get(i).getCity()))
                return locationsList.get(i).getLatitude();

        return 0.0;
    }
}
