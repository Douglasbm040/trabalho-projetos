/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.user;

import model.Notification;
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
    
    @Override
    public void exibeNotificacao(Notification notification){
        principalPresenter.getInstance(user).setState(new ExibeNotificacaoPresenterStateUser(new ExibeNotificacaoPresenterUser(user,notification), user));
    }
    
    @Override
    public void fechar(){
        principalPresenter.getInstance(user).setState(new InicialPresenterStateUser(principalPresenter.getInstance(user), user));
        presenter.getView().dispose();
    }
}
