/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.modelo;

import capamodelo.ReservaDAO;
import capamodelo.ReservaVO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oscar Fierro <omfierro@espe.edu.ec>
 */
public class asiento {

    private int numero;
    private int vuelo;
    private String descripcion;
    private String Nombre;
    private int tamanio;
    private ReservaDAO asientosD;
    private ReservaVO asientoV;

    public asiento() {
    }

    public asiento(int numero, int vuelo, String descripcion, String Nombre) {
        this.numero = numero;
        this.vuelo = vuelo;
        this.descripcion = descripcion;
        this.Nombre = Nombre;
        tamanio = 0;
    }

    public List retornoAsientos() {
        asientosD = new ReservaDAO();
        ArrayList<asiento> A = new ArrayList<>();
        asiento as;
        for (int i = 0; i < 20; i++) {
            as = new asiento((i + 1), i + 1, "ventana", "tame");
            A.add(as);
        }
        return A;
    }

    public List retornoSeleccionando(int num, String nombre) {
        asientosD = new ReservaDAO();
        asientoV = new ReservaVO();

        ArrayList<asiento> A = new ArrayList<>();
        ArrayList<Integer> lista = new ArrayList<>();

        lista = (ArrayList<Integer>) asientosD.obtenerAsientosOcupados(num);
        asiento as;
        String var = "";
        for (int i = 0; i < lista.size(); i++) {
            if (i % 2 == 0) {
                var = "";
                var = "Asiento ventana";

            } else {
                var = "";
                var = "Asiento pasillo";
            }
            as = new asiento(lista.get(i), num, var, nombre);
            A.add(as);
        }
        return A;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getVuelo() {
        return vuelo;
    }

    public void setVuelo(int vuelo) {
        this.vuelo = vuelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

}
