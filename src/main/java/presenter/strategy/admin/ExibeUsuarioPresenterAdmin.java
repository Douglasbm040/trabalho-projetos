/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.admin;

import state.admin.ExibeUsuarioPresenterStateAdmin;
import state.admin.PresenterStateAdmin;
import view.admin.ExibeUsuarioViewAdmin;

/**
 *
 * @author isaac
 */
public class ExibeUsuarioPresenterAdmin extends IPresenterAdmin {
    
    private ExibeUsuarioViewAdmin view;
    private PresenterStateAdmin state;
    
    public ExibeUsuarioPresenterAdmin() {
        view = new ExibeUsuarioViewAdmin();
        state = new ExibeUsuarioPresenterStateAdmin(this);
        
        configuraTela();
    }
    
    @Override
    public void setState(PresenterStateAdmin state) {
        this.state = state;
    }

    @Override
    public void configuraTela() {

    }
    
}
