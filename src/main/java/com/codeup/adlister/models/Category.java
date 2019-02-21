package com.codeup.adlister.models;

import com.codeup.adlister.dao.Categories;
import com.codeup.adlister.dao.DaoFactory;

public class Category {

    // Each category object must stay synchronized with the single category map
    private static final Categories categories = DaoFactory.getCategoriesDao();

    private String value;
    private int id;

    public Category(int id, String value){
        this.id = id;
        this.value = value;
    }

    @Deprecated
    public Category(String key, String value, int index){
        //this.key = key;
        this.value = value;
        //this.index = index;
    }

    @Deprecated
    public Category(String key){
        //this.key = key;
        this.value = this.categories.getCategory(key);
        //this.index = -1; // TODO: change this... not that important
    }

    // the empty constructor just creates dummy categories
    @Deprecated
    public Category(){
        this.id = (int)(Math.floor(Math.random() * 1000)) % categories.getKeys().size();
        this.value = categories.getCategory(id);
        //this.key = null; // TODO: change this... not that important
    }

    public String getValue(){
        return this.value;
    }

    public int getId(){
        return this.id;
    }

    @Deprecated
    public String getKey(){
        return null;
    }

    @Deprecated
    public String toString(){
        return "id: " + this.id + ", value:" + this.value;
    }

}
