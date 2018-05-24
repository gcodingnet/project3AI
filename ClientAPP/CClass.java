package clientapp;

import java.io.*;
import java.net.*;

/**
 *
 * @author GF
 */

/**
     * La classe gestisce un client socket per connettersi
     * ad un servizio in ascolto su una determinata porta
     * e su una macchina che svolge il ruolo di server
*/
public class CClass {

    /**
     * variabili per tenere tracccia dell'IP e della porta
     * del servizio in ascolto
     */
    private String hostIP;
    private int portNumber;
    
    /**
     * @param IP    indirizzo IP del server
     * @param Port  porta di ascolto del server 
     */
    public CClass(String IP, int Port){
        hostIP = IP;
        portNumber = Port;
        
    }
    
    /** 
     * @return  Restituisce una stringa contenente
     *          l'indirizzo IP del server
     */
    public String gethIP(){
        return hostIP;
    }
    
    /**
     * 
     * @return  Restituisce un intero
     *          contenente la porta di ascolto del server 
     */
    public int getPortN(){
        return portNumber;
    }
    
    /**
     * 
     * @param hname indirizzo IP del server da contattare
     * @param pname porta di ascolto
     * @return      Restituisce un oggetto di tipo Socket
     *              contenente il canale di comunicazione tra Client e Server
     */
    public Socket getConnection(String hname, int pname){
        Socket csocket = null;
        try{
            csocket = new Socket(hname,pname);
        }
        
        //Il metodo può generare eccezioni di tipo IO e UnknownHost
        catch(UnknownHostException e){
            csocket = null;
        }
        catch(IOException eIO){
            csocket = null;
        }
        
        return csocket;
    }
}
