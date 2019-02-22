package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.util.List;

public interface Categories {

    Category getCategory(int id);

    Category getCategory(String value);

    List<Category> getAllCategories();

    List<Category> getCategoriesByAd(Ad ad);

    long insertIntoAdCategories(int adId, Category category);

    void insertIntoAdCategories(Ad ad);
}
