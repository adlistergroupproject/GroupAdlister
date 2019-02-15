
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

//todo:
//insert statement
//method is on the interface
//create the method updated the db and returns the user in the dao
//replace the object on the session with the new updated user (look at login)


//do this whole thing over for passwords on a different servlet and hash
//similar method to the one for username and password
//a lot of the stuff we need for this is in the comments in this page




//password stuff:
//gets the current user info from session
//User user = request.getSession().getAttribute("user");

//    String originalPassword = user.getPassword(); this is from the user object
//    String currentPasswordCheck = request.getParameter("current_password"); this is from the form

//   String newPassword = request.getParameter("new_password);

//BCrypt checkhash()

//if (valid) {
//    user = DaoFactory.getUsersDao().updatePassword(newPassword);
//        }




//        1. Check if the current password matches the password on the DB
//                boolean validatePassword = password.equals(user.getPassword());

//        2. Check if the new password matches the confirm password
//               String passwordIncorrect;
//               String newPasswordDoesntMatch;

//        if(true){
//                    if(newPassword.equals(confirmNewPassword)){
////                      then good to go, allowed to click save button
//
//                    } else {
//                    // display a message that new passwords don't match
//                    newPasswordDoesntMatch = "Passwords do not match. Please try again.";
//                    request.setAttribute("newPasswordDoesntMatch", newPasswordDoesntMatch );
//
//                    }
//                // if current password typed in doesn't match whats on the db
//                } else {
//                // put an error message that password doesn't match old password
//                      passwordIncorrect = "Incorrect Password. Please enter your current password:";
//                      request.setAttribute("passwordIncorrect", passwordIncorrect);
//                      response.sendRedirect("/edit");
//                }
//
//
////                3. Hash the new password
////                        hashpassword method here
//
////                      4. Update the password in the DB
////                          call the updateUser method here to update info in the database