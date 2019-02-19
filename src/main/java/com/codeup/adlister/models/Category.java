package com.codeup.adlister.models;

import com.codeup.adlister.dao.Categories;
import com.codeup.adlister.dao.DaoFactory;

public class Category {

    // Each category object must stay synchronized with the single category map
    private static final Categories categories = DaoFactory.getCategoriesDao();

    private String key;
    private String value;
    private int index;

    public Category(String key, String value, int index){
        this.key = key;
        this.value = value;
        this.index = index;
    }

    public Category(String key){
        this.key = key;
        this.value = this.categories.getCategory(key);
        this.index = -1; // TODO: change this... not that important
    }

    // the empty constructor just creates dummy categories
    public Category(){
        this.index = (int)(Math.floor(Math.random() * 1000)) % categories.getKeys().size();
        this.value = categories.getCategory(index);
        this.key = null; // TODO: change this... not that important
    }

    public String getValue(){
        return this.value;
    }

    public int getId(){
        return this.index;
    }

    public String getKey(){
        return this.key;
    }

    public String toString(){
        return "id: " + this.index + ", key: " + this.key + ", value:" + this.value;
    }

}
