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
//          get the ad info for the purpose of sticky forms:
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
            System.out.println("YOU MADE IT INTO THE DO POST WOOHOO");
            System.out.println(request.getParameter("adId"));
//          Get the ad id that was submitted by the delete button:
            long adIdToDelete = Long.parseLong(request.getParameter("adId"));
//          Use this id to get the ad object to delete:
            Ad adToDelete = null;
            try {
                adToDelete = DaoFactory.getAdsDao().getAdById(adIdToDelete);
            } catch (SQLException e) {
                e.printStackTrace();
            }

//          Delete the ad from the db:
            DaoFactory.getAdsDao().deleteAd(adToDelete);

//          5. redirect to profile
            response.sendRedirect("/profile");


        }

//    closes the class:
    }


