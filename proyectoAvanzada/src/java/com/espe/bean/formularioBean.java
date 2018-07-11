/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.bean;

import capamodelo.AvionDAO;
import capamodelo.ReservaDAO;
import capamodelo.ReservaVO;
import capamodelo.VueloDAO;
import capamodelo.clienteDAO;
import capamodelo.clienteVO;
import com.espe.modelo.asiento;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.commons.lang3.StringEscapeUtils;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

/**
 *
 * @author Oscar Fierro <omfierro@espe.edu.ec>
 */
@ManagedBean(name = "formularioBean")
@ViewScoped
public class formularioBean implements Serializable {

    /**
     * Creates a new instance of formularioBean
     */
    private String cedula;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private String fechaN;
    private List<asiento> asientoLista;
    private String nombreAerolinea;
    private String origenDestino;

    public formularioBean() {
        cedula = "";
        nombre = "";
        apellido = "";
        nacionalidad = "";
        fechaN = "";
        asientoLista = new ArrayList<>();
        nombreAerolinea = "";
        origenDestino = "";
    }

    public void registrar() throws ParseException {

//        System.out.println("ced: " + cedula + ", nombre: " + nombre + "apellido: " + apellido);
//        asientosBean a = new asientosBean();
//        for (int i = 0; i < asientoLista.size(); i++) {
//            System.out.println("asiento " + (i + 1) + ":...." + this.asientoLista.get(i).getNumero());
//        }
//
//        System.out.println("Nacionalidad: " + nacionalidad);
//        System.out.println("Fecha: " + fechaN);
//        avionesBean av = new avionesBean();
//        System.out.println("avion: " + this.nombreAerolinea);
        //registro del cliente
        clienteDAO cliDAO = new clienteDAO();
        clienteVO nuevoCliente = new clienteVO(cliDAO.obtenerUltimoCodigo() + 1, cedula, nacionalidad, nombre, apellido, ConvertirFecha(fechaN));
        cliDAO.registrarCliente(nuevoCliente);

        //Obtener codigo avion
        AvionDAO avDAO = new AvionDAO();
        int codigoAvion = avDAO.obtenerCodigoAvion(nombreAerolinea);
        //Obtener codigo vuelo
        VueloDAO vlDAO = new VueloDAO();
        System.out.println("origenDestino: " + origenDestino);
        int codigoVuelo = 1;

        //codigoVuelo = vlDAO.obtenerCodigoVuelos(origenDestino);
        System.out.println("Codigo vuelo obtenido: " + codigoVuelo);

        //registro de la reserva
        ReservaDAO resDAO = new ReservaDAO();
        for (int i = 0; i < asientoLista.size(); i++) {
            ReservaVO nuevaReserva = new ReservaVO(resDAO.obtenerUltimoCodigo() + 1, cliDAO.obtenerCodigoCliente(cedula), codigoVuelo, asientoLista.get(i).getNumero());
            resDAO.InsertarReserva(nuevaReserva);
            System.out.println("Datos reserva: " + nuevaReserva.getCod_reserva() + " - " + nuevaReserva.getCod_cliente()
                    + " - " + nuevaReserva.getCod_vuelo() + " - " + nuevaReserva.getNumero_asiento());
        }
        notificarPUSH();
    }

    public void notificarPUSH() {
        String summary = "Nueva reserva";
        String detail = "Reserva guardada";
        String CHANNEL = "/notify";

        EventBus eventBus = EventBusFactory.getDefault().eventBus();
        eventBus.publish(CHANNEL, new FacesMessage(StringEscapeUtils.escapeHtml3(summary), StringEscapeUtils.escapeHtml3(detail)));
    }

    private java.sql.Date ConvertirFecha(String fecha) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(fecha);
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
        return sql;
    }

    public void Lista(List<asiento> a, String n) {
        this.asientoLista = a;
        this.nombreAerolinea = n;
    }

    public String getNombreAerolinea() {
        return nombreAerolinea;
    }

    public void setNombreAerolinea(String nombreAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
    }

    public String getOrigenDestino() {
        return origenDestino;
    }

    public void setOrigenDestino(String origenDestino) {
        this.origenDestino = origenDestino;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFechaN() {
        return fechaN;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

}
