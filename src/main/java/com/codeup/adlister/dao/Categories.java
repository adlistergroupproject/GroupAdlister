package com.codeup.adlister.dao;

import java.util.List;

public interface Categories {

    String getCategory(int index);

    String getCategory(String key);

    List<String> getKeys();

}
