package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.util.List;

public class MySQLCategoriesDao extends MySQLAdsDao implements Categories {

    public MySQLCategoriesDao(Config config){
        super(config);
    }

    public String getCategory(int index){
        return null;
    }

    public String getCategory(String key){
        return null;
    }

    public List<String> getKeys(){
        return null;
    }

    public List<String> getValues(){
        return null;
    }

    public List<Category> getAllCategories(){
        return null;
    }

    public List<Category> getCategoriesByAd(Ad ad){
        return null;
    }

}
