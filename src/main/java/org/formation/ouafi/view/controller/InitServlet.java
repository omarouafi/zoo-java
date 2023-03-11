package org.formation.ouafi.view.controller;



import org.formation.ouafi.controlleur.Zoo;
import org.formation.ouafi.service.CagePojo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public final class InitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        Zoo controleur= Zoo.getInstance();
        String msg = request.getParameter("msg");
        List<CagePojo> modeleCagePojo = controleur.getPojos();
        request.setAttribute("modele",modeleCagePojo);
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("principal.jsp").forward(request,response);
        }catch(Exception e){
            response.sendError(500,e.getMessage());
        }
    }


}
