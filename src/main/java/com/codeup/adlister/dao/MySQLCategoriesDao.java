package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.util.SQLQuery;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao extends MySQLAdsDao implements Categories {

    public MySQLCategoriesDao(final Config config){
        super(config);
    }

    private Category extractCategory(ResultSet rs) throws SQLException {
        // DEBUG
        System.out.println("DEBUG: MySQLAdsDao");
        System.out.println("DEBUG: extractCategory(...)");
        // END DEBUG

        Category category = null;
        category = new Category(rs.getInt("id"), rs.getString("category"));
        return category;
    }

    private List<Category> createCategoriesFromResults(ResultSet rs) throws SQLException {
        // DEBUG
        System.out.println("DEBUG: MySQLCategoriesDao");
        System.out.println("DEBUG: createCategoriesFromResults(...)");
        // END DEBUG
        List<Category> categories = new ArrayList<>();
        while (rs.next()) {
            categories.add(extractCategory(rs));
        }
        return categories;
    }

    private List<Category> executeQueryOnCategories(String query){
        // DEBUG
        System.out.println("DEBUG: executeQueryOnCategories(...)");
        System.out.println(query);
        // END DEBUG
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Category> categories = null;
        try {
            stmt = connection.prepareStatement(query);
            rs = stmt.executeQuery();
            categories = createCategoriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
        return categories;
    }

    public Category getCategory(final int index){
        // DEBUG
        System.out.println("DEBUG: getCategoy(...)");
        // END DEBUG
        String query = new SQLQuery().select("*").from("categories")
                .where("id = " + index)
                .done()
                .toString();

        Category category = null;
        try{
            category = executeQueryOnCategories(query).get(0);
        } catch(NullPointerException e){
            e.printStackTrace();
        }
        return category;
    }

    public Category getCategory(String key){
        // TODO: method might be redundant
        return null;
    }

    @Deprecated
    public List<String> getKeys(){
        return null;
    }

    @Deprecated
    public List<String> getValues(){
        return null;
    }

    public List<Category> getAllCategories(){
        // DEBUG
        System.out.println("DEBUG: getAllCategories(...)");
        // END DEBUG
        String query = new SQLQuery().select("*").from("categories").done().toString();
        return executeQueryOnCategories(query);
    }

    public List<Category> getCategoriesByAd(Ad ad){
        // DEBUG
        System.out.println("DEBUG: getCategoriesByAd(...)");
        // END DEBUG
        //String query = "SELECT categories.id, categories.category FROM ad_categories\n" +
        //        "JOIN categories ON categories.id = ad_categories.category_id\n" +
        //        "WHERE ad_id = 1;";
        String query = new SQLQuery().select("categories.id, categories.category")
                .from("ad_categories")
                .join("categories")
                .on("categories.id = ad_categories.category_id")
                .where("ad_id = " + ad.getId())
                .done()
                .toString();

        return executeQueryOnCategories(query);
    }

    public long insertIntoAdCategories(int adId, Category category){

        //String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        String query = new SQLQuery()
                .insertInto("ad_categories", "ad_id, category_id")
                .values("? ?")
                .done().toString();

        long status = -1;
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, adId);
            stmt.setInt(2, category.getId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            status = rs.getLong(1);
        } catch (SQLException e) {
            // DEBUG
            System.out.println("DEBUG: insertIntoAdCategories(...): FAILED TO INSERT " + category.toString());
            System.out.println("DEBUG: " + query);
            // END DEBUG
        }

        return status;
    }

    public void insertIntoAdCategories(Ad ad){
        
        for(Category category : ad.getCategories()){
            insertIntoAdCategories( (int)ad.getId(), category);
        }
    }

}
