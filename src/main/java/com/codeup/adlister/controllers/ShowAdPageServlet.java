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

            long adId = Long.parseLong(request.getParameter( "adId"));
//            String adTitle = request.getParameter("adTitle");
//            String adDescription = request.getParameter("adDescription");


            Ad adInfo = null;
            try {
                adInfo = DaoFactory.getAdsDao().getAdById(adId);

            } catch (SQLException e){
                e.printStackTrace();
            }

            request.setAttribute("adInfo", adInfo);

//            request.setAttribute("adTitle", adTitle);
//            request.setAttribute("adDescription", adDescription);
//            request.setAttribute("adId", adId);



            request.getRequestDispatcher("/WEB-INF/ads/page.jsp").forward(request, response);
        }
    }
