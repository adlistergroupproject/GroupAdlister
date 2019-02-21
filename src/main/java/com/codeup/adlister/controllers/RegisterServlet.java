package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

//     check if the username is already being used:
        User userAlreadyExists = DaoFactory.getUsersDao().findByUsername(username);
//      check if the email is already being used:
        User emailBeingUsed = DaoFactory.getUsersDao().findByEmail(email);

        if(userAlreadyExists == null) {
            if(emailBeingUsed == null) {
//                response.sendRedirect("/register");


                // validate input
                boolean inputHasErrors = username.isEmpty()
                        || email.isEmpty()
                        || password.isEmpty()
                        || (!password.equals(passwordConfirmation));

                if (inputHasErrors) {
                    response.sendRedirect("/register");
                    return;
                } else {
                    // create and save a new user
                    User user = new User(username, email, password);
                    DaoFactory.getUsersDao().insert(user);
                    response.sendRedirect("/login");
                }
//          if the email is already used send to failure page:
            } else {
                response.sendRedirect("/register/failure/email");
            }
//          if the username is already used send to failure page:
        } else {
            response.sendRedirect("/register/failure");
        }
    }
}
