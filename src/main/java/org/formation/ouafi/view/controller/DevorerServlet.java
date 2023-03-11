package org.formation.ouafi.view.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.formation.ouafi.controlleur.Zoo;

import java.io.IOException;

@WebServlet(name = "DevorerServlet", value = "/devorer")
public class DevorerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{


        int mangueurIndex = Integer.parseInt(request.getParameter("mangeur"));
        int mangeIndex = Integer.parseInt(request.getParameter("manger"));
        String devorerMsg = Zoo.getInstance().devorer(mangueurIndex,mangeIndex);
        request.setAttribute("msg",devorerMsg);

        request.getRequestDispatcher("/index.jsp").forward(request,response);
        }catch (Exception e){
            response.sendError(500,"Quelque chose s'est mal passé");
        }
    }
}
