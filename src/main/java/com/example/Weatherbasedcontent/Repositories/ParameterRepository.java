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

    //find suitable scenario depending on season, weather and department
    public Scenario getScenarioByValues(int seasonId, int weatherId, int tempId, int depId) {
        Scenario scenario = new Scenario(-1,"no scenario","WinterDay.jpg");

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
        }
        //fallback in case no scenario found
        scenario.setDescription("Show: " + getSeasonDesc(seasonId) + ", " + getWeatherDesc(weatherId) + ", " + getDepDesc(depId));
        if (weatherId == 2) //rain
            scenario.setBackground("RainyDay.jpg");
        else if (seasonId == 1)
            scenario.setBackground("SummerDay.jpg");
        else if (seasonId == 3)
            scenario.setBackground("SpringDay.jpg");
        else if (seasonId == 4)
            scenario.setBackground("FallDay.jpg");
        return scenario;
    }

    // find scenario by Id (exact match)
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

    // get season description
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

    //get department description
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

    //get weather description
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

    //decide suitable season to show content for
    // 1. if the weather is hot or warm, choose summer season regardless of date
    // 2. if the weather is very cold, choose winter season regardless of date
    // 3. choose season depending on when each season start for each country ,see table seasonByCountry
    public int decideSeason(String date, String isoCountry, int tempCategory) {
        int decidedSeason = 2;
        if (tempCategory == 1 || tempCategory == 2) //hot or warm
            decidedSeason = 1; //summer
        else if (tempCategory == 4) //very cold
            decidedSeason = 2; //winter
        else
            decidedSeason = getSeasonIdbyDateAndCountry(date, isoCountry);
        return decidedSeason;
    }

    public int getSeasonIdbyDateAndCountry(String date, String isoCountry) {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select SEASONID FROM SEASONPERCOUNTRY WHERE COUNTRYID='"+isoCountry+"' AND DATEFROM<='"+date.substring(0,10)+"' AND DATETO>='"+date.substring(0,10)+"'") ) {
                if (rs.next()) {
                    return rs.getInt("SEASONID");
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    /* not used?
    public int getScenarioId(int seasonId, int weatherId, int tempId, int depId) {
        System.out.println("getScenarioId");
        System.out.println("seasonid:" +seasonId);
        System.out.println("weatherId:" +weatherId);
        System.out.println("tempId:" +tempId);
        System.out.println("depId:" +depId);

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM SCENARIO WHERE SEASONID="+seasonId+ " AND WEATHERSYMBOLID="+weatherId+" AND TEMPERATUREID="+tempId+" AND DEPARTMENTID=" +depId) ) {
                if (rs.next()) {
                    return rs.getInt("ID");
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    } */
}
