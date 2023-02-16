package org.formation.ouafi.view.controller;



import org.formation.ouafi.controlleur.Zoo;
import org.formation.ouafi.service.CagePojo;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public final class InitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public InitServlet(){

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CagePojo> modeleCagePojo = Zoo.getInstance().getPojos();
        request.setAttribute("modele",modeleCagePojo);
        request.getRequestDispatcher("principal.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
