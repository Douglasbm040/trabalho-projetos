/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.observer;

import model.User;
import presenter.strategy.user.ExibeUsuarioPresenterUser;
import presenter.strategy.user.PrincipalPresenterUser;

/**
 *
 * @author dougl
 */
public class UserObservable extends Observable<User> {
    private static UserObservable instance;
    
    public UserObservable() {
        super();
    }
    
    public static UserObservable getInstance(){
        if(instance == null){
            instance = new UserObservable();
        }
        
        return instance;
    }
}
