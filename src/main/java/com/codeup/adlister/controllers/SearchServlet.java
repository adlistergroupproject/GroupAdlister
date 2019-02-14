package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.MySQLSearchDao;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.dao.Config;

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

        String query = request.getQueryString();

        List<Ad> searchResults = new MySQLSearchDao(new Config()).search(query, query);
        if(searchResults == null){
            System.out.println("DEBUG: no search results.");
        }else{
            for(Ad ad : searchResults){
                System.out.println("DEBUG: " + ad.getTitle());
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException
    {
        System.out.println("DEBUG: /search : doPost(...)");
    }
}
