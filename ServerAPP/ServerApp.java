package serverapp;

import java.io.*;
import java.net.*;
/**
 *
 * @author giacomo
 */
public class ServerApp {

    public static void main(String[] args) throws IOException{
        String fraseClient;
        String fraseMaiuscola;
        boolean arresto;
        
        ServerSocket welcomeSocket = new ServerSocket(6020);
        arresto = true;
        while(arresto){
            Socket socketConnessione = welcomeSocket.accept();
            
            BufferedReader inFromClient =
                    new BufferedReader(new InputStreamReader(
                           socketConnessione.getInputStream()));
            
            DataOutputStream outToClient = 
                    new DataOutputStream(
                            socketConnessione.getOutputStream());
            
            fraseClient = inFromClient.readLine();
            fraseMaiuscola = fraseClient.toUpperCase() + '\n';
            
            outToClient.writeBytes(fraseMaiuscola);
           
            if (fraseClient.equals("Arrivederci")){
                arresto = false;
                socketConnessione.close();
            }
        }
    }
    
}
