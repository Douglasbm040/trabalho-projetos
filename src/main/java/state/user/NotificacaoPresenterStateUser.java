/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.user;

import model.User;
import presenter.strategy.user.ExibeNotificacaoPresenterUser;
import presenter.strategy.user.IPresenterUser;

/**
 *
 * @author isaac
 */
public class NotificacaoPresenterStateUser extends PresenterStateUser {
    
    public NotificacaoPresenterStateUser (IPresenterUser presenter, User user){
        super(presenter, user);
        principalPresenter.getInstance(this.user).getViewPrin().getDkstpPrincipal().add(presenter.getView(),0);
        presenter.getView().setVisible(true);
    }
    
    
    public void exibeNotificacao(){
        principalPresenter.getInstance(user).setState(new ExibeNotificacaoPresenterStateUser(new ExibeNotificacaoPresenterUser(user), user));
    }
    
    
    public void fechar(){
        principalPresenter.getInstance(user).setState(new InicialPresenterStateUser(principalPresenter.getInstance(user), user));
        presenter.getView().dispose();
    }
}
