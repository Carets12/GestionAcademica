/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.dao;

import com.iesvdc.acceso.pojo.Alumno;
import com.iesvdc.acceso.pojo.Asignatura;
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
public class AluAsiDAOImpl implements AluAsiDAO{

    public AluAsiDAOImpl() {
    }

    Conexion conex;

    private Connection obtenerConexion() throws DAOException {
        if (conex == null) {
            conex = new Conexion();
        }
        return conex.getConexion();
    }
    
    @Override
    public List<Alumno> findAlumnosByAsignatura(Integer asignatura) throws DAOException {
        Alumno al;
        List<Alumno> list_al = new ArrayList<>();
        String asignatura1 = String.valueOf(asignatura);
        try {
            Connection con = obtenerConexion();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM ALUASI WHERE asignatura=?");
            pstm.setString(1, asignatura1);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                al = new Alumno(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"));
                list_al.add(al);
            }
            con.close();
        } catch (SQLException ex) {
            throw new DAOException("AluAsi:findAlumnosByAsignatura: No puedo conectar a la BBDD ");
        }
        return list_al;
    }

    @Override
    public List<Asignatura> findAsignaturaByAlumno(Integer alumno) throws DAOException {
        Asignatura as;
        List<Asignatura> list_as = new ArrayList<>();
        String alumno1 = String.valueOf(alumno);
        try {
            Connection con = obtenerConexion();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM ALUASI WHERE alumno=?");
            pstm.setString(1, alumno1);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                as = new Asignatura(rs.getString("nombre"), rs.getInt("id"), rs.getInt("curso"), rs.getString("ciclo"));
                list_as.add(as);
            }
            con.close();
        } catch (SQLException ex) {
            throw new DAOException("AluAsi:findAsignaturaByAlumno: No puedo conectar a la BBDD ");
        }
        return list_as;
    }

    @Override
    public Integer findNumeroFaltasAlumno(Integer alumno) throws DAOException {
        int numeroFaltas = 0;
        String alumno1 = String.valueOf(alumno);
        try {
            Connection con = obtenerConexion();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM ALUASI WHERE alumno=?");
            pstm.setString(1, alumno1);
            ResultSet rs = pstm.executeQuery();
            
            numeroFaltas = rs.getInt("faltas");
            con.close();
        } catch (SQLException ex) {
            throw new DAOException("AluAsi:findNumeroFaltasAlumno: No puedo conectar a la BBDD ");
        }
        return numeroFaltas;
    }
}
