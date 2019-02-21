package com.codeup.adlister.models;

import com.codeup.adlister.dao.Categories;
import com.codeup.adlister.dao.DaoFactory;

public class Category {

    private String value;
    private int id;

    public Category(int id, String value){
        this.id = id;
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    public int getId(){
        return this.id;
    }

    public String toString(){
        return "id: " + this.id + ", value:" + this.value;
    }

}
