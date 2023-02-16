package org.formation.ouafi.view.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import org.formation.ouafi.controlleur.Zoo;

import java.io.IOException;

@WebServlet(name = "DevorerServlet", value = "/devorer")
public class DevorerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int mangueur_index = Integer.parseInt(request.getParameter("mangeur"));
        int mange_index = Integer.parseInt(request.getParameter("manger"));
        String devorerMsg = Zoo.getInstance().devorer(mangueur_index,mange_index);
        request.setAttribute("msg",devorerMsg);

        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }
}
