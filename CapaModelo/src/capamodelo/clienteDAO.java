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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Oscar Fierro <omfierro@espe.edu.ec>
 */
public class clienteDAO {

    private final Conexion coneccionBD = new Conexion();
    private Connection con;
    private PreparedStatement psInsertar;

    public clienteDAO() {
    }

    public String recuperarNombre(int codigo) {
        String nombre = "";
        String apellido = "";
        try {
            con = coneccionBD.obtener();
            java.sql.Statement ejecutor = con.createStatement();
            ResultSet resultado = ejecutor.executeQuery("SELECT NOMBRE_CLIENTE, APELLIDO_CLIENTE FROM cliente WHERE COD_CLIENTE = '" + codigo + "'");;
            nombre = resultado.getString(4);
            apellido = resultado.getString(5);
        } catch (Exception ex) {
            Logger.getLogger(clienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (nombre + " " + apellido);
    }

    public void registrarCliente(clienteVO nuevo) {
        try {

            con = coneccionBD.obtener();
            psInsertar = con.prepareStatement("INSERT INTO cliente (cod_cliente, cedula_cliente, nacionalidad_cliente, nombre_cliente, apellido_cliente, fecha_nac)" + " values(?,?,?,?,?,?)");
            psInsertar.setInt(1, nuevo.getCodigo());
            psInsertar.setString(2, nuevo.getCedula());
            psInsertar.setString(3, nuevo.getNacionalidad());
            psInsertar.setString(4, nuevo.getNombre());
            psInsertar.setString(5, nuevo.getApellido());
            psInsertar.setDate(6, nuevo.getFechaN());
            psInsertar.execute();
            System.out.println("Registrando Cliente");
            coneccionBD.cerrar();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }

    public int obtenerCodigoCliente(String cedula) {
        int codigo = 0;
        try {
            con = coneccionBD.obtener();
            Statement ejecutor = con.createStatement();
            ResultSet resultado = ejecutor.executeQuery("SELECT cod_cliente FROM cliente WHERE cedula_cliente = '" + cedula + "'");;
            while (resultado.next()) {
                codigo = resultado.getInt(1);
            }
            coneccionBD.cerrar();
        } catch (Exception ex) {
            Logger.getLogger(clienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;

    }

    public int obtenerUltimoCodigo() {
        int codigo = 0;
        try {
            con = coneccionBD.obtener();
            Statement ejecutor = con.createStatement();
            ResultSet resultado = ejecutor.executeQuery("SELECT MAX(cod_cliente) FROM cliente");

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
