/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.admin;

import state.user.*;
import presenter.strategy.user.ExibeUsuarioPresenterUser;
import presenter.strategy.admin.IPresenterAdmin;
import presenter.strategy.admin.PrincipalPresenterAdmin;
import presenter.strategy.user.PrincipalPresenterUser;

/**
 *
 * @author isaac
 */
public class NotificacaoPresenterStateAdmin extends PresenterStateAdmin {
    public NotificacaoPresenterStateAdmin (IPresenterAdmin<ExibeUsuarioPresenterUser> presenter){
        super(presenter);
        
    }
    
    @Override
    public void fechar(){
        presenter.setState(new InicialPresenterStateAdmin(PrincipalPresenterAdmin.getInstance()));
    }
}
