/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.entitys.Estudiante;
import co.edu.unipiloto.session.EstudianteFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ingse
 */
@WebServlet(name = "EstudianteServlet", urlPatterns = {"/EstudianteServlet"})
public class EstudianteServlet extends HttpServlet {

    @EJB
    private EstudianteFacadeLocal estudianteFacade;
    Estudiante estudiante;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        //response.setContentType("text/html;charset=UTF-8");
        String idStr = request.getParameter("studentId");
        int studentId = 0;
                if (idStr != null && !idStr.equals("")) {
            studentId = Integer.parseInt(idStr);
        }
        String firstNameStr = request.getParameter("firstName");
        String lastNameStr = request.getParameter("lastName");
        String yearStr = request.getParameter("yearLevel");
        int yearLevel = 0;
        if (yearStr!=null && !yearStr.equals("")) {
            yearLevel = Integer.parseInt(yearStr);
        }
        
        estudiante = new Estudiante(studentId,firstNameStr,lastNameStr,yearLevel);  
        
          if ("Add".equalsIgnoreCase(action)) {
            estudianteFacade.create(estudiante);
        } else if ("Edit".equalsIgnoreCase(action)) {
            estudianteFacade.edit(estudiante);
        } else if ("Delete".equalsIgnoreCase(action)) {
             estudianteFacade.remove(estudiante);
        } else if ("Search".equalsIgnoreCase(action)) {
            estudianteFacade.find(studentId);
        }
        
        
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("student", estudiante);
        request.setAttribute("allStudent", estudianteFacade.findAll());
        request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

       
}
