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


@WebServlet(name = "controllers.editAdsServlet", urlPatterns = "/edit-ad")
public class editAdsServlet extends HttpServlet {

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

        request.getRequestDispatcher("/WEB-INF/ads/edit-ad.jsp").forward(request, response);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("line above the problem");
        long adId = Long.parseLong(request.getParameter( "adId"));
        System.out.println(adId);

////      get the Ad:
//        Ad adInfo = null;
//        try {
//            adInfo = DaoFactory.getAdsDao().getAdById(adId);
////
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
//        request.setAttribute("adId", adId);
//        request.setAttribute("adInfo", adInfo);
//        System.out.println(adId);
//        System.out.println(adInfo);


//      get the edited info from the form
        String updateTitle = request.getParameter("title");
        String updateDescription = request.getParameter("description");

//     updates the Ad object in the db
       DaoFactory.getAdsDao().updateAdInfo(updateTitle, updateDescription, adId);


//     5. redirect to profile
       response.sendRedirect("/profile");

    }



//    closes the class
}
