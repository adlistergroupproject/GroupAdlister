package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.MySQLSearchesDao;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.dao.Config;
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

        //String query = request.getQueryString();

        SQLQuery query = new SQLQuery().select("*").from("users").where("user_id").like("1").done();
        query = new SQLQuery().select("user_id").from("users").where("user_id").like("2").done();

        System.out.println(query.toString());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException
    {
        System.out.println("DEBUG: /search : doPost(...)");
    }
}
