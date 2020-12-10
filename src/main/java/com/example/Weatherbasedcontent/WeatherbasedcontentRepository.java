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
public class WeatherbasedcontentRepository {

    @Autowired
    private DataSource dataSource;





    public List<Content> getContentList(int searchScenario) {
        List<Content> content = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select CONTENT.ID AS CONTENTID, CONTENT.IMAGE AS IMAGE, CONTENT.URL AS URL, CONTENT.TEXT AS TEXT, SCENARIO.DESCRIPTION AS SCENARIO\n" +
                     "FROM CONTENTBYSCENARIO \n" +
                     "JOIN CONTENT ON CONTENT.ID = CONTENTBYSCENARIO.CONTENTID\n" +
                     "JOIN SCENARIO ON SCENARIO.ID = CONTENTBYSCENARIO.SCENARIOID\n" +
                     "WHERE CONTENTBYSCENARIO.SCENARIOID =" + searchScenario)) {

            while (rs.next()) {
                content.add(rsContent(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return content;
    }

    private Content rsContent(ResultSet rs) throws SQLException {
        return new Content(
                rs.getInt("CONTENTID"),
                rs.getString("IMAGE"),
                rs.getString("URL"),
                rs.getString("TEXT"));
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



    public int getScenarioId(int seasonId, int weatherId, int tempId, String depId) {
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
