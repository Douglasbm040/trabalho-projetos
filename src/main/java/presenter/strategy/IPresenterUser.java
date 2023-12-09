/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presenter.strategy;

import state.PresenterState;

/**
 *
 * @author isaac
 */
public interface IPresenterUser {
    void setState(PresenterState state);
    void configuraTela();
    
    
}
