package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controllers.ChangePasswordServlet", urlPatterns = "/change-password")
public class ChangePasswordServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/change-password.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //  get the user object from the session:
        User currentUser = (User) request.getSession().getAttribute("user");
        long userId = currentUser.getId();

        //  get the password from the user object
        String originalPassword = currentUser.getPassword();

        //  get the password the user entered:
        String enteredPasswordComparison = request.getParameter("password");

        //  get the hashed pw from the user object to compare with the entered old password:
        //  The password on the user is hashed, so we need to compare the entered password to the hashed password with BCrypt:
        boolean comparePasswords = (BCrypt.checkpw(enteredPasswordComparison, originalPassword));
        if (!comparePasswords) {
            System.out.println("Invalid Password");
            response.sendRedirect("/invalid-password");

        //  If the password on the user matches the password entered, then the user can move to change password:
         } else if(comparePasswords) {

        //  Now we need to check if the new password and confirm password match:
        String newPassword = request.getParameter("new_password");
        String confirmPassword = request.getParameter("confirm_password");

            if(newPassword.equals(confirmPassword)) {
        //  if the passwords match, it will show "passwords match" message on the page and in the console
                System.out.println("Passwords match!");

            //  hash the new password before saving into the db:
                String newPasswordHash = BCrypt.hashpw(newPassword, BCrypt.gensalt());
                System.out.println(newPasswordHash);

            //  update the password on the db:
                User updatedUser = DaoFactory.getUsersDao().updateUserPassword(newPasswordHash, userId);
            //  this will set the session to the new updated user object
                request.getSession().setAttribute("user", updatedUser);
             //  redirect to profile
                response.sendRedirect("/profile");

            } else {
            // on the page and in the console and not allow user to proceed
                System.out.println("Passwords don't match");
                response.sendRedirect("/passwords-dont-match");
            }
    }

//    closes the class:
}



//TODO: our objective is to append a query string key=>value pair to the URL of where you're headed
//    possibly setQueryString method and that will last one page load only
//    research this: https://www.ocpsoft.org/opensource/how-to-safely-add-modify-servlet-request-parameter-values/

}
