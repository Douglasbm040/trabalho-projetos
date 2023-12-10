/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.Logs.Adapter;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dougl
 */
class LogJSON {
    public void save (String message){

    }

    public String get () {
        return "";
    }

    public LogJSON() {
    if(!new File("log").exists()) {
            new File("log").mkdir();
        }
        File arq = new File("log/log.json");
        if(!arq.exists()) {
            try {
                arq.createNewFile();
            } catch (IOException ex) {
               // Logger.getLogger(LogTxt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
