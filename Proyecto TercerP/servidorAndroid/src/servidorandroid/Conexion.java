/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorandroid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Oscar Fierro <omfierro@espe.edu.ec>
 */
public class Conexion {
    private static String url = "jdbc:mysql://localhost:3350/baseaviones?useSSL=false", login = "root", clave = "Osk4r1995";
    private static Connection coneccion;

    public Connection obtener() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (coneccion == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                coneccion = (Connection) DriverManager.getConnection(url, login, clave);
                System.out.println("se conectó a la base de datos ");
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("error");
            }
        }
        return coneccion;
    }

    public void cerrar() throws SQLException {
        if (coneccion != null) {
            coneccion.close();
            coneccion = null;
            System.out.println("Se cerró la base de datos");
        }
    }

}
