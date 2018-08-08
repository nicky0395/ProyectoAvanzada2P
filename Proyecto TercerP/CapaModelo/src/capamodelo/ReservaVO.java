/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capamodelo;

import java.beans.*;
import java.io.Serializable;
import java.rmi.Remote;

/**
 *
 * @author Mela
 */
public class ReservaVO implements Remote, Serializable {
    
   private int cod_reserva;
   private int cod_cliente;
   private int cod_vuelo;
   private int numero_asiento;

    public ReservaVO() {
    }

    public ReservaVO(int cod_reserva, int cod_cliente, int cod_vuelo, int numero_asiento) {
        this.cod_reserva = cod_reserva;
        this.cod_cliente = cod_cliente;
        this.cod_vuelo = cod_vuelo;
        this.numero_asiento = numero_asiento;
    }

    public int getCod_reserva() {
        return cod_reserva;
    }

    public void setCod_reserva(int cod_reserva) {
        this.cod_reserva = cod_reserva;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getCod_vuelo() {
        return cod_vuelo;
    }

    public void setCod_vuelo(int cod_vuelo) {
        this.cod_vuelo = cod_vuelo;
    }

    public int getNumero_asiento() {
        return numero_asiento;
    }

    public void setNumero_asiento(int numero_asiento) {
        this.numero_asiento = numero_asiento;
    }
   
}
