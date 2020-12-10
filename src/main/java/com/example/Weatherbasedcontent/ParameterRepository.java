package com.example.Weatherbasedcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ParameterRepository {

    @Autowired
    private DataSource dataSource;
/*
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
    }*/
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


    public int getCurrentSeasonId(Date currentDate, String isoCountry) {

        SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");


        String date= dateFormat.format(currentDate);
        System.out.println(date);
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select ID FROM SEASONPERCOUNTRY WHERE COUNTRYID='"+isoCountry+"' AND DATEFROM<='"+date+"' AND DATETO>='"+date+"'") ) {
//SELECT * FROM SEASONPERCOUNTRY WHERE COUNTRYID='SE' AND DATEFROM<='2020-12-09' AND DATETO>='2020-12-09'
            if (rs.next()) {
                return rs.getInt("ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return 1;
    }



    public int getScenarioId(int seasonId, int weatherId, int tempId, int depId) {
        System.out.println("getScenarioId");
        System.out.println("seasonid:" +seasonId);
        System.out.println("weatherId:" +weatherId);
        System.out.println("tempId:" +tempId);
        System.out.println("depId:" +depId);

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM SCENARIO WHERE SEASONID="+seasonId+ " AND WEATHERSYMBOLID="+weatherId+" AND TEMPERATUREID="+tempId+" AND DEPARTMENTID=" +depId) ) {
//SELECT * FROM SEASONPERCOUNTRY WHERE COUNTRYID='SE' AND DATEFROM<='2020-12-09' AND DATETO>='2020-12-09'
            if (rs.next()) {
                return rs.getInt("ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 1;
    }
}
