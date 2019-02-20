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
import java.util.List;

@WebServlet(name = "controllers.ShowAdPageServlet", urlPatterns = "/ads/show")
    public class ShowAdPageServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//      get the user logged in off of the session and only show the edit and delete buttons for their ads not for all ads on the adlister page:
            Boolean showEditDeleteButtons = false;
                if (request.getSession().getAttribute("user") != null) {
                    User user = (User) request.getSession().getAttribute("user");
                    long user_id = user.getId();
                    long adId = Long.parseLong(request.getParameter( "adId"));

    //           using the id to get the Ad object to then get the user_id to compare to the user logged in:
                    Ad adToView= null;
                    try {
                       adToView = DaoFactory.getAdsDao().getAdById(adId);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                      if(user_id == adToView.getUserId()){
                    //  if the user id matches the ad id then display the edit and delete buttons
                          showEditDeleteButtons = true;
                        } else {
                    //  if it doesn't match then don't show the edit and delete buttons
                          showEditDeleteButtons = false;
                      }

                } else {
    //          if the user is null that means they're not logged in and they shouldn't see any edit or delete buttons:
                    showEditDeleteButtons = false;
                }


            long adId = Long.parseLong(request.getParameter( "adId"));
            Ad adInfo = null;
            try {
                adInfo = DaoFactory.getAdsDao().getAdById(adId);

            } catch (SQLException e){
                e.printStackTrace();
            }
            System.out.println(showEditDeleteButtons);
            request.setAttribute("showEditDeleteButtons", showEditDeleteButtons);
            request.setAttribute("adInfo", adInfo);
            request.getRequestDispatcher("/WEB-INF/ads/page.jsp").forward(request, response);
        }
    }
