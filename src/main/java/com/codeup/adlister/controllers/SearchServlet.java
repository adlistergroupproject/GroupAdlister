package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "controllers.SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        System.out.println("DEBUG: /search : doGet(...)");
        System.out.println("DEBUG: getQueryString(...) = " + request.getQueryString());
        /*
        List<Ad> searchResults;
        try {
            userAds = DaoFactory.getAdsDao().getUsersAds(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException
    {
        System.out.println("DEBUG: /search : doPost(...)");
    }
}
