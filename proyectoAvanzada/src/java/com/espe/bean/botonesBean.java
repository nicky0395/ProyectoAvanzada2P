/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.bean;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Oscar Fierro <omfierro@espe.edu.ec>
 */
@ManagedBean(name = "botonesBean")
@ViewScoped
public class botonesBean implements Serializable{

    /**
     * Creates a new instance of botonesBean
     */
    private boolean estado;
    private int nombreBoton;
    
    public botonesBean() {
        this.estado = false;
    }
    public botonesBean(boolean estado, int name){
        
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean deshabilitar) {
        this.estado = deshabilitar;
    }

    public int getNombreBoton() {
        return nombreBoton;
    }

    public void setNombreBoton(int nombreBoton) {
        this.nombreBoton = nombreBoton;
        this.estado = true;
    }
    
    public void setValores(boolean btn, int nom){
        this.estado = btn;
        this.nombreBoton = nom;    
    }
    public String getMensajeBtn() {
        System.out.println("Nombre asignado: "+nombreBoton);
        return "Se presiono el botón "+ nombreBoton;
    }
    
}
