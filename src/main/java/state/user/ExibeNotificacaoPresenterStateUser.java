
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.user;

import presenter.strategy.user.ExibeNotificacaoPresenterUser;
import presenter.strategy.user.ExibeUsuarioPresenterUser;
import presenter.strategy.user.IPresenterUser;
import presenter.strategy.user.NotificacaoPresenterUser;
import presenter.strategy.user.PrincipalPresenterUser;

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
        System.out.println("Passou aq");    
        presenter.setState(new NotificacaoPresenterStateUser(NotificacaoPresenterUser.getInstance()));
        System.out.println("Passou aq 2");
        presenter.getView().dispose();
    }
}
