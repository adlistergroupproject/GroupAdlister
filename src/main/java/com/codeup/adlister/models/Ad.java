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
    private int viewCount;

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

    public Ad(long id, long userId,
              String title, String description,
              List<Category> categories, double price)
            throws NullPointerException,
            NumberFormatException,
            StringFormatException
    {
        // DEBUG
        System.out.println("DEBUG: constructing Ad(...)");
        // END DEBUG
        if(title == null || description == null){
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
        this.price = price;
    }

    public Ad(long id, long userId, String title, String description, List<Category> categories, double price, int viewCount) throws
            NullPointerException,
            NumberFormatException,
            StringFormatException{
        this(id, userId, title, description, categories, price);
        this.viewCount = viewCount;
    }

    @Deprecated
    public Ad(){
        this.viewCount = viewCount;
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

    public void setViewCount(int viewCount){
        this.viewCount = viewCount;
    }

    public int getViewCount(){return viewCount;}

    public void addCategory(Category category) {
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

    public Double getPrice(){
        return this.price;
    }

    public void setPrice(Double price){
        this.price = price;
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
        String tostring = "id: " + this.id +
            "\tuserId: " + this.userId +
            "\ttitle: " + this.title +
            "\tdescription: " + this.description +
            "\tviewCount: " + this.viewCount +
            "\tcategories: ";
        if(this.categories == null){
            tostring += "null";
        }else{
            for(Category category : this.categories){
                tostring += "{" + category.toString() + "},";
            }
        }
        return tostring;
    }
}
