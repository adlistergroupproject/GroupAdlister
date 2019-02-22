package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.StringFormatException;

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
        // DEBUG
        debugPost(request);
        // END DEBUG
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(DaoFactory.getCategoriesDao().getCategory(request.getParameter("categories")));

        Ad ad = null;
        try {
            ad = new Ad(0, user.getId(),
                    request.getParameter("title"),
                    request.getParameter("description"),
                    categoryList,
                    Double.parseDouble(request.getParameter("price")),
                    0);
            DaoFactory.getAdsDao().insert(ad);
            DaoFactory.getCategoriesDao().insertIntoAdCategories(ad);
        } catch(StringFormatException e){
            // TODO: redirect on bad input
            System.out.println("\t\tDEBUG: StringFromatException occurred. Send redirect...");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/ads");
    }

    // The following debug method prints all the content of the request
    private void debugPost(HttpServletRequest request){
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String categories = request.getParameter("categories");
        String price = request.getParameter("price");

        System.out.println("DEBUG: CreateAdServlet.java");
        System.out.println("\tDEBUG: doPost(...)");
        System.out.println("\t\tDEBUG: title = " + title);
        System.out.println("\t\tDEBUG: description = " + description);
        System.out.println("\t\tDEBUG: categories = " + categories);
        System.out.println("\t\tDEBUG: price = " + price);
    }
}