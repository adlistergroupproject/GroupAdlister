package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLSearchesDao;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.dao.Config;
import com.codeup.adlister.util.GetSanitizer;
import com.codeup.adlister.util.SQLQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        System.out.println("DEBUG: /search : doGet(...)");
        System.out.println("DEBUG: getQueryString(...) = " + request.getQueryString());

        // get all the search words in an array of strings
        String[] keywords = request.getQueryString().replaceAll("query=", "").split("[+]");
        List<Ad> searchResults = DaoFactory.getSearchesDao().search(keywords);
        // DEBUG
        for(Ad ad : searchResults){
            System.out.println(ad.getTitle());
        }

        request.setAttribute("searchResults", searchResults);
        request.getRequestDispatcher("/WEB-INF/search.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException
    {
        System.out.println("DEBUG: /search : doPost(...)");
    }
}
