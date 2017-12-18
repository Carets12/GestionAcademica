/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.dao;

import com.iesvdc.acceso.pojo.Alumno;
import com.iesvdc.acceso.pojo.Asignatura;
import java.util.List;

/**
 *
 * @author matinal
 */
public interface AluAsiDAO {
    public List<Alumno> findAlumnosByAsignatura(Integer asignatura) throws DAOException;
    public List<Asignatura> findAsignaturaByAlumno(Integer asignatura) throws DAOException;
    public Integer findNumeroFaltasAlumno(Integer alumno) throws DAOException;
}
