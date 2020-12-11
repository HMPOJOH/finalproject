package com.example.Weatherbasedcontent.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



@Repository
public class LocationRepository {

    @Autowired
    private DataSource dataSource;

    public List<City> getLocationsList() {
        List<City> cities = new ArrayList<City>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * FROM CITY") ) {

            while (rs.next()) {
                cities.add(rsCity(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;

    }

    public double getLongitudeByCity(List<City> cities, String city) {

        Double longitude;

        longitude = cities.stream()
                    .filter(x -> city.equals(x.getName())).findAny().orElse(null).getLongitude();

/*
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select LONGITUDE FROM CITY WHERE NAME='" + city + "'") ) {

            if(rs.next()) {
                return  rs.getDouble("LONGITUDE");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


 */


            return longitude;

    }

    public double getLatitudeByCity(List<City> cities, String city) {
       /* try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select LATITUDE FROM CITY WHERE NAME='" + city + "'") ) {

            if(rs.next()) {
                return  rs.getDouble("LATITUDE");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;*/

        Double latitude;

        latitude = cities.stream()
                .filter(x -> city.equals(x.getName())).findAny().orElse(null).getLatitude();
        return latitude;
    }

    public String getCountryIDByCity(List<City> cities,String city) {


       String isoCountry;

        isoCountry = cities.stream()
                .filter(x -> city.equals(x.getName())).findAny().orElse(null).getCountryid();

        return isoCountry;
       /*
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select COUNTRYID FROM CITY WHERE NAME='" + city + "'") ) {

            if(rs.next()) {
                return  rs.getString("COUNTRYID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;*/
    }


    private City rsCity(ResultSet rs) throws SQLException {
        return new City(
                rs.getInt("ID"),
                rs.getString("NAME"),
                rs.getDouble("LONGITUDE"),
                rs.getDouble("LATITUDE"),
                rs.getString("COUNTRYID"));

    }
}
