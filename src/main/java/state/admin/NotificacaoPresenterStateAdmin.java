/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.admin;

import model.User;
import presenter.strategy.admin.CriarNotificacaoPresenterAdmin;
import presenter.strategy.admin.ExibeNotificacaoPresenterAdmin;
import presenter.strategy.admin.IPresenterAdmin;

/**
 *
 * @author isaac
 */
public class NotificacaoPresenterStateAdmin extends PresenterStateAdmin {
    public NotificacaoPresenterStateAdmin (IPresenterAdmin presenter, User user){
        super(presenter, user);
        principalPresenter.getInstance(user).getViewPrin().getDkstpPrincipal().add(presenter.getView(), 0);
        presenter.getView().setVisible(true);
    }
    
    @Override
    public void criarNovaNotificacao(){
        principalPresenter.getInstance(user).setState(new CriarNotificacaoPresenterStateAdmin(new CriarNotificacaoPresenterAdmin(user), user));
    }
    
    @Override
    public void verDetalhesNotificacao(){
        principalPresenter.getInstance(user).setState(new ExibeNotificacaoPresenterStateAdmin(new ExibeNotificacaoPresenterAdmin(user), user));
    }
    
    @Override
    public void fechar(){
        principalPresenter.getInstance(user).setState(new InicialPresenterStateAdmin(principalPresenter.getInstance(user), user));
        presenter.getView().dispose();
    }
}
