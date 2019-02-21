package com.codeup.adlister.models;



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
