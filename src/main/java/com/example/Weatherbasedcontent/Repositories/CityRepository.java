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
public class CityRepository {

    @Autowired
    private DataSource dataSource;

    public List<String> getLocationsList() {
        List<String> cities = new ArrayList<String>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select NAME FROM CITY") ) {

            while (rs.next()) {
                cities.add(rs.getString("NAME"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }
}
