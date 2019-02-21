package com.codeup.adlister.controllers;
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
        boolean ifUserIsLoggedIn;
        if (request.getSession().getAttribute("user") != null) {
            ifUserIsLoggedIn = true;
        } else{
            ifUserIsLoggedIn = false;
        }
        request.setAttribute("ifUserIsLoggedIn", ifUserIsLoggedIn);
        request.getRequestDispatcher("/partials/navbar.jsp").forward(request, response);
    }
}