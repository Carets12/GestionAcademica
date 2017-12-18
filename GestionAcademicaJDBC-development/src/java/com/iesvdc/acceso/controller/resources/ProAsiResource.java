/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.controller.resources;

import com.iesvdc.acceso.dao.AsignaturaDAO;
import com.iesvdc.acceso.dao.AsignaturaDAOImpl;
import com.iesvdc.acceso.dao.DAOException;
import com.iesvdc.acceso.dao.ProAsiDAO;
import com.iesvdc.acceso.dao.ProAsiDAOImpl;
import com.iesvdc.acceso.pojo.Asignatura;
import com.iesvdc.acceso.pojo.Profesor;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author danic
 */

@Path("/proasi")
public class ProAsiResource {
    @GET
    @Path("asignatura/{asignatura}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Profesor> getProfesorByAsignatura(@PathParam("asignatura") Integer id) {
        ProAsiDAO pr_as_dao = new ProAsiDAOImpl();
        List<Profesor> list_pr;
        try {
            list_pr = pr_as_dao.findProfesoresByAsignatura(Integer.MIN_VALUE);
        } catch (DAOException ex) {
            list_pr = new ArrayList<>();
            System.out.println(ex.getLocalizedMessage());
        }
        return list_pr;
    }

 @GET
    @Path("profesor/{profesor}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Asignatura> getAsignaturaByProfesor(@PathParam("profesor") Integer id) {
        ProAsiDAO pr_as_dao = new ProAsiDAOImpl();
        List<Asignatura> list_as;
        try {
            list_as = pr_as_dao.findAsignaturaByProfesor(Integer.MIN_VALUE);
        } catch (DAOException ex) {
            list_as = new ArrayList<>();
            System.out.println(ex.getLocalizedMessage());
        }
        return list_as;
    }
}

   
