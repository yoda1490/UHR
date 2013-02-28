/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UHR;

import java.util.ArrayList;

/**
 *
 * @author WaWa-YoDa
 */
public class Account {
    public boolean enable;
    public String URL;
    public String login;
    public String password;
    public String other;
    public String lastCo = "";
    
    
    public Account(boolean enable, String URL, String login, String password, String other){
        this.enable = enable;
        this.URL = URL;
        this.login = login;
        this.password = password;
        this.other = other;
    }
    
    public Account(String[] account){
        this.enable = false;
        if(Integer.parseInt(account[0]) ==  1)
            this.enable = true;
        this.URL = account[1];
        this.login = account[2];
        this.password = account[3];
        this.other = account[4];
    }
    
    public String toString(){
        String enableStr= "0";
        if(this.enable){
            enableStr= "1";
        }
        if(URL.isEmpty())
            URL = " ";
        if(login.isEmpty()){
            login = " ";
        }
        if(password.isEmpty()){
            password = " ";
        }
        if(other.isEmpty()){
            other = "";
        }
        return enableStr+";"+URL+";"+login+";"+password+";"+other;
    }
}
