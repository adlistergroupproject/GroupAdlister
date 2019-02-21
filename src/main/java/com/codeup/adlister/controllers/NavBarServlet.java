package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "controllers.NavBarServlet")
public class NavBarServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean ifUserIsLoggedIn = false;
        System.out.println(ifUserIsLoggedIn);
        System.out.println("should be false");


        if (request.getSession().getAttribute("user") != null) {
            User user = (User) request.getSession().getAttribute("user");
            ifUserIsLoggedIn = true;
            System.out.println(ifUserIsLoggedIn);
            System.out.println("should be true");
        } else{
            ifUserIsLoggedIn = false;
            System.out.println(ifUserIsLoggedIn);
            System.out.println("should be false");
        }

        request.setAttribute("ifUserIsLoggedIn", ifUserIsLoggedIn);

    }
}