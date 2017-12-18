/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.controller;

import com.iesvdc.acceso.dao.AluAsiDAO;
import com.iesvdc.acceso.dao.AluAsiDAOImpl;
import com.iesvdc.acceso.dao.AlumnoDAO;
import com.iesvdc.acceso.dao.AlumnoDAOImpl;
import com.iesvdc.acceso.dao.DAOException;
import com.iesvdc.acceso.pojo.AluAsi;
import com.iesvdc.acceso.pojo.Alumno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juangu <jgutierrez at iesvirgendelcarmen.coms>
 */
@WebServlet({"/AlumnoAsignaturaRead"})
public class LeerAlumnoAsignatura extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LeerAlumnoAsignatura</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LeerAlumnoAsignatura at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
         AluAsi al_as;
         AluAsiDAO al_as_dao;

        // Cargar un fichero de texto desde un Servlet
        /*ServletContext context = getServletContext();
	InputStream resourceContent = context.getResourceAsStream("/WEB-INF/lib/db.prop");
        props = new Properties();
        props.load(resourceContent);
        this.base_datos = props.getProperty("base_datos");
        this.driver     = Integer.parseInt(props.getProperty("driver"));
        this.host       = props.getProperty("host");
        this.password   = props.getProperty("password");
        this.usuario    = props.getProperty("usuario");
        this.puerto     = props.getProperty("puerto");  
         */
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CrearAlumnoAsignatura</title>");
            out.println("</head>");
            out.println("<body>");

            // al=new Alumno("Juan", "Sin Miedo");
            al_as_dao = new AluAsiDAOImpl();

            try {
                List<Alumno> li_al_as = al_as_dao.findAlumnosByAsignatura(Integer.MIN_VALUE);
                out.println("<ol>");
                for (Alumno alumno : li_al_as) {
                    out.println("<li>");
                    out.println(alumno.getApellido() + " " + alumno.getNombre());
                    out.println("<a href=\"LeerAlumnosPorAsignatura?id=" + alumno.getId()
                            + "&nombre=" + alumno.getNombre() + "&apellido="
                            + alumno.getApellido() + "\">" + "actualizar</a>");
                    out.println("</li>");
                }
                out.println("</ol>");
            } catch (DAOException ex) {
                Logger.getLogger(ex.getLocalizedMessage());
            }

            out.println("</body>");
            out.println("</html>");
        }
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
