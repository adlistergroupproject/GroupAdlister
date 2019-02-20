package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "controllers.DeleteUserServlet", urlPatterns = "/profile/delete")
public class DeleteUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/delete-user.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User currentUser = (User) request.getSession().getAttribute("user");
        System.out.println(currentUser.getUsername());
        System.out.println(currentUser.getId());
        DaoFactory.getUsersDao().deleteUsersAds(currentUser);
        System.out.println("made it past delete ads");
        DaoFactory.getUsersDao().deleteUser(currentUser);
        System.out.println("made it past delete user");
        request.getSession().invalidate();
        response.sendRedirect("/ads");

    }



//    closes the class:
}