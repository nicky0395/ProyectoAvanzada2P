/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capamodelo;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Mela
 */
public class AvionVO implements Serializable {
    
    private int codAvion;
    private String modelo;
    private String aerolinea;

    public AvionVO(int codAvion, String modelo, String aerolinea) {
        this.codAvion = codAvion;
        this.modelo = modelo;
        this.aerolinea = aerolinea;
    }

    public AvionVO() {
    }

    public int getCodAvion() {
        return codAvion;
    }

    public void setCodAvion(int codAvion) {
        this.codAvion = codAvion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }
    
    
}
