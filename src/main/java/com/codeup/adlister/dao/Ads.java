package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.sql.SQLException;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all() throws SQLException;
    // insert a new ad and return the new ad's id
    Long insert(Ad ad) throws SQLException;

    List<Ad> getUsersAds(long id) throws SQLException;

    Ad getAdById(long id) throws SQLException;

    Ad updateAdInfo(String title, String description, long id);

    void deleteAd(Ad ad);

    Ad updateAdViewCount(long id);

    }
