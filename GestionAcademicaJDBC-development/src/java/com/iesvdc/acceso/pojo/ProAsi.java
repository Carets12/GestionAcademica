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

@XmlRootElement(name = "proasi")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProAsi {

    @XmlElement
    private Integer asignatura;
    @XmlElement
    private Integer profesor;
    
    public ProAsi() {

    }

    public ProAsi(int asignatura, int profesor) {
        this.asignatura = asignatura;
        this.profesor = profesor;
    }

    public int getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(int asignatura) {
        this.asignatura = asignatura;
    }

    public int getProfesor() {
        return profesor;
    }

    public void setProfesor(int profesor) {
        this.profesor = profesor;
    }
}
