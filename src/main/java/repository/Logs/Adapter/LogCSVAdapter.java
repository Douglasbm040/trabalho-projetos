/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.Logs.Adapter;

import repository.Logs.Adapted.LogCSV;

/**
 *
 * @author dougl
 */
public class LogCSVAdapter implements ILogMethod {
    private final LogCSV log;

    public LogCSVAdapter() {
        this.log = new LogCSV();
    }

    @Override
    public void saveLog(String log) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void getRegisterLog() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
