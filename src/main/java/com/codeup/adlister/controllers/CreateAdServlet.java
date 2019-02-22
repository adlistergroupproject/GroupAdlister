package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        List<Category> categories = DaoFactory.getCategoriesDao().getAllCategories();
        // DEBUG
        System.out.println("DEBUG: number of categories: " + categories.size());
        // END DEBUG
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        request.getParameter("category");
        List<Category> categories = new ArrayList<>();
        // TODO: add price and categories here
        Ad ad = new Ad(
            user.getId(),
            request.getParameter("title"),
            request.getParameter("description")
        );
        try {
            DaoFactory.getAdsDao().insert(ad);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/ads");
    }
}
// when the ad is created, we need to insert the ad into the ad table, and then we need to get the ad object, and we need a new method that takes
// in the ad object and then we can access the category list