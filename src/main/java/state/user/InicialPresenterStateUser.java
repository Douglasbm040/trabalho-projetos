/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.user;

import presenter.strategy.user.ExibeUsuarioPresenterUser;
import presenter.strategy.user.IPresenterUser;
import presenter.strategy.user.NotificacaoPresenterUser;
import presenter.strategy.user.PrincipalPresenterUser;

/**
 *
 * @author isaac
 */
public class InicialPresenterStateUser extends PresenterStateUser {
    
    public InicialPresenterStateUser(IPresenterUser presenter) {
        super(presenter);
    }
    
    public void manterUsuarios(){
        presenter.setState(new ExibeUsuarioPresenterStateUser(new ExibeUsuarioPresenterUser()));
    }
    
    public void verNotificacoes(){
        presenter.setState(new NotificacaoPresenterStateUser(new NotificacaoPresenterUser()));
    }
    
    public void fechar(){
        presenter.setState(new InicialPresenterStateUser(PrincipalPresenterUser.getInstance()));
    }
}
