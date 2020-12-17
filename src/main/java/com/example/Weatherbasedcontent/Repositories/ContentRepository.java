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

    //find content from scenario. If not finding 5 content, then different fallback queries to add up suitable content
    // 1. search by exact scenario
    // 2. second fallback: if one department chosen; fallback = season + weather categoru + department. If "all departments", fallback = season + weather category
    // 3. third fallback: if one department chosen and weather is rain or snow; fallback = weather categoru + department. If "all departments", fallback = weather category
    // 4. if not rain or snow, fallback = season + department
    // 5. last fallback is content by season only
    public List<Content> getContentList (int searchScenario, int seasonId, int departmentId, int weatherCatId) {
        List<Content> contentList = new ArrayList<>();

        //priority 1: exact match scenario
        String sqlGetContentByScenarioId="select CONTENT.ID AS CONTENTID, CONTENT.IMAGE AS IMAGE, CONTENT.URL AS URL, CONTENT.TEXT AS TEXT, SCENARIO.DESCRIPTION AS SCENARIO, '1st' as Priority\n" +
                "FROM CONTENTBYSCENARIO \n" +
                "JOIN CONTENT ON CONTENT.ID = CONTENTBYSCENARIO.CONTENTID\n" +
                "JOIN SCENARIO ON SCENARIO.ID = CONTENTBYSCENARIO.SCENARIOID\n" +
                "WHERE CONTENTBYSCENARIO.SCENARIOID =" + searchScenario;

        //Second fallback:
        String sqlGetContentBySeasonIdAndWeatherCat="select CONTENT.ID AS CONTENTID, CONTENT.IMAGE AS IMAGE, CONTENT.URL AS URL, CONTENT.TEXT AS TEXT, SCENARIO.DESCRIPTION AS SCENARIO, '2nd' as Priority\n" +
                "FROM CONTENTBYSCENARIO \n" +
                "JOIN CONTENT ON CONTENT.ID = CONTENTBYSCENARIO.CONTENTID\n" +
                "JOIN SCENARIO ON SCENARIO.ID = CONTENTBYSCENARIO.SCENARIOID\n" +
                "WHERE SCENARIO.SEASONID =" + seasonId + "\n" +
                "AND SCENARIO.WEATHERSYMBOLID =" + weatherCatId;

        String sqlGetContentBySeasonAndWeatherAndDep = "select CONTENT.ID AS CONTENTID, CONTENT.IMAGE AS IMAGE, CONTENT.URL AS URL, CONTENT.TEXT AS TEXT, SCENARIO.DESCRIPTION AS SCENARIO, '2nd' as Priority\n" +
                "FROM CONTENTBYSCENARIO \n" +
                "JOIN CONTENT ON CONTENT.ID = CONTENTBYSCENARIO.CONTENTID\n" +
                "JOIN SCENARIO ON SCENARIO.ID = CONTENTBYSCENARIO.SCENARIOID\n" +
                "WHERE SCENARIO.SEASONID =" + seasonId + "\n" +
                "AND SCENARIO.WEATHERSYMBOLID =" + weatherCatId + "\n" +
                "AND SCENARIO.DEPARTMENTID =" + departmentId;

        String secondFallback= (departmentId == 7)?sqlGetContentBySeasonIdAndWeatherCat:sqlGetContentBySeasonAndWeatherAndDep;

        //Third fallback
        String sqlGetContentBySeasonIdAndDepartmentId = "select CONTENT.ID AS CONTENTID, CONTENT.IMAGE AS IMAGE, CONTENT.URL AS URL, CONTENT.TEXT AS TEXT, SCENARIO.DESCRIPTION AS SCENARIO, '3rd' as Priority\n" +
                "FROM CONTENTBYSCENARIO \n" +
                "JOIN CONTENT ON CONTENT.ID = CONTENTBYSCENARIO.CONTENTID\n" +
                "JOIN SCENARIO ON SCENARIO.ID = CONTENTBYSCENARIO.SCENARIOID\n" +
                "WHERE SCENARIO.SEASONID =" + seasonId + "\n" +
                "AND SCENARIO.DEPARTMENTID =" + departmentId;

        String sqlGetContentByWeatherCatAndDepartmentId = "select CONTENT.ID AS CONTENTID, CONTENT.IMAGE AS IMAGE, CONTENT.URL AS URL, CONTENT.TEXT AS TEXT, SCENARIO.DESCRIPTION AS SCENARIO, '3rd' as Priority\n" +
                "FROM CONTENTBYSCENARIO \n" +
                "JOIN CONTENT ON CONTENT.ID = CONTENTBYSCENARIO.CONTENTID\n" +
                "JOIN SCENARIO ON SCENARIO.ID = CONTENTBYSCENARIO.SCENARIOID\n" +
                "WHERE SCENARIO.WEATHERSYMBOLID =" + weatherCatId + "\n" +
                "AND SCENARIO.DEPARTMENTID =" + departmentId;

        String sqlGetContentByWeatherCat="select CONTENT.ID AS CONTENTID, CONTENT.IMAGE AS IMAGE, CONTENT.URL AS URL, CONTENT.TEXT AS TEXT, SCENARIO.DESCRIPTION AS SCENARIO, '3rd' as Priority\n" +
                "FROM CONTENTBYSCENARIO \n" +
                "JOIN CONTENT ON CONTENT.ID = CONTENTBYSCENARIO.CONTENTID\n" +
                "JOIN SCENARIO ON SCENARIO.ID = CONTENTBYSCENARIO.SCENARIOID\n" +
                "WHERE SCENARIO.WEATHERSYMBOLID =" + weatherCatId;

        String thirdFallback = " ";
        if (departmentId == 7 && (weatherCatId == 2 || weatherCatId == 3 )) //all dep + rain or snow
            thirdFallback = sqlGetContentByWeatherCat;
        else if (weatherCatId == 2 || weatherCatId == 3 ) //rain or snow
            thirdFallback = sqlGetContentByWeatherCatAndDepartmentId;
        else
            thirdFallback= sqlGetContentBySeasonIdAndDepartmentId;

        //final fallback
        String sqlGetContentBySeasonId="select CONTENT.ID AS CONTENTID, CONTENT.IMAGE AS IMAGE, CONTENT.URL AS URL, CONTENT.TEXT AS TEXT, SCENARIO.DESCRIPTION AS SCENARIO, '4th' as Priority\n" +
                "FROM CONTENTBYSCENARIO \n" +
                "JOIN CONTENT ON CONTENT.ID = CONTENTBYSCENARIO.CONTENTID\n" +
                "JOIN SCENARIO ON SCENARIO.ID = CONTENTBYSCENARIO.SCENARIOID\n" +
                "WHERE SCENARIO.SEASONID =" + seasonId;

        String finalUnionQuery = sqlGetContentByScenarioId +"\n UNION\n" + secondFallback +"\n UNION\n" + thirdFallback +"\n UNION\n" + sqlGetContentBySeasonId + "ORDER BY Priority";

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(finalUnionQuery)) {
                while (rs.next() && contentList.size()<=4) {
                    if(!isContentInListAlready(contentList, rs.getInt("CONTENTID"))) {
                        contentList.add(rsContent(rs));
                        System.out.println("show contentId " + rs.getInt("CONTENTID") + " from: " + rs.getString("SCENARIO") + " Priority: " + rs.getString("Priority"));
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contentList;
    }

    //find Content matching the exact scenario only
    public List<Content> getContentListbyId(int searchScenario) {
        return getContentList(searchScenario, -1, -1, -1);
    }

    //count how many contents that are added in each scenario
    public int[] updateContentQtyPerScenario(List<Scenario> scenarios) {
        int[] contentQtyPerScenario = new int[scenarios.size()];
        try (Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SCENARIOID, COUNT(*) as QTY FROM CONTENTBYSCENARIO GROUP BY SCENARIOID")) {
                while (rs.next()) {
                    contentQtyPerScenario[rs.getInt("SCENARIOID")-1]=rs.getInt("QTY");
                }
            }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return contentQtyPerScenario;
    }

    // for fallback content, don´t add duplicates to the content list
    private boolean isContentInListAlready(List<Content> contentList2, int contentid) {
        for(int i=0;i<contentList2.size();i++)
            if(contentList2.get(i).getId() == contentid)
                return true;

        return false;
    }

    private Content rsContent(ResultSet rs) throws SQLException {
        return new Content(
                rs.getInt("CONTENTID"),
                rs.getString("IMAGE"),
                rs.getString("URL"),
                rs.getString("TEXT"));
    }

    public int addContent(Content content) {
        int generatedId = 0;
        Connection conn = null;
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
    }

    public void addContentToScenario(int contentId, int scenarioId) {
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

    public void removeContentFromScenario(int contentId, int scenarioId) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute("DELETE FROM CONTENTBYSCENARIO WHERE CONTENTID=" + contentId + " AND SCENARIOID=" + scenarioId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        boolean contentExist = checkContentExist(contentId);
        if (contentExist == false)
            removeContent(contentId);
    }

    // does the content exist in any scenario?
    public boolean checkContentExist(int contentId) {
        boolean contentExist = false;
        System.out.println("check content exist 1 " + contentId);
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT ID FROM CONTENTBYSCENARIO WHERE CONTENTID=" + contentId)) {
                if (rs.next()) {
                    contentExist = true;
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contentExist;
    }

    // remove the content from table Content
    public void removeContent(int contentId) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute("DELETE FROM CONTENT WHERE ID=" + contentId);
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
