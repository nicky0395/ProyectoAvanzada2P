/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.bean;

import capamodelo.ReservaDAO;
import capamodelo.ReservaVO;
import capamodelo.VueloDAO;
import capamodelo.VueloVO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Oscar Fierro <omfierro@espe.edu.ec>
 */
@ManagedBean(name = "vuelosBean")
@ViewScoped
public class vuelosBean implements Serializable{

    /**
     * Creates a new instance of vuelosBean
     */
    private List<VueloVO> vuelos;
    private VueloDAO vuelo;  
    private String nombreVuelo;
    private List<String> listaVuelos;
    
    public vuelosBean() {
        vuelos = new ArrayList<VueloVO>();
        vuelo = new VueloDAO();
        vuelos =vuelo.obtenerVuelos();
        listaVuelos = new ArrayList<>();
        nombreVuelo = "";
    }

    public List<String> getRutas() {
        listaVuelos = new ArrayList<>();
        for(int i=0; i<vuelos.size(); i++){
            listaVuelos.add(vuelos.get(i).getOrigen() +" - "+vuelos.get(i).getDestino());
        }
        return listaVuelos;
    }
    
    public VueloDAO getVuelo() {
        return vuelo;
    }

    public void setVuelo(VueloDAO vuelo) {
        this.vuelo = vuelo;
    }

    public List<String> getListaVuelos() {
        return listaVuelos;
    }

    public void setListaVuelos(List<String> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }

    
    public List<VueloVO> getVuelos() {
        return vuelos;
    }

    public String getNombreVuelo() {
        return nombreVuelo;
    }

    public void setNombreVuelo(String nombreVuelo) {
        this.nombreVuelo = nombreVuelo;
    }

    public void setVuelos(List<VueloVO> vuelos) {
        this.vuelos = vuelos;
    }
    
}
