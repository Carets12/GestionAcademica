/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.dao;

import com.iesvdc.acceso.pojo.Alumno;
import com.iesvdc.acceso.pojo.Asignatura;
import com.iesvdc.acceso.pojo.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matinal
 */
public class ProAsiDAOImpl implements ProAsiDAO{
    
    public ProAsiDAOImpl() {
    }

    Conexion conex;

    private Connection obtenerConexion() throws DAOException {
        if (conex == null) {
            conex = new Conexion();
        }
        return conex.getConexion();
    }

    @Override
    public List<Profesor> findProfesoresByAsignatura(Integer asignatura) throws DAOException {
        Profesor pr;
        List<Profesor> list_pr = new ArrayList<>();
        String asignatura1 = String.valueOf(asignatura);
        try {
            Connection con = obtenerConexion();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM PROASI WHERE asignatura=?");
            pstm.setString(1, asignatura1);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                pr = new Profesor(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"));
                list_pr.add(pr);
            }
            con.close();
        } catch (SQLException ex) {
            throw new DAOException("AluPro:findProfesoresByAsignatura: No puedo conectar a la BBDD ");
        }
        return list_pr;
    }

    @Override
    public List<Asignatura> findAsignaturaByProfesor(Integer profesor) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
