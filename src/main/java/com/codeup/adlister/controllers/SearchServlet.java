package com.codeup.adlister.controllers;

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

        // get all the search works in an array of strings
        String[] keywords = request.getQueryString().replaceAll("query=", "").split("[+]");

        // begin constructing the query
        SQLQuery query = new SQLQuery()
                .select("*").from("ads");
        {
            int index = 0;
            for(String keyword : keywords) {
                if (index == 0) {
                    query = query.where("title").like(keyword)
                            .and("description").like(keyword);
                } else {
                    query = query.or("title").like(keyword)
                            .and("description").like(keyword);
                }
                index++;
            }
            query = query.done();
        }

        System.out.println(query.toString());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException
    {
        System.out.println("DEBUG: /search : doPost(...)");
    }
}
