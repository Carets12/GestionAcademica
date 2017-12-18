/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author profesor
 */

@XmlRootElement(name = "aluasi")
@XmlAccessorType(XmlAccessType.FIELD)
public class AluAsi {

    /*  ASIGNATURA INT,
	ALUMNO INT,
        FALTAS INT,
	PRIMARY KEY(ASIGNATURA,ALUMNO),
	FOREIGN KEY (ALUMNO) REFERENCES ALUMNO(id) ,
	FOREIGN KEY (ASIGNATURA) REFERENCES ASIGNATURA(id) );*/
    
    @XmlElement
    private Integer asignatura;
    @XmlElement
    private Integer alumno;
    @XmlElement
    private Integer faltas;

    public AluAsi() {

    }

    public AluAsi(int asignatura, int alumno, int faltas) {
        this.asignatura = asignatura;
        this.alumno = alumno;
        this.faltas = faltas;
    }

    public int getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(int asignatura) {
        this.asignatura = asignatura;
    }

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

}
