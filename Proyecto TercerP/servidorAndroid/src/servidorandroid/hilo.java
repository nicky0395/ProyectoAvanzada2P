/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorandroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static servidorandroid.MainServer.process;

/**
 *
 * @author Oscar Fierro <omfierro@espe.edu.ec>
 */
public class hilo extends Thread {

    private Socket clientSocket;
    private BufferedReader input;
    private PrintStream output;

    public hilo(Socket cli) {
        this.clientSocket = cli;
    }

    @Override
    public void run() {
        try {
            //Para leer lo que envie el cliente
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            //para imprimir datos de salida
            output = new PrintStream(clientSocket.getOutputStream());
            //se lee peticion del cliente
            String request = input.readLine();

            System.out.println("Cliente> petición Asiento N° ["+ request + "]");
            //se procesa la peticion y se espera resultado
            String strOutput = "Registrado con exito";
            //Se imprime en consola "servidor"
            System.out.println("Servidor> Resultado de petición");
            System.out.println("Servidor> \"" + strOutput + "\"");
            //se imprime en cliente
            output.flush();//vacia contenido
            output.println(strOutput);

            //comunicación con la base de datos 
            ReservaDAO resDAO = new ReservaDAO();
            int num = 5;
            ReservaVO nuevaReserva = new ReservaVO(num, 1111111111, 1, 9);
            resDAO.InsertarReserva(nuevaReserva);

            //cierra conexion
            clientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
