/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.dao;

import com.iesvdc.acceso.pojo.Asignatura;
import com.iesvdc.acceso.pojo.Profesor;
import java.util.List;

/**
 *
 * @author matinal
 */
public interface ProAsiDAO {
    public List<Profesor> findProfesoresByAsignatura(Integer asignatura) throws DAOException;
    public List<Asignatura> findAsignaturaByProfesor(Integer profesor) throws DAOException;
}
