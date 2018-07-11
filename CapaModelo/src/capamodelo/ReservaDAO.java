/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capamodelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mela
 */
public class ReservaDAO {

    private final Conexion coneccionBD = new Conexion();
    private Connection con;
    private PreparedStatement psInsertar;

    public ReservaDAO() {
    }

    public void InsertarReserva(ReservaVO reserva) {
        //Primero creamos la conexion;
        try {
            System.out.println(reserva.getNumero_asiento());
            con = coneccionBD.obtener();
            psInsertar = con.prepareStatement("INSERT INTO reserva (cod_vuelo, cod_reserva,cod_cliente,numero_asiento)" + " values(?,?,?,?)");
            psInsertar.setInt(1, reserva.getCod_vuelo());
            psInsertar.setInt(2, reserva.getCod_reserva());
            psInsertar.setInt(3, reserva.getCod_cliente());
            psInsertar.setInt(4, reserva.getNumero_asiento());
            psInsertar.execute();
            System.out.println("Registrando reserva");
            coneccionBD.cerrar();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
     
        }
    }

    public List<Integer> obtenerAsientosOcupados(int cod) {
        List<Integer> asientosOcupados = new ArrayList<>();
        List<Integer> asientosLibres = new ArrayList<>();
        try {
            System.out.println("Entrando al try catch");
            con = coneccionBD.obtener();
            java.sql.Statement ejecutor = con.createStatement();
            ResultSet rs = ejecutor.executeQuery("SELECT numero_asiento FROM reserva WHERE cod_vuelo = '" + cod + "'");
            while (rs.next()) {
                asientosOcupados.add(rs.getInt(1));
            }
            for(int m=0; m<asientosOcupados.size(); m++){
                System.out.println("Asientos Ocupados: "+asientosOcupados.get(m));
            }
            for (int i = 0; i < 20; i++) {
                asientosLibres.add(i + 1);
            }
            for (int j = 0; j < asientosOcupados.size(); j++) {
                asientosLibres.remove(asientosOcupados.get(j));
                
            }
            for(int k=0; k<asientosLibres.size(); k++){
                System.out.println("Asientos Libres: "+asientosLibres.get(k));
            }

            coneccionBD.cerrar();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        } 
        return asientosLibres;
    }

    public List<ReservaVO> obtenerReservas() {
        ReservaVO reserva;
        List<ReservaVO> reservas = new ArrayList<ReservaVO>();
        try {
            con = coneccionBD.obtener();
            Statement ejecutor = con.createStatement();
            ResultSet resultado = ejecutor.executeQuery("SELECT * FROM reserva");

            while (resultado.next()) {
                reserva = new ReservaVO();
                reserva.setCod_cliente(resultado.getInt(4));
                reserva.setCod_reserva(resultado.getInt(1));
                reserva.setCod_vuelo(resultado.getInt(3));
                reserva.setNumero_asiento(resultado.getInt(2));
                reservas.add(reserva);
                System.out.println("obteniendo reserva");
            }
            coneccionBD.cerrar();
        } catch (Exception ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reservas;
    }

    public int obtenerUltimoCodigo() {
        int codigo = 0;
        try {
            con = coneccionBD.obtener();
            Statement ejecutor = con.createStatement();
            ResultSet resultado = ejecutor.executeQuery("SELECT MAX(cod_reserva) FROM reserva");

            while (resultado.next()) {
                codigo = resultado.getInt(1);
            }
            coneccionBD.cerrar();
        } catch (Exception ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }
}
