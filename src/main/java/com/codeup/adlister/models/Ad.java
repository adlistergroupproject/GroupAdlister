package com.codeup.adlister.models;

import com.codeup.adlister.util.Jsonable;
import com.codeup.adlister.util.StringFormatException;


import java.util.ArrayList;
import java.util.List;

public class Ad implements Jsonable {

    private double price;
    private long id;
    private long userId;
    private String title;
    private String description;
    private List<Category> categories;

    @Deprecated
    public Ad(long id, long userId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.categories = null;
    }

    @Deprecated
    public Ad(long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.categories = null;
    }

    public Ad(long id, long userId, String title, String description, List<Category> categories)
        throws NullPointerException,
            NumberFormatException,
            StringFormatException
    {
        if(title == null || description == null || categories == null){
            throw new NullPointerException();
        } else if(id < 0 || userId < 0){
            throw new NumberFormatException();
        } else if(title.equals("") || description.equals("")){
            throw new StringFormatException("Empty string not allowed.");
        }
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.categories = categories;
    }

    private boolean validStringList(List<String> strList){
        for(String str : strList){
            if(str.equals("")){
                return false;
            }
        }
        return true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addCategory(Category category)
            throws StringFormatException
    {
        if(category.equals("")){
            throw new StringFormatException("Empty string not allowed.");
        }
        if(this.categories == null){
            this.categories = new ArrayList<Category>();
        }
        this.categories.add(category);
    }

    public List<Category> getCategories()
        throws NullPointerException
    {
        if(this.categories == null){
            System.out.println("DEBUG: categories were never assigned to the ad.");
            throw new NullPointerException();
        }
        return this.categories;
    }

    public String toJSON(){
        String json = "{";
        json += "\"id\":\"" + this.id + "\",";
        json += "\"userId\":\"" + this.userId + "\",";
        json += "\"title\":\"" + this.title + "\",";
        json += "\"description\":\"" + this.description + "\",";
        json += "}";
        return json;
    }

    public String toString(){
        return "id: " + this.id +
            "\tuserId: " + this.userId +
            "\ttitle: " + this.title +
            "\tdescription: " + this.description;
    }
}
