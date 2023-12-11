/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.admin;

import state.user.*;
import presenter.strategy.user.ExibeUsuarioPresenterUser;
import presenter.strategy.user.IPresenterUser;
import presenter.strategy.user.PrincipalPresenterUser;

/**
 *
 * @author isaac
 */
public class ExibeNotificacaoPresenterStateAdmin extends PresenterStateUser {
    public ExibeNotificacaoPresenterStateAdmin (IPresenterUser presenter){
        super(presenter);
        
    }
    
    @Override
    public void fechar(){
        principalPresenter.getInstance().setState(new InicialPresenterStateUser(principalPresenter.getInstance()));
    }
}