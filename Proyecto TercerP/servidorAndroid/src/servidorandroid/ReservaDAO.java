/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorandroid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * 
 * @author Oscar Fierro <omfierro@espe.edu.ec>
 */
public class ReservaDAO {
    
    public ReservaDAO(){
    
    }
    
    Conexion conex=new Conexion();
    PreparedStatement psr;
    Connection con = null;
    
    public void InsertarReserva(ReservaVO reserva) {
        //Primero creamos la conexion     
       try {
           con = conex.obtener();
           psr = con.prepareStatement("INSERT INTO reserva (cod_reserva,numero_asiento,cod_vuelo,cod_cliente) VALUES( ?,?,?,?);");
           psr.setInt(1, 11111);
           psr.setInt(2, reserva.getNumero_asiento());
           psr.setInt(3, reserva.getCod_vuelo());
           psr.setInt(4, reserva.getCod_cliente());
           JOptionPane.showMessageDialog(null, "Se ha registrado la reserva");
           psr.executeUpdate();
           con.close();
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
           
       } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
   }

}
