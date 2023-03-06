package org.formation.ouafi.view.controller;



import org.formation.ouafi.controlleur.Zoo;
import org.formation.ouafi.service.CagePojo;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public final class InitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{


        List<CagePojo> modeleCagePojo = Zoo.getInstance().getPojos();
        request.setAttribute("modele",modeleCagePojo);
        request.getRequestDispatcher("principal.jsp").forward(request,response);
        }catch(Exception e){
            response.sendError(500,"Quelque chose s'est mal passé");
        }
    }


}
