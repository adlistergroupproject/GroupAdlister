
//THIS CODE BREAKS THE PROFILE PAGE-- NEED TO FIX


//package com.codeup.adlister.controllers;
//
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/edit")
//public class editProfileServlet extends HttpServlet {
//
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        //  get the users information ready to use
//        String username = request.getParameter("username");
//        String email = request.getParameter("email");
//
//        request.getRequestDispatcher("/WEB-INF/edit.jsp").forward(request, response);
//        //  get the users information ready to use
//        //  go to the edit page
//        //  allow the user to change values in a form
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//    }
//        //   send the edited features to the db
//
//
////    closes the class:
//}
