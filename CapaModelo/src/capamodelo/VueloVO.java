package capamodelo;

import java.beans.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Mela
 */
public class VueloVO implements Serializable {
    private int cod_vuelo;
    private int cod_avion;
    private String origen;
    private Date fecha_salida;
    private Date fecha_llegada;
    private String destino;
    private float precio;

    public VueloVO() {
    }
    
    public VueloVO(int cod_vuelo, int cod_avion, String origen, Date fecha_salida, Date fecha_llegada, String destino, float precio) {
        this.cod_vuelo = cod_vuelo;
        this.cod_avion = cod_avion;
        this.origen = origen;
        this.fecha_salida = fecha_salida;
        this.fecha_llegada = fecha_llegada;
        this.destino = destino;
        this.precio = precio;
    }

    public int getCod_vuelo() {
        return cod_vuelo;
    }

    public void setCod_vuelo(int cod_vuelo) {
        this.cod_vuelo = cod_vuelo;
    }

    public int getCod_avion() {
        return cod_avion;
    }

    public void setCod_avion(int cod_avion) {
        this.cod_avion = cod_avion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Date getFecha_llegada() {
        return fecha_llegada;
    }

    public void setFecha_llegada(Date fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
   
}
