/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.admin;

import model.User;
import presenter.strategy.admin.IPresenterAdmin;
import presenter.strategy.admin.NotificacaoPresenterAdmin;

/**
 *
 * @author isaac
 */
public class ExibeNotificacaoPresenterStateAdmin extends PresenterStateAdmin {
    public ExibeNotificacaoPresenterStateAdmin (IPresenterAdmin presenter, User user){
        super(presenter, user);
        principalPresenter.getInstance(this.user).getViewPrin().getDkstpPrincipal().add(presenter.getView(), 0);
        presenter.getView().setVisible(true);
    }
    
    @Override
    public void fechar(){
        
        principalPresenter.getInstance(user).setState(new NotificacaoPresenterStateAdmin(NotificacaoPresenterAdmin.getInstance(user), user));
        presenter.getView().dispose();
    }
}