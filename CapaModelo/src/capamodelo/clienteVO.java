/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capamodelo;

import java.sql.Date;

/**
 * 
 * @author Oscar Fierro <omfierro@espe.edu.ec>
 */
public class clienteVO {
    private int codigo;
    private String cedula;
    private String nacionalidad;
    private String nombre;
    private String apellido;
    private java.sql.Date fechaN;

    public clienteVO() {
    }

    public clienteVO(int codigo, String cedula, String nacionalidad, String nombre, String apellido, Date fechaN) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.nacionalidad = nacionalidad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaN = fechaN;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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

    public Date getFechaN() {
        return fechaN;
    }

    public void setFechaN(Date fechaN) {
        this.fechaN = fechaN;
    }
    
    

}
