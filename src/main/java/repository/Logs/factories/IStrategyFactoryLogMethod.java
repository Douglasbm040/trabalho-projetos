/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.Logs.factories;

import repository.Logs.Adapter.ILogMethod;

/**
 *
 * @author dougl
 */
public interface IStrategyFactoryLogMethod {
   public ILogMethod create();
}
