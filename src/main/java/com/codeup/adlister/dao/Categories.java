package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.util.List;

public interface Categories {

    String getCategory(int index);

    String getCategory(String key);

    List<String> getKeys();

    List<String> getValues();

    List<Category> getAllCategories();

    List<Category> getCategoriesByAd(Ad ad);

}
