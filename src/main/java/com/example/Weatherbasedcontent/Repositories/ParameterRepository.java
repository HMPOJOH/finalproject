package com.example.Weatherbasedcontent.Repositories;

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

    public List<Scenario> getAllScenarios() {
        List<Scenario> scenarios = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select ID, DESCRIPTION, BACKGROUND FROM SCENARIO")) {

            while (rs.next()) {
                scenarios.add(rsScenario(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scenarios;
    }

    private Scenario rsScenario(ResultSet rs) throws SQLException {
        return new Scenario(
                rs.getInt("ID"),
                rs.getString("DESCRIPTION"),
                rs.getString("BACKGROUND"));
    }




    public Scenario getScenariobyValues(int seasonId, int weatherId, int tempId, int depId) {
        Scenario scenario = new Scenario(1,"no scenario","WinterDay.jpg");

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM SCENARIO WHERE SEASONID="+seasonId+ " AND WEATHERSYMBOLID="+weatherId+" AND TEMPERATUREID="+tempId+" AND DEPARTMENTID=" +depId) ) {

            if (rs.next()) {
                scenario.setId(rs.getInt("ID"));
                scenario.setDescription("Scenario: " + rs.getString("DESCRIPTION"));
                scenario.setBackground(rs.getString("BACKGROUND"));
                return scenario;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } //fallback in case no scenario..
        System.out.println("seasonId:" + seasonId);
        System.out.println("weatherId:" + weatherId);
        System.out.println("depId:" + depId);
        scenario.setDescription("Show: " + getSeasonDesc(seasonId) + ", " + getWeatherDesc(weatherId) + ", " + getDepDesc(depId));
        if (seasonId == 1)
            scenario.setBackground("SummerDay.jpg");
        else if (seasonId == 3)
            scenario.setBackground("SpringDay.jpg");
        else if (seasonId == 4)
            scenario.setBackground("RainyDay.jpg");
        return scenario;
    }

    public Scenario getScenario(int scenarioId) {
        Scenario scenario = new Scenario(1,"no scenario","WinterDay.jpg");

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM SCENARIO WHERE ID="+scenarioId) ) {

            if (rs.next()) {
                scenario.setId(rs.getInt("ID"));
                scenario.setDescription(rs.getString("DESCRIPTION"));
                scenario.setBackground(rs.getString("BACKGROUND"));
                return scenario;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return scenario;
    }

    public String getSeasonDesc(int seasonId) {

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT DESCRIPTION FROM SEASON WHERE ID="+seasonId) ) {

            if (rs.next()) {
                return rs.getString("DESCRIPTION");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return " ";
    }

    public String getDepDesc(int depId) {

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT DESCRIPTION FROM DEPARTMENT WHERE ID="+depId) ) {

            if (rs.next()) {
                return rs.getString("DESCRIPTION");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return " ";
    }

    public String getWeatherDesc(int weatherSymbolId) {

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT DESCRIPTION FROM WEATHERSYMBOL WHERE ID="+weatherSymbolId) ) {

            if (rs.next()) {
                return rs.getString("DESCRIPTION");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return " ";
    }

    //ny
    public int getSeasonIdbyDateAndCountry(String date, String isoCountry) {


        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select SEASONID FROM SEASONPERCOUNTRY WHERE COUNTRYID='"+isoCountry+"' AND DATEFROM<='"+date.substring(0,9)+"' AND DATETO>='"+date.substring(0,9)+"'") ) {
//SELECT * FROM SEASONPERCOUNTRY WHERE COUNTRYID='SE' AND DATEFROM<='2020-12-09' AND DATETO>='2020-12-09'
            if (rs.next()) {
                return rs.getInt("SEASONID");
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
