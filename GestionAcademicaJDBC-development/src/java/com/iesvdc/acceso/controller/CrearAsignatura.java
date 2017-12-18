/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.controller;

import com.iesvdc.acceso.dao.AsignaturaDAO;
import com.iesvdc.acceso.dao.AsignaturaDAOImpl;
import com.iesvdc.acceso.dao.DAOException;
import com.iesvdc.acceso.pojo.Asignatura;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author profesor
 */
public class CrearAsignatura extends HttpServlet {

    private Properties props;
    private Integer driver;
    private String host;
    private String puerto;
    private String base_datos;
    private String usuario;
    private String password;

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        Asignatura as;
        AsignaturaDAO as_dao;

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
            out.println("<title>Servlet CrearAsignatura</title>");
            out.println("</head>");
            out.println("<body>");

            String nombre = request.getParameter("nombre");
            String id = request.getParameter("id");
            String curso = request.getParameter("curso");
            String ciclo = request.getParameter("ciclo");
           
            as = new Asignatura(nombre,Integer.parseInt(id), Integer.parseInt(curso), ciclo);

            as_dao = new AsignaturaDAOImpl();

            try {
                as_dao.create(as);
                out.println("Asignatura creada con éxito");
            } catch (DAOException ex) {
                out.println(ex.getLocalizedMessage());
                Logger.getLogger(CrearAsignatura.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // pintar formulario
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CrearAsignatura</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"well\">\n"
                    + "		<form role=\"form\" method=\"post\">\n"
                    + "		  <div class=\"form-group\">\n"
                    + "		    <label for=\"nombre\">Nombre:</label>\n"
                    + "		    <input type=\"nombre\" class=\"form-control\" name=\"nombre\">\n"
                    + "		  </div>	\n"
                    + "		  <div class=\"form-group\">\n"
                    + "		    <label for=\"id\">Id:</label>\n"
                    + "		    <input type=\"id\" class=\"form-control\" name=\"id\">\n"
                    + "		  </div>		  \n"
                    + "           <div class=\"form-group\">\n"
                    + "		    <label for=\"curso\">Curso:</label>\n"
                    + "		    <input type=\"curso\" class=\"form-control\" name=\"curso\">\n"
                    + "		  </div>		  \n"  
                    + "            <div class=\"form-group\">\n"
                    + "		    <label for=\"ciclo\">Ciclo:</label>\n"
                    + "		    <input type=\"ciclo\" class=\"form-control\" name=\"ciclo\">\n"
                    + "		  </div>		  \n"
                    + "		  <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n"
                    + "		</form>\n"
                    + "	</div>");
            out.println("</body>");
            out.println("</html>");
        }
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
