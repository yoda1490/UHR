/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UHR;

/**
 *
 * @author WaWa-YoDa
 */
public class WiFiReconnector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean started = false;
        
        System.out.println("Starting ...");
        
        Accounts database = new Accounts("database.da");
        GUI gui = new GUI(database);
        
        Daemon daemon = new Daemon(database, gui);
        daemon.start();
        
        System.out.println("Launching GUI");
        
        
        gui.setVisible(true);
        
        
        
        
    }
}
