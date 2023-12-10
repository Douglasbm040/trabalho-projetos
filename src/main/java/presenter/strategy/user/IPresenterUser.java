/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presenter.strategy.user;

import java.awt.Container;
import java.awt.Frame;
import state.user.PresenterStateUser;

/**
 *
 * @author isaac
 */
public abstract class IPresenterUser {
    public abstract void setState(PresenterStateUser state);
    public abstract void configuraTela();
    public javax.swing.JInternalFrame getView(){
          throw new RuntimeException("deve possuir JInternalFrame");
    }
}