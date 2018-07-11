/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capamodelo;

import java.beans.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mela
 */
public class VueloDAO {

    private final Conexion coneccionBD = new Conexion();
    private Connection con ;
    private PreparedStatement psInsertar;

    public VueloDAO() {
    }

    public List<VueloVO> obtenerVuelos() {
        VueloVO vuelo;
        List<VueloVO> vuelos = new ArrayList<VueloVO>();
        try {
            con = coneccionBD.obtener();
            java.sql.Statement ejecutor = con.createStatement();
            ResultSet resultado = ejecutor.executeQuery("SELECT * FROM vuelo");

            while (resultado.next()) {
                vuelo = new VueloVO(resultado.getInt(1), resultado.getInt(2), resultado.getString(6), resultado.getDate(3), resultado.getDate(4), resultado.getString(7), resultado.getFloat(5));
                vuelos.add(vuelo);
                System.out.println("obteniendo vuelos");
            }
            coneccionBD.cerrar();
        } catch (Exception ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vuelos;
    }

    public int obtenerCodigoVuelos(String string) {
        String[] parts = string.split("-");
        String origen = String.valueOf(parts[0]); // 123
        String destino = String.valueOf(parts[1]); // 654321

        System.out.println("Cadenas DIVIDIDAS");
        System.out.println("origen: " + origen);
        System.out.println("destino: " + destino);
        int codigo = 0;
        try {
            con = coneccionBD.obtener();
            java.sql.Statement ejecutor = con.createStatement();
            ResultSet resultado = ejecutor.executeQuery("SELECT cod_vuelo FROM vuelo WHERE origen LIKE '" + origen + "'");

            while (resultado.next()) {
                codigo = resultado.getInt(1);
                System.out.println("Codigo: " + codigo);
            }

            coneccionBD.cerrar();
        } catch (Exception ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }

    public int CodigoVuelo(int codigoAvion) {
        int codigo = 0;
        try {
            con = coneccionBD.obtener();
            java.sql.Statement ejecutor = con.createStatement();
            ResultSet resultado = ejecutor.executeQuery("SELECT cod_vuelo FROM vuelo WHERE cod_avion ='" + codigoAvion + "' ");

            while (resultado.next()) {
                codigo = resultado.getInt(1);
            }
            System.out.println("Imprimiendo codigo vuelo: " + codigo);
            coneccionBD.cerrar();
        } catch (Exception ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }
}
