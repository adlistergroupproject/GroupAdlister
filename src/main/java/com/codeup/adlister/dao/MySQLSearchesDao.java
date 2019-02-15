package com.codeup.adlister.dao;

import java.util.List;

public class MySQLSearchesDao extends MySQLAdsDao implements Searches {

    public MySQLSearchesDao(Config config){
        super(config);
    }

    public List<Ads> search(String titles, String description){
        return null;
    }

    public List<Ads> searchTitles(String titles){
        return null;
    }

    public List<Ads> searchDescriptions(String descriptions){
        return null;
    }

    public List<Ads> searchCategories(String[] categories){
        return null;
    }
}
