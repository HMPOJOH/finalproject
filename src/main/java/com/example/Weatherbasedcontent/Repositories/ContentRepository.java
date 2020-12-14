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

    List<Content> contentList2 = new ArrayList<>();



    public List<Content> getContentList2 (int searchScenario, int seasonId, int departmentId, int weatherCatId) {


        String sqlGetContentByScenarioId="select CONTENT.ID AS CONTENTID, CONTENT.IMAGE AS IMAGE, CONTENT.URL AS URL, CONTENT.TEXT AS TEXT, SCENARIO.DESCRIPTION AS SCENARIO, '1st' as Priority\n" +
                "FROM CONTENTBYSCENARIO \n" +
                "JOIN CONTENT ON CONTENT.ID = CONTENTBYSCENARIO.CONTENTID\n" +
                "JOIN SCENARIO ON SCENARIO.ID = CONTENTBYSCENARIO.SCENARIOID\n" +
                "WHERE CONTENTBYSCENARIO.SCENARIOID =" + searchScenario;
        String sqlGetContentBySeasonIdAndWeatherCat="select CONTENT.ID AS CONTENTID, CONTENT.IMAGE AS IMAGE, CONTENT.URL AS URL, CONTENT.TEXT AS TEXT, SCENARIO.DESCRIPTION AS SCENARIO, '2nd' as Priority\n" +
                "FROM CONTENTBYSCENARIO \n" +
                "JOIN CONTENT ON CONTENT.ID = CONTENTBYSCENARIO.CONTENTID\n" +
                "JOIN SCENARIO ON SCENARIO.ID = CONTENTBYSCENARIO.SCENARIOID\n" +
                "WHERE SCENARIO.SEASONID =" + seasonId + "\n" +
                "AND SCENARIO.WEATHERSYMBOLID =" + weatherCatId;
        String sqlGetContentBySeasonIdAndDepartmentId = "select CONTENT.ID AS CONTENTID, CONTENT.IMAGE AS IMAGE, CONTENT.URL AS URL, CONTENT.TEXT AS TEXT, SCENARIO.DESCRIPTION AS SCENARIO, '2nd' as Priority\n" +
                "FROM CONTENTBYSCENARIO \n" +
                "JOIN CONTENT ON CONTENT.ID = CONTENTBYSCENARIO.CONTENTID\n" +
                "JOIN SCENARIO ON SCENARIO.ID = CONTENTBYSCENARIO.SCENARIOID\n" +
                "WHERE SCENARIO.SEASONID =" + seasonId + "\n" +
                "AND SCENARIO.DEPARTMENTID =" + departmentId;

        String secondFallback= (departmentId == 7)?sqlGetContentBySeasonIdAndWeatherCat:sqlGetContentBySeasonIdAndDepartmentId;

        String sqlGetContentBySeasonId="select CONTENT.ID AS CONTENTID, CONTENT.IMAGE AS IMAGE, CONTENT.URL AS URL, CONTENT.TEXT AS TEXT, SCENARIO.DESCRIPTION AS SCENARIO, '3rd' as Priority\n" +
                "FROM CONTENTBYSCENARIO \n" +
                "JOIN CONTENT ON CONTENT.ID = CONTENTBYSCENARIO.CONTENTID\n" +
                "JOIN SCENARIO ON SCENARIO.ID = CONTENTBYSCENARIO.SCENARIOID\n" +
                "WHERE SCENARIO.SEASONID =" + seasonId;


        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();


             ResultSet rs = stmt.executeQuery(sqlGetContentByScenarioId +"\n UNION\n" + secondFallback +"\n UNION\n" + sqlGetContentBySeasonId)) {

            while (rs.next() && contentList2.size()<=4) {

                if(!isContentInListAlready2(contentList2, rs.getInt("CONTENTID"))) {
                    contentList2.add(rsContent(rs));
                    System.out.println("added id " + rs.getInt("CONTENTID"));

                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contentList2;

        /*

        new solution
      16
11
12
13
14


        old solution
        16
11
12
13
14
tempcat5
countryIN
scenarioid1
weathercat6
seasonid; 1

         */
    }

    private boolean isContentInListAlready2(List<Content> contentList2, int contentid) {
        for(int i=0;i<contentList2.size();i++)
            if(contentList2.get(i).getId() == contentid)
                return true;

        return false;
    }


    public List<Content> getContentList(int searchScenario, int seasonId, int departmentId, int weatherCatId) {
        List<Content> content = new ArrayList<>();
        content = getContentListbyId(searchScenario);
        int contentCount = content.size();
        System.out.println("Content count 1: " + contentCount);
        // fetch fallback content if not enough content
        if (contentCount < 5 ) {
            List<Content> contentTemp = new ArrayList<>();
            if (departmentId == 7) //All departments, fetch content by season and weathersymbol
                contentTemp = getContentWeatherFallback(seasonId, weatherCatId);
            else                    //fetch content by season and department
                contentTemp = getContentDepFallback(seasonId, departmentId);
            for (int i=0;i<(contentTemp.size());i++) {
                System.out.println("(1) try to add contentid from temp-list: " +  contentTemp.get(i).getId());
                if(!isContentInListAlready(content, contentTemp.get(i))) {
                    content.add(contentTemp.get(i));
                    System.out.println("added id " + contentTemp.get(i).getId());
                    contentCount += 1;
                }
                if (contentCount == 5)
                    break;
            }
            System.out.println("Content count 2: " + contentCount);
        }
        // fetch fallback content from season if not enough content
        if (contentCount < 5 ) {
            List<Content> contentTemp = getSeasonFallback(seasonId);
            for (int i=0;i<(contentTemp.size());i++) {
                System.out.println("(2) try to add contentid from temp-list: " +  contentTemp.get(i).getId());
                if(!isContentInListAlready(content, contentTemp.get(i))) {
                    content.add(contentTemp.get(i));
                    System.out.println("added id " + contentTemp.get(i).getId());
                    contentCount += 1;
                }
                if (contentCount == 5)
                    break;
            }
            System.out.println("Content count 3: " + contentCount);
        }
        return content;
    }

    private boolean isContentInListAlready(List<Content> currentContentList, Content tempContent) {

        for(int i=0;i<currentContentList.size();i++)
           if(currentContentList.get(i).getId() == tempContent.getId())
               return true;

           return false;

    }

    // fetch content with correct scenarioId
    public List<Content> getContentListbyId(int searchScenario) {
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
    }

    /* duplicated code
    public void addContentToScenario(int contentId, int scenarioId) {

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
    } */

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

    public void removeContentFromScenario(int contentId, int scenarioId) {
        Connection conn = null;
        System.out.println("remove 1: " + contentId + ", " + scenarioId);
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
        System.out.println("remove 2: " + contentId + ", " + scenarioId);
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
        System.out.println("check content exist 2 " + contentExist);
        return contentExist;
    }

    // remove the content from table Content
    public void removeContent(int contentId) {
        Connection conn = null;
        System.out.println("delete from content 1: " + contentId);
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
        System.out.println("delete from content 2: ");
    }
}
