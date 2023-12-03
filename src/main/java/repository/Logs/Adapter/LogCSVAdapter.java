/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.Logs.Adapter;

/**
 * @author dougl
 */
public class LogCSVAdapter implements ILogMethod {
    private final LogCSV log;

    public LogCSVAdapter() {
        this.log = new LogCSV();
    }

    @Override
    public void saveLog(String message) {
        log.save(message);
    }

    @Override
    public String getRegisterLog() {
        return log.get();
    }

}
