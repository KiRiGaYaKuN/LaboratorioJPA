/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.student.session.ClaseFacadeLocal;
import co.edu.unipiloto.student.session.CursoFacadeLocal;
import co.edu.unipiloto.student.session.StudentFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cristian-patino
 */
public class AgregarAlCurso extends HttpServlet {

    @EJB
    private CursoFacadeLocal cursoFacade;

    @EJB
    private StudentFacadeLocal studentFacade;

    @EJB
    private ClaseFacadeLocal claseFacade;
    
    

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            int studentId = Integer.valueOf(request.getParameter("studentId"));
            int cursoID =  Integer.valueOf(request.getParameter("cursoId"));
            
            if(claseFacade.insertarClase(studentId, cursoID, 433, 0)){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet AgregarAlCurso</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Se ha agregado al estudiante " + studentFacade.find(studentId).getFirstname() + " al curso " + cursoFacade.find(cursoID).getNombre() + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }else{
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet AgregarAlCurso</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>No existe el NRC " + cursoID + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
            
        }
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
