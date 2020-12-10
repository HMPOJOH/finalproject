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
        if (contentCount > 0 && contentCount < 5 ) {
            List<Content> contentTemp = getSeasonFallback(1);
            for (int i=0;i<(content.size()-1);i++) {
                content.add(contentTemp.get(i));
            }
        }
        return content;
    }

    public List<Content> getSeasonFallback(int seasonId) {
        List<Content> content = new ArrayList<>();
        int searchScenario = 2;
        if (seasonId == 1) // summer
            searchScenario = 12;
        else
            searchScenario = 10;
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


}
