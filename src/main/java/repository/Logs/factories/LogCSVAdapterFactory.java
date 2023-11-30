/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.Logs.factories;

import repository.Logs.Adapter.ILogMethod;
import repository.Logs.Adapter.LogCSVAdapter;

/**
 *
 * @author dougl
 */
public class LogCSVAdapterFactory implements IStrategyFactoryLogMethod{

    @Override
    public ILogMethod create() {
        return new LogCSVAdapter();
    }
    
}
