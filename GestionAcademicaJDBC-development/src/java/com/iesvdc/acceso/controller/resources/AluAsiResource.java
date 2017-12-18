/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.controller.resources;

import com.iesvdc.acceso.dao.AluAsiDAO;
import com.iesvdc.acceso.dao.AluAsiDAOImpl;
import com.iesvdc.acceso.dao.AsignaturaDAO;
import com.iesvdc.acceso.dao.AsignaturaDAOImpl;
import com.iesvdc.acceso.dao.DAOException;
import com.iesvdc.acceso.dao.ProAsiDAO;
import com.iesvdc.acceso.dao.ProAsiDAOImpl;
import com.iesvdc.acceso.pojo.Alumno;
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

@Path("/aluasi")
public class AluAsiResource {
    @GET
    @Path("asignatura/{asignatura}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Alumno> getAlumnoByAsignatura(@PathParam("asignatura") Integer id) {
        AluAsiDAO al_as_dao = new AluAsiDAOImpl();
        List<Alumno> list_al;
        try {
            list_al = al_as_dao.findAlumnosByAsignatura(Integer.MIN_VALUE);
        } catch (DAOException ex) {
            list_al = new ArrayList<>();
            System.out.println(ex.getLocalizedMessage());
        }
        return list_al;
    }

 @GET
    @Path("alumno/{alumno}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Asignatura> getAsignaturaByAlumno(@PathParam("alumno") Integer id) {
        AluAsiDAO al_as_dao = new AluAsiDAOImpl();
        List<Asignatura> list_as;
        try {
            list_as = al_as_dao.findAsignaturaByAlumno(Integer.MIN_VALUE);
        } catch (DAOException ex) {
            list_as = new ArrayList<>();
            System.out.println(ex.getLocalizedMessage());
        }
        return list_as;
    }
}
