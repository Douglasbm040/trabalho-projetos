
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.user;

import model.User;
import presenter.strategy.user.IPresenterUser;
import presenter.strategy.user.NotificacaoPresenterUser;

/**
 *
 * @author isaac
 */
public class ExibeNotificacaoPresenterStateUser extends PresenterStateUser {

    public ExibeNotificacaoPresenterStateUser(IPresenterUser presenter, User user) {
        super(presenter, user);
        principalPresenter.getInstance(this.user).getViewPrin().getDkstpPrincipal().add(presenter.getView(),0);
        presenter.getView().setVisible(true);
    }
    
    @Override
    public void fechar(){
        principalPresenter.getInstance(user).setState(new NotificacaoPresenterStateUser(NotificacaoPresenterUser.getInstance(user), user));
        presenter.getView().dispose();
    }
}
