
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
@WebServlet(name = "controllers.EditProfileServlet", urlPatterns = "/edit")
public class EditProfileServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/edit.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

//      Gets the user info from the session and puts it in the form values
        String username = (String) request.getSession().getAttribute("username");
        User user = DaoFactory.getUsersDao().findByUsername(username);
        request.getSession().setAttribute("username", user.getUsername());
        request.getSession().setAttribute("email", user.getEmail());
        request.getSession().setAttribute("password", user.getPassword());

//      Send the edited features to the db:
//            Get all of the needed inputs:
                String updateUsername = request.getParameter("updateUsername");
                String updateEmail = request.getParameter("updateEmail");
                String password = request.getParameter("password");
                String newPassword = request.getParameter("newPassword");
                String confirmNewPassword = request.getParameter("confirmNewPassword");

//        1. Check if the current password matches the password on the DB
                boolean validatePassword = password.equals(user.getPassword());
//        2. Check if the new password matches the confirm password
                if(validatePassword){
                    if(newPassword.equals(confirmNewPassword)){
//
                    } else {
//                        message tht new passwords dont match
                    }
                } else {
//                    put an error message that password doesnt match old password
                }


//                3. Hash the new password

//                      4. Update the password in the DB



    }





//    closes the class:
}
