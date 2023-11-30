/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.Logs.Adapter;

import repository.Logs.Adapted.LogJSON;

/**
 *
 * @author dougl
 */
public class LogJSONAdapter implements ILogMethod{
    private final LogJSON log;

    public LogJSONAdapter() {
        this.log = new LogJSON();
    }

    @Override
    public void saveLog(String log) {
        throw new UnsupportedOperationException("Not supported yet.");     }

    @Override
    public void getRegisterLog() {
        throw new UnsupportedOperationException("Not supported yet.");    }
    

 
}
