/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UHR;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WaWa-YoDa
 */
public class Daemon extends Thread {

    private Accounts database;
    private GUI gui;

    public Daemon(Accounts database, GUI gui) {
        this.database = database;
        this.gui = gui;
    }

    public void run() {
        System.out.println("Daemon Started");
        while (true) {
            if (database.started) {
                for(Account acc :database.getAccounts()){
                    //Reconnector.Connect("https://10.11.0.1/login.html", "st114980", "cBu2%pQk", "buttonClicked=4&err_flag=0&err_msg&info_flag=0&info_msg&redirect_url=http%3A%2F%2Fgoogle.fr%2F");
                    if(acc.enable)
                        Reconnector.Connect(acc);
                }
               
                try {
                    Thread.currentThread().sleep(database.timeout*1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Daemon.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    Thread.currentThread().sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Daemon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
