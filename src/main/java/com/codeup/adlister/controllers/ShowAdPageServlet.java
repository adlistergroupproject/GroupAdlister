package com.codeup.adlister.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet(name = "controllers.ShowAdPageServlet", urlPatterns = "/ads/show")
    public class ShowAdPageServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String adId = request.getParameter("adid");
            request.getRequestDispatcher("/WEB-INF/ads/show.jsp").forward(request, response);

        }
    }
