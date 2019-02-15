package com.codeup.adlister.dao;

import com.codeup.adlister.util.SQLQuery;
import com.codeup.adlister.models.Ad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySQLSearchesDao extends MySQLAdsDao implements Searches {

    public MySQLSearchesDao(Config config){
        super(config);
    }

    public List<Ad> search(String[] keywords){

        // construct the query
        SQLQuery query = new SQLQuery().select("*").from("ads");
        {
            int index = 0;
            for(String keyword : keywords) {
                if (index == 0) {
                    query = query.where(new SQLQuery("title").like(keyword)
                            .and("description").like(keyword));
                } else {
                    query = query.or(new SQLQuery("title").like(keyword)
                            .and("description").like(keyword));
                }
                index++;
            }
            // end query construction
            query = query.done();
        }
        /*DEUBG*/System.out.println(query.toString());

        List<Ad> searchResult = null;
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query.toString());
            ResultSet rs = stmt.executeQuery();
            searchResult = createAdsFromResults(rs);
        } catch (SQLException e) {
            // Don't fail. There may just not be any ads.
            e.printStackTrace();
        }
        return searchResult;
    }

    public List<Ad> search(String titles, String description){
        return null;
    }

    public List<Ad> searchTitles(String titles){
        return null;
    }

    public List<Ad> searchDescriptions(String descriptions){
        return null;
    }

    public List<Ad> searchCategories(String[] categories){
        return null;
    }
}
