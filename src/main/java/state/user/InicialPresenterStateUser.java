/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.user;

import model.User;
import presenter.strategy.user.ExibeUsuarioPresenterUser;
import presenter.strategy.user.IPresenterUser;
import presenter.strategy.user.NotificacaoPresenterUser;
import presenter.strategy.user.PrincipalPresenterUser;

/**
 *
 * @author isaac
 */
public class InicialPresenterStateUser extends PresenterStateUser {
    
    public InicialPresenterStateUser(IPresenterUser presenter, User user) {
        super(presenter, user);
    }
    
    public void manterUsuarios(){
        presenter.setState(new ExibeUsuarioPresenterStateUser(new ExibeUsuarioPresenterUser(user), user));
    }
    
    public void verNotificacoes(){
        presenter.setState(new NotificacaoPresenterStateUser(NotificacaoPresenterUser.getInstance(user), user));
    }
    
    public void fechar(){
        presenter.setState(new InicialPresenterStateUser(PrincipalPresenterUser.getInstance(user), user));
    }
}
