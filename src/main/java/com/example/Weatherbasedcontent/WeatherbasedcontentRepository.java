package com.example.Weatherbasedcontent;

import com.example.Weatherbasedcontent.Repositories.Content;
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
public class WeatherbasedcontentRepository {

    @Autowired
    private DataSource dataSource;





    public List<Content> getContentList(int searchScenario, int seasonId, int departmentId, int weatherCatId) {
        List<Content> content = new ArrayList<>();
        int contentCount = 0;
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select CONTENT.ID AS CONTENTID, CONTENT.IMAGE AS IMAGE, CONTENT.URL AS URL, CONTENT.TEXT AS TEXT, SCENARIO.DESCRIPTION AS SCENARIO\n" +
                     "FROM CONTENTBYSCENARIO \n" +
                     "JOIN CONTENT ON CONTENT.ID = CONTENTBYSCENARIO.CONTENTID\n" +
                     "JOIN SCENARIO ON SCENARIO.ID = CONTENTBYSCENARIO.SCENARIOID\n" +
                     "WHERE CONTENTBYSCENARIO.SCENARIOID =" + searchScenario)) {

            while (rs.next()) {
                content.add(rsContent(rs));
                contentCount +=1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Content count 1: " + contentCount);
        // fetch fallback content if not enough content
        if (contentCount < 5 ) {
            List<Content> contentTemp = new ArrayList<>();
            if (departmentId == 7) //All departments, fetch content by season and weathersymbol
                contentTemp = getContentWeatherFallback(seasonId, weatherCatId);
            else                    //fetch content by season and department
                contentTemp = getContentDepFallback(seasonId, departmentId);
            for (int i=0;i<(contentTemp.size()-1);i++) {
                content.add(contentTemp.get(i));
                contentCount +=1;
                if (contentCount == 5)
                    break;
            }
            System.out.println("Content count 2: " + contentCount);
        }
        // fetch fallback content from season if not enough content
        if (contentCount < 5 ) {
            List<Content> contentTemp = getSeasonFallback(seasonId);
            for (int i=0;i<(contentTemp.size()-1);i++) {
                content.add(contentTemp.get(i));
                contentCount +=1;
                if (contentCount == 5)
                    break;
            }
            System.out.println("Content count 3: " + contentCount);
        }
        return content;
    }

    //fetch all content with correct season and department. Dont care about weathersymbol or temperature
    public List<Content> getContentDepFallback(int seasonId, int departmentId) {
        List<Content> content = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select CONTENT.ID AS CONTENTID, CONTENT.IMAGE AS IMAGE, CONTENT.URL AS URL, CONTENT.TEXT AS TEXT, SCENARIO.DESCRIPTION AS SCENARIO\n" +
                     "FROM CONTENTBYSCENARIO \n" +
                     "JOIN CONTENT ON CONTENT.ID = CONTENTBYSCENARIO.CONTENTID\n" +
                     "JOIN SCENARIO ON SCENARIO.ID = CONTENTBYSCENARIO.SCENARIOID\n" +
                     "WHERE SCENARIO.SEASONID =" + seasonId + "\n" +
                     "AND SCENARIO.DEPARTMENTID =" + departmentId)) {

            while (rs.next()) {
                content.add(rsContent(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return content;
    }

    //fetch all content with correct season and weathersymbol (snow, rain etc). Dont care about deprtment or temperature
    public List<Content> getContentWeatherFallback(int seasonId, int weatherCat) {
        List<Content> content = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select CONTENT.ID AS CONTENTID, CONTENT.IMAGE AS IMAGE, CONTENT.URL AS URL, CONTENT.TEXT AS TEXT, SCENARIO.DESCRIPTION AS SCENARIO\n" +
                     "FROM CONTENTBYSCENARIO \n" +
                     "JOIN CONTENT ON CONTENT.ID = CONTENTBYSCENARIO.CONTENTID\n" +
                     "JOIN SCENARIO ON SCENARIO.ID = CONTENTBYSCENARIO.SCENARIOID\n" +
                     "WHERE SCENARIO.SEASONID =" + seasonId + "\n" +
                     "AND SCENARIO.WEATHERSYMBOLID =" + weatherCat)) {

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

    //Last fallback. fetch all content with correct season. dont care about other parameters
    public List<Content> getSeasonFallback(int seasonId) {
        List<Content> content = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select CONTENT.ID AS CONTENTID, CONTENT.IMAGE AS IMAGE, CONTENT.URL AS URL, CONTENT.TEXT AS TEXT, SCENARIO.DESCRIPTION AS SCENARIO\n" +
                     "FROM CONTENTBYSCENARIO \n" +
                     "JOIN CONTENT ON CONTENT.ID = CONTENTBYSCENARIO.CONTENTID\n" +
                     "JOIN SCENARIO ON SCENARIO.ID = CONTENTBYSCENARIO.SCENARIOID\n" +
                     "WHERE SCENARIO.SEASONID =" + seasonId)) {

            while (rs.next()) {
                content.add(rsContent(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return content;
    }
}
