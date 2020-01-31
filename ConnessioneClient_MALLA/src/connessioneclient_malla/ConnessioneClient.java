/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connessioneclient_malla;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malla 5BINF
 */
public class ConnessioneClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Socket connessione;
        String server = "localhost";
        int porta = 3500;
        try {
            connessione = new Socket(server, porta);
            System.out.println("connessione aperta");
            connessione.close();
            System.out.println("connessione chiusa");
        } catch (IOException ex) {
            Logger.getLogger(ConnessioneClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}