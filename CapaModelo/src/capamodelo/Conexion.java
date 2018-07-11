package capamodelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
public class Conexion {
    static String bd="baseaviones";
    static String login="root";
    static String password="JAZMELA0205";
    static String url="jdbc:mysql://localhost/"+bd;
   
    Connection conn=null;
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url, login, password);
            if(conn!=null){
                
                System.out.println("conexion ok");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }
    public Connection obtener(){
        return conn;
    }
    public void cerrar(){
        conn=null;
    }
}
