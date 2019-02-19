package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "controllers.DeleteAdServlet", urlPatterns = "/ads/delete")
    public class DeleteAdServlet extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            if (request.getSession().getAttribute("user") == null) {
                response.sendRedirect("/login");
                return;
            }

            long adId = Long.parseLong(request.getParameter( "adId"));
            Ad adInfo = null;
            try {
                adInfo = DaoFactory.getAdsDao().getAdById(adId);

            } catch (SQLException e){
                e.printStackTrace();
            }
            request.setAttribute("adInfo", adInfo);
            request.getRequestDispatcher("/WEB-INF/ads/delete-ad.jsp").forward(request, response);
        }



        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

//            example:
//            User currentUser = (User) request.getSession().getAttribute("user");
//            long userId = currentUser.getId();
//
//            String updateUsername = request.getParameter("username");
//            String updateEmail = request.getParameter("email");
////
//            User updatedUser = DaoFactory.getUsersDao().updateUserInfo(updateUsername, updateEmail, userId);
//
////             5. redirect to profile
//            request.getSession().setAttribute("user", updatedUser);
//            response.sendRedirect("/profile");
//
//        }

        }

//    closes the class:
    }


// here's the plan to get the id:
//for delete
//<form action="ads/delete" method="POST">
//<button name="id" value="${ad.id}" class="btn ntn-danger">
//        --%>