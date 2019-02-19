package com.codeup.adlister.dao;

import java.util.List;
import com.codeup.adlister.models.Ad;

public interface Searches {

    public List<Ad> search(String titles, String description);

    public List<Ad> search(String[] keywords);

    public List<Ad> searchTitles(String titles);

    public List<Ad> searchDescriptions(String descriptions);

    public List<Ad> searchCategories(String[] categories);

}
