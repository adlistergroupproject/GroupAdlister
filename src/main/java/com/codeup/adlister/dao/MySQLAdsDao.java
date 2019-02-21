package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.util.SQLQuery;
import com.codeup.adlister.util.StringFormatException;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    protected Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        String query = new SQLQuery().select("*").from("ads").done().toString();
        // DEBUG
        System.out.println("DEBUG: MySQLAdsDao");
        System.out.println("DEBUG: all(...)");
        System.out.println("DEBUG: " + query);
        // END DEBUG
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        // TODO: also insert into categories
        // String insertQuery = "INSERT INTO ads(user_id, title, description, view_count) VALUES (?, ?, ?, ?)";
        String query = new SQLQuery().insertInto("ads", "user_id, description, title, view_count")
                .values("?, ?, ?, ?")
                .done()
                .toString();
        // DEBUG
        System.out.println("DEBUG: MySQLAdsDao");
        System.out.println("DEBUG: insert(...)");
        System.out.println("DEBUG: " + query);
        // END DEBUG
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setInt(4, 0);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    protected Ad extractAd(ResultSet rs) throws SQLException {
        // DEBUG
        System.out.println("DEBUG: MySQLAdsDao");
        System.out.println("DEBUG: extractAd(...)");
        // END DEBUG

        // dummy categories
        List<Category> categories = new ArrayList<>();
        categories.add(new Category());

        Ad ad = null;
        try {
             ad = new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description"),
                categories,
                rs.getDouble("price"),
                rs.getInt("view_count")
            );
        } catch (StringFormatException e) {
            e.printStackTrace();
        }
        return ad;
    }

//    protected ResultSet extractCategories (ResultSet rs){
//        List<Categories> categories = null;
//        SQLQuery query = new SQLQuery().select("*").from("ad_categories").where("ad_id = ?");
//        try{
//            PreparedStatement stmt = connection.prepareStatement(query.toString());
//            stmt.setInt(1, id);
//            ResultSet rs = stmt.executeQuery();
//            List<Categories> adsCategories = createCategoriesList(rs);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        // need to return something here ----------------------------------------------------------------------
//    }
//

//    protected List<Categories> createCategoriesList(ResultSet rs){
//        List<Categories> categories = new ArrayList<>();
//        while (rs.next()) {
//            categories.add(extractCategories(rs));
//        }
//        return categories;
//    }

    protected List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        // DEBUG
        System.out.println("DEBUG: MySQLAdsDao");
        System.out.println("DEBUG: createAdsFromResults(...)");
        // END DEBUG

        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    // TODO: possibly a duplicate method
    public List<Ad> getUsersAds(long id) throws SQLException {
        //String query = "SELECT * FROM ads WHERE user_id = ?";
        String query = new SQLQuery().select("*").from("ads")
                .where("user_id = ?")
                .done()
                .toString();

        // DEBUG
        System.out.println("DEBUG: MySQLAdsDao");
        System.out.println("DEBUG: getUsersAds(...)");
        System.out.println("DEBUG: " + query);
        // END DEBUG

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        List<Ad> userAds = createAdsFromResults(rs);

        return userAds;
    }

//    protected List<Categories> getAdsCateogries(int id){
//        String query = "SELECT * FROM ads_categories WHERE ad_id = ?";
//        List<Categories> adsCategories=null;
//        try {
//            PreparedStatement stmt = connection.prepareStatement(query);
//            stmt.setInt(1, id);
//            ResultSet rs = stmt.executeQuery();
//            adsCategories = createCategoriesList(rs);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return adsCategories;
//    }

    // TODO: possibly a duplicate method
    public Ad getAdById(long id) throws SQLException {
        //String query = "SELECT * FROM ads WHERE id = ?";
        String query = new SQLQuery().select("*").from("ads")
                .where("id = ?")
                .done()
                .toString();

        // DEBUG
        System.out.println("DEBUG: MySQLAdsDao");
        System.out.println("DEBUG: getAdByID(...)");
        System.out.println("DEBUG: " + query);
        // END DEBUG

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setLong(1,id);
        ResultSet rs = stmt.executeQuery();
        Ad adById = null;

        while(rs.next()) {
            adById = extractAd(rs);
        }

        return adById;
    }

    public Ad updateAdInfo(String title, String description, long id){
        //String query = "UPDATE ads SET title = ?, description = ? WHERE id = ?";
        String query = new SQLQuery().update("ads").set("title = ?, description = ?")
                .where("id = ?")
                .done()
                .toString();

        // DEBUG
        System.out.println("DEBUG: MySQLAdsDao");
        System.out.println("DEBUG: updateAdInfo(...)");
        System.out.println("DEBUG: " + query);
        // END DEBUG

        Ad updatedAd;
        try {
            PreparedStatement stmt =connection.prepareStatement(query);
            stmt.setString(1, title);
            stmt.setString(2, description);
            stmt.setLong(3, id);
            stmt.executeUpdate();
            updatedAd = getAdById(id);
        } catch (SQLException e) {
            throw new RuntimeException("Error updating the Ad", e);
        }
//      new updated Ad object:
        return updatedAd;
    }

    public Ad updateAdViewCount(long id){
        //String query = "UPDATE ads SET view_count = view_count + 1 WHERE id = ?";
        String query = new SQLQuery().update("ads").set("view_count = view_count + 1")
                .where("id = ?")
                .done()
                .toString();

        // DEBUG
        System.out.println("DEBUG: MySQLAdsDao");
        System.out.println("DEBUG: updateAdViewCount(...)");
        System.out.println("DEBUG: " + query);
        // END DEBUG

        Ad updatedViewCount = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            stmt.executeUpdate();
            updatedViewCount = getAdById(id);
        } catch(SQLException e){
             e.printStackTrace();
        }
        return updatedViewCount;
    }

    public void deleteAd(Ad ad){
        //String query = "DELETE FROM ads WHERE id = ?";
        String query = new SQLQuery().delete().from("ads")
                .where("id = ?")
                .done()
                .toString();

        // DEBUG
        System.out.println("DEBUG: MySQLAdsDao");
        System.out.println("DEBUG: deleteAd(...)");
        System.out.println("DEBUG: " + query);
        // END DEBUG

        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, ad.getId());
            stmt.executeUpdate();
            System.out.println("Ad deleted successfully!");
        } catch(SQLException e){
            throw new RuntimeException("Error, the Ad was not deleted.");
        }
    }

}


