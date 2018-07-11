/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.bean;

import capamodelo.AvionDAO;
import capamodelo.AvionVO;
import capamodelo.ReservaDAO;
import capamodelo.ReservaVO;
import capamodelo.VueloDAO;
import capamodelo.VueloVO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Oscar Fierro <omfierro@espe.edu.ec>
 */
@ManagedBean(name = "avionesBean")
@ViewScoped
public class avionesBean implements Serializable {

    /**
     * Creates a new instance of avionesBean
     */
    private List<AvionVO> aviones;
    private AvionDAO avion;
    private AvionVO claseAvion;
    private List<String> Aerolineas;
    private String nombreAerolinea;

    public avionesBean() {
        aviones = new ArrayList<AvionVO>();
        avion = new AvionDAO();
        claseAvion = new AvionVO();
        aviones = avion.obtenerAviones();
        Aerolineas = new ArrayList<>();
        nombreAerolinea = "";
    }

    public List<String> getAerolineas() {
        for(int i=0; i<aviones.size(); i++){
            Aerolineas.add(aviones.get(i).getAerolinea());
        }
        return Aerolineas;
    }

    public void setAerolineas(List<String> Aerolineas) {
        this.Aerolineas = Aerolineas;
    }

    public String getNombreAerolinea() {
        return nombreAerolinea;
    }

    public void setNombreAerolinea(String nombreAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
    }

    public AvionVO getClaseAvion() {
        return claseAvion;
    }

    public void setClaseAvion(AvionVO claseAvion) {
        this.claseAvion = claseAvion;
    }

    public List<AvionVO> getAviones() {
        return aviones;
    }

    public void setAviones(List<AvionVO> aviones) {
        this.aviones = aviones;
    }

    public AvionDAO getAvion() {
        return avion;
    }

    public void setAvion(AvionDAO avion) {
        this.avion = avion;
    }

}
