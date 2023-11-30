/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.observer;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author dougl
 */
public abstract class Observable {
    private List<IObserver> observers = new ArrayList();
    
    public void addObserver(IObserver observer){
        observers.add(observer);
    }
    public void deleteObserver(IObserver observer){
          observers.remove(observer);
    }
    
    public void notifyObserver(){
        for (IObserver observer: observers ){
            observer.upadate();   
        }
    }
}
