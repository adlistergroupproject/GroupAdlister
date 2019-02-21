package com.codeup.adlister.dao;

public class DaoFactory {

    // database accessors
    private static Ads adsDao;
    private static Users usersDao;
    private static Searches searchesDao;
    private static Categories categoriesDao;

    // user configuration for db access
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Searches getSearchesDao(){
        if(searchesDao == null){
            searchesDao = new MySQLSearchesDao(config);
        }
        return searchesDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }

    public static Categories getCategoriesDao(){
        if(categoriesDao == null){
            categoriesDao = new MySQLCategoriesDao(config);
        }
        return categoriesDao;
    }

}
