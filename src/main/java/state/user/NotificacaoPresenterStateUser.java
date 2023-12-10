/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.user;

import presenter.strategy.user.ExibeNotificacaoPresenterUser;
import presenter.strategy.user.ExibeUsuarioPresenterUser;
import presenter.strategy.user.IPresenterUser;
import presenter.strategy.user.PrincipalPresenterUser;
import view.user.NotificacoesViewUser;

/**
 *
 * @author isaac
 */
public class NotificacaoPresenterStateUser extends PresenterStateUser {
    
    public NotificacaoPresenterStateUser (IPresenterUser presenter){
        super(presenter);
        principalPresenter.getInstance().getViewPrin().getDkstpPrincipal().add(presenter.getView(),0);
        presenter.getView().setVisible(true);
    }
    
    public void exibeNotificacao(){
        principalPresenter.getInstance().setState(new ExibeNotificacaoPresenterStateUser(new ExibeNotificacaoPresenterUser()));
    }
    
    public void fechar(){
        principalPresenter.getInstance().setState(new InicialPresenterStateUser(principalPresenter.getInstance()));
        presenter.getView().dispose();
    }
}
