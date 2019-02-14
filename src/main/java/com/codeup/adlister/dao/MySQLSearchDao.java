package com.codeup.adlister.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.codeup.adlister.models.Ad;

public class MySQLSearchDao extends MySQLAdsDao {

    private Connection connection;

    public MySQLSearchDao(Config config){
        super(config);
    }

    public List<Ad> search(String title, String description) {

        // define the query
        String query = "SELECT * FROM ads"
                + "WHERE title like \'%" + title + "%\'"
                + "OR description like \'%" + description + "%\'";

        // allocate for the list of ads and the statement
        List<Ad> ads = null;
        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ads.add(
                        new Ad(
                                rs.getLong("id"),
                                rs.getLong("user_id"),
                                rs.getString("title"),
                                rs.getString("description")
                        )
                );
            }

        } catch (SQLException e) {
            System.out.println("DEBUG:\n" + e.getStackTrace());
            return null;
        }

        return ads;
    }
}
