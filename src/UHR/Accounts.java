/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UHR;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WaWa-YoDa
 */
public class Accounts {
    public boolean started = false;
    public int timeout = 5;
    private ArrayList<Account> database = new ArrayList<Account>();
    private String fileStr = "";
    public Accounts(String fileStr) {
        this.fileStr = fileStr;
        
        
        BufferedReader buff = null;
        try {
            buff = new BufferedReader(new FileReader(fileStr));

            String line;
// Lecture du fichier ligne par ligne. Cette boucle se termine
// quand la méthode retourne la valeur null.
            while ((line = buff.readLine()) != null) {
                database.add(new Account(line.split(";")));
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Erreur: " + ex);
            System.out.println("Creation de la BDD");
            File file = new File(fileStr);
            try {
                file.createNewFile();
            } catch (IOException ex1) {
                System.err.println("Erreur: " + ex);
            }
        } catch (IOException ex) {
            System.err.println("Erreur: " + ex);
        }finally {
            try {
                // dans tous les cas, on ferme nos flux
                            buff.close();
            } catch (Exception ex) {
                System.err.println("Erreur: " + ex);
            }
        }
        //just be sur we have at least 3 entries in the database
        this.refullDatabase(3);
    }
    
    public ArrayList<Account> getAccounts(){
        return database;
    }
    
    public Account get(int n){
        return database.get(n);
    }
    
    public void add(Account a){
        database.add(a);
    }
    
    public int size(){
        return database.size();
    }
    
    public void save(){
        FileOutputStream out;
        try {
            out = new FileOutputStream(fileStr, false);
            for(Account account : database){
                System.out.println(account.toString());
                out.write(account.toString().getBytes());
                out.write('\n');
            }
            out.close( );
        } catch (FileNotFoundException ex) {
                System.err.println("Erreur: "+ex);
        } catch (IOException ex) {
                System.err.println("Erreur: "+ex);
            }
        
    }
    
    public void refullDatabase(int n){
        while(database.size() < n){
            
            database.add(new Account(false, " ", " ", " ", " "));
            
        }
        
        
    }
}

