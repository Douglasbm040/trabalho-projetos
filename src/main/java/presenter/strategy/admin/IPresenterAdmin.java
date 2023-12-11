/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.admin;

import state.admin.PresenterStateAdmin;

/**
 *
 * @author isaac
 */
public abstract class IPresenterAdmin {
    public abstract void setState(PresenterStateAdmin state);
    public abstract void configuraTela();
    public javax.swing.JInternalFrame getView(){
          throw new RuntimeException("deve possuir JInternalFrame");
    }
}
