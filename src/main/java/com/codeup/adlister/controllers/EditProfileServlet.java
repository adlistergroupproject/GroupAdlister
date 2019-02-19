
package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//
@WebServlet(name = "controllers.EditProfileServlet", urlPatterns = "/profile/edit")
public class EditProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/edit.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//      Send the edited features to the db:
//            Get all of the needed inputs:
                User currentUser = (User) request.getSession().getAttribute("user");
                long userId = currentUser.getId();

                String updateUsername = request.getParameter("username");
                String updateEmail = request.getParameter("email");
//
                 User updatedUser = DaoFactory.getUsersDao().updateUserInfo(updateUsername, updateEmail, userId);

//             5. redirect to profile
                 request.getSession().setAttribute("user", updatedUser);
                 response.sendRedirect("/profile");

    }

//    closes the class:
}
