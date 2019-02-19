package com.codeup.adlister.models;

import com.codeup.adlister.util.Jsonable;

public class Ad implements Jsonable {

    private long id;
    private long userId;
    private String title;
    private String description;

    public Ad(long id, long userId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public Ad(long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
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
