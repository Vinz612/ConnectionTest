/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connessioneserver_malla;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malla 5BINF
 */
public class ConnessioneServer {

    public static void main(String[] args) {
        // TODO code application logic here

        ServerSocket sSocket = null;
        int porta = 3500;
        Socket connessione=null;
		int time=6;
		
		try {
			sSocket = new ServerSocket(porta);
		} catch (IOException ex) {
			Logger.getLogger(ConnessioneServer.class.getName()).log(Level.SEVERE, null, ex);
		}

        while (true) {
            try {
                sSocket.setSoTimeout(1000*time);
                System.out.println("in attesa di connessioni...");
				CountDown cd=new CountDown(time);
				Thread tcd = new Thread(cd);
				tcd.start();
                connessione = sSocket.accept();
				cd.setFlag();
                System.out.println("Connessione stabilita");
				System.out.println("Connessione chiusa");

            } catch (SocketTimeoutException ste) {
                System.err.println("Connessione scaduta");
            } catch (IOException ex) {
                System.out.println("errore");
            } finally {
                try {
					if(connessione != null){
						connessione.close();
						System.out.println("connessione chiusa");
					}
                } catch (IOException ex) {
                    Logger.getLogger(ConnessioneServer.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }
}