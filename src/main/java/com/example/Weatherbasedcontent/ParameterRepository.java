package com.example.Weatherbasedcontent;

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
public class ParameterRepository {

    @Autowired
    private DataSource dataSource;

    public int getSeason(String chosenDate, String country) {
        int season = 1;

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select ID FROM SEASONBYCOUNTRY WHERE \n" +
                     "COUNTRYID=" + country + " AND \n" +
                     "DATEFROM <=" + chosenDate + " AND \n" +
                     "DATETO >=" + chosenDate)) {

            while (rs.next()) {
                season = rs.getInt("ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return season;
    }
    public List<Department> getDepList() {
        List<Department> department = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select ID, DESCRIPTION FROM DEPARTMENT")) {

            while (rs.next()) {
                department.add(rsDep(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    private Department rsDep(ResultSet rs) throws SQLException {
        return new Department(
                rs.getInt("ID"),
                rs.getString("DESCRIPTION"));
    }
}
