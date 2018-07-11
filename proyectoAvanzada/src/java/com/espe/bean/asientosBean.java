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
import com.espe.modelo.asiento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.DragDropEvent;

/**
 *
 * @author Oscar Fierro <omfierro@espe.edu.ec>
 */
@ManagedBean(name = "asientosBean")
@ViewScoped
public class asientosBean implements Serializable {

    /**
     * Creates a new instance of asientosBean
     */
    private List<asiento> asientos;
    private asiento A;
    private List<asiento> asientosReservados;
    private AvionVO avionVO;
    private AvionDAO avionesDAO;
    private VueloDAO vuelosDAO;
    private ReservaDAO reservasDAO;
    private String nombreAsiento;
    private asiento AsientoSeleccionado;
    private int codigoV;
    private int codigoA;
    public asientosBean() {
        A = new asiento();
        asientos = A.retornoAsientos();
        
        asientosReservados = new ArrayList<asiento>();
        reservasDAO = new ReservaDAO();
        avionVO = new AvionVO();
        avionesDAO = new AvionDAO();
        vuelosDAO = new VueloDAO();
    }

    public void onCarDrop(DragDropEvent ddEvent) {
        asiento car = ((asiento) ddEvent.getData());
        asientosReservados.add(car);
        asientos.remove(car);
    }

    public void conCambio(String nombreA) {
        int codigoAvion = avionesDAO.obtenerCodigoAvion(nombreA);
        int codigoVuelo = vuelosDAO.CodigoVuelo(codigoAvion);

        A = new asiento();
        asientos = A.retornoSeleccionando(codigoVuelo, nombreA);
        asientosReservados = new ArrayList<asiento>();
    }

    public List<asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<asiento> asientos) {
        this.asientos = asientos;
    }

    public asiento getA() {
        return A;
    }

    public void setA(asiento A) {
        this.A = A;
    }

    public List<asiento> getAsientosReservados() {
        return asientosReservados;
    }

    public void setAsientosReservados(List<asiento> asientosReservados) {
        this.asientosReservados = asientosReservados;
    }

    public asiento getAsientoSeleccionado() {
        return AsientoSeleccionado;
    }

    public void setAsientoSeleccionado(asiento AsientoSeleccionado) {
        this.AsientoSeleccionado = AsientoSeleccionado;
    }

}
