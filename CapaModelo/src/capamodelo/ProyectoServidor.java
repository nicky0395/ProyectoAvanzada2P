/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capamodelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NicoleJeem
 */
public class ProyectoServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReservaDAO r = new ReservaDAO();
        List<ReservaVO> li = r.obtenerReservas();
}
}
