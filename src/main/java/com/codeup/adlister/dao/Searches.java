package com.codeup.adlister.dao;

import java.util.List;

public interface Searches {

    public List<Ads> search(String titles, String description);

    public List<Ads> searchTitles(String titles);

    public List<Ads> searchDescriptions(String descriptions);

    public List<Ads> searchCategories(String[] categories);

}
