/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.user;

import presenter.strategy.user.ExibeUsuarioPresenterUser;
import presenter.strategy.user.IPresenterUser;
import presenter.strategy.user.PrincipalPresenterUser;

/**
 *
 * @author isaac
 */
public class NotificacaoPresenterStateUser extends PresenterStateUser {
    public NotificacaoPresenterStateUser (IPresenterUser presenter){
        super(presenter);
        
    }
    
    
    public void fechar(){
        presenter.setState(new InicialPresenterStateUser(PrincipalPresenterUser.getInstance()));
        presenter.getView().dispose();
    }
}