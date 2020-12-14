package com.example.Weatherbasedcontent.Repositories;

import com.example.Weatherbasedcontent.Repositories.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class ContentRepository {

    @Autowired
    private DataSource dataSource;

    Set<Content> content = new HashSet<>();
    List<Content> contentTemp = new ArrayList<>();




    //scenario id - department, weathercat, tempcat, seasonid
    public Set<Content> getContentList(int searchScenario, int seasonId, int departmentId, int weatherCatId) {

        getContentListbyId(searchScenario);
        int contentCount = content.size();
        System.out.println("Content count 1: " + contentCount);
        // fetch fallback content if not enough content
        if (contentCount < 5 ) {

            if (departmentId == 7) //All departments, fetch content by season and weathersymbol
                getContentWeatherFallback(seasonId, weatherCatId);
            else                    //fetch content by season and department
                getContentDepFallback(seasonId, departmentId);

            for (int i=0;i<(contentTemp.size()-1);i++) {
                content.add(contentTemp.get(i));
                System.out.println("adding below content fallback 2:");
                contentTemp.get(i).printContent();
                contentCount +=1;
                if (contentCount == 5)
                    break;
            }
            System.out.println("Content count 2: " + contentCount);
        }
        // fetch fallback content from season if not enough content
        if (contentCount < 5 ) {
           getSeasonFallback(seasonId);
            for (int i=0;i<(contentTemp.size()-1);i++) {
                content.add(contentTemp.get(i));
                content.add(contentTemp.get(i));
                System.out.println("adding below content fallback 3:");
                contentCount +=1;
                if (contentCount == 5)
                    break;
            }
            System.out.println("Content count 3: " + contentCount);
        }

        System.out.println("Real size of content list= " + content.size());
        return content;
    }

    // fetch content with correct scenarioId
    public Set<Content> getContentListbyId(int searchScenario) {

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

    //fetch all content with correct season and department. Dont care about weathersymbol or temperature
    public void getContentDepFallback(int seasonId, int departmentId) {


        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select CONTENT.ID AS CONTENTID, CONTENT.IMAGE AS IMAGE, CONTENT.URL AS URL, CONTENT.TEXT AS TEXT, SCENARIO.DESCRIPTION AS SCENARIO\n" +
                     "FROM CONTENTBYSCENARIO \n" +
                     "JOIN CONTENT ON CONTENT.ID = CONTENTBYSCENARIO.CONTENTID\n" +
                     "JOIN SCENARIO ON SCENARIO.ID = CONTENTBYSCENARIO.SCENARIOID\n" +
                     "WHERE SCENARIO.SEASONID =" + seasonId + "\n" +
                     "AND SCENARIO.DEPARTMENTID =" + departmentId)) {

            while (rs.next()) {

                contentTemp.add(rsContent(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //fetch all content with correct season and weathersymbol (snow, rain etc). Dont care about deprtment or temperature
    public void getContentWeatherFallback(int seasonId, int weatherCat) {


        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select CONTENT.ID AS CONTENTID, CONTENT.IMAGE AS IMAGE, CONTENT.URL AS URL, CONTENT.TEXT AS TEXT, SCENARIO.DESCRIPTION AS SCENARIO\n" +
                     "FROM CONTENTBYSCENARIO \n" +
                     "JOIN CONTENT ON CONTENT.ID = CONTENTBYSCENARIO.CONTENTID\n" +
                     "JOIN SCENARIO ON SCENARIO.ID = CONTENTBYSCENARIO.SCENARIOID\n" +
                     "WHERE SCENARIO.SEASONID =" + seasonId + "\n" +
                     "AND SCENARIO.WEATHERSYMBOLID =" + weatherCat)) {

            while (rs.next()) {
                contentTemp.add(rsContent(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Content rsContent(ResultSet rs) throws SQLException {
        Content newContent = new Content(
                rs.getInt("CONTENTID"),
                rs.getString("IMAGE"),
                rs.getString("URL"),
                rs.getString("TEXT"));


        return newContent;
    }

    //Last fallback. fetch all content with correct season. dont care about other parameters
    public void getSeasonFallback(int seasonId) {


        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select CONTENT.ID AS CONTENTID, CONTENT.IMAGE AS IMAGE, CONTENT.URL AS URL, CONTENT.TEXT AS TEXT, SCENARIO.DESCRIPTION AS SCENARIO\n" +
                     "FROM CONTENTBYSCENARIO \n" +
                     "JOIN CONTENT ON CONTENT.ID = CONTENTBYSCENARIO.CONTENTID\n" +
                     "JOIN SCENARIO ON SCENARIO.ID = CONTENTBYSCENARIO.SCENARIOID\n" +
                     "WHERE SCENARIO.SEASONID =" + seasonId)) {

            while (rs.next()) {
                contentTemp.add(rsContent(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int addContent(Content content) {
        int generatedId = 0;
        Connection conn = null;
        System.out.println("text to add: " + content.getText());
        System.out.println("image to add: " + content.getImage());
        System.out.println("url to add: " + content.getUrl());
        String SqlStatement = "INSERT INTO CONTENT (TEXT,IMAGE,URL) \n" +
                " VALUES('" + content.getText() + "','" + content.getImage() + "','" + content.getUrl() + "')";

        try {
            conn = dataSource.getConnection();

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(SqlStatement, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




        return generatedId;
    } public void addContentToScenario(int contentId, int scenarioId) {

        Connection conn = null;

        String SqlStatement = "INSERT INTO CONTENTBYSCENARIO  (CONTENTID,SCENARIOID) \n" +
                " VALUES('" + contentId + "','" + scenarioId +"')";

        try {
            conn = dataSource.getConnection();

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(SqlStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




    }
    public void addContentByScenario(int contentId, int scenarioId) {
        Connection conn = null;
        String SqlStatement = "INSERT INTO CONTENTBYSCENARIO (CONTENTID,SCENARIOID) \n" +
                " VALUES(" + contentId + "," + scenarioId + ")";

        try {
            conn = dataSource.getConnection();

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(SqlStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
