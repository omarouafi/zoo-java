package org.formation.ouafi.view.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import org.formation.ouafi.controlleur.Zoo;

import java.io.IOException;

@WebServlet(name = "NourrirServlet", value = "/nourrir")
public class NourrirServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        Zoo zoo = Zoo.getInstance();
        zoo.nourrir();
        request.getRequestDispatcher("/index.jsp").forward(request,response);
        }catch(Exception e){
            response.sendError(500, "Quelque chose s'est mal passé");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
