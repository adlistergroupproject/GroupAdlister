//THIS CODE BREAKS THE PROFILE PAGE-- NEED TO FIX

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

//        get the users information ready to use
//        String username = (String) request.getSession().getAttribute("username");
//        User user = DaoFactory.getUsersDao().findByUsername(username);
//        request.getSession().setAttribute("username", user.getUsername());
//        request.getSession().setAttribute("email", user.getEmail());
//        request.getSession().setAttribute("password", user.getPassword());
//        System.out.println(username);
//        System.out.println(user.getEmail());
//        System.out.println(user.getPassword());
//


//        String username = (String) request.getSession().getAttribute("username");
//        String password = (String) request.getSession().getAttribute("password");
//        String email = (String) request.getSession().getAttribute("email");
//        request.setAttribute("username", user.getUsername());
//        request.setAttribute("password", password);
//        request.setAttribute("email", email);


//        get the users information ready to use
//        go to the edit page
//        allow the user to change values in a form
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        get the users information ready to use
        String username = (String) request.getSession().getAttribute("username");
        User user = DaoFactory.getUsersDao().findByUsername(username);
        request.getSession().setAttribute("username", user.getUsername());
        request.getSession().setAttribute("email", user.getEmail());
        request.getSession().setAttribute("password", user.getPassword());
        System.out.println(username);
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());


        //   send the edited features to the db
    }





//    closes the class:
}
