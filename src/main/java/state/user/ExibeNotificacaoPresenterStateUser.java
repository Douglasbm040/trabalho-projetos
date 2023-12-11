
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.user;

import presenter.strategy.user.IPresenterUser;
import presenter.strategy.user.NotificacaoPresenterUser;

/**
 *
 * @author isaac
 */
public class ExibeNotificacaoPresenterStateUser extends PresenterStateUser {

    public ExibeNotificacaoPresenterStateUser(IPresenterUser presenter) {
        super(presenter);
        principalPresenter.getInstance().getViewPrin().getDkstpPrincipal().add(presenter.getView(),0);
        presenter.getView().setVisible(true);
    }
    
    @Override
    public void fechar(){
        presenter.setState(new NotificacaoPresenterStateUser(NotificacaoPresenterUser.getInstance()));
        presenter.getView().dispose();
    }
}
