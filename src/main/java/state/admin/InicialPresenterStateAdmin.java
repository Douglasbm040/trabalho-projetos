/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.admin;

import model.Notification;
import model.User;
import presenter.strategy.admin.GerenciarUsuariosPresenterAdmin;
import presenter.strategy.admin.IPresenterAdmin;
import presenter.strategy.admin.NotificacaoPresenterAdmin;
import presenter.strategy.admin.PrincipalPresenterAdmin;

/**
 *
 * @author isaac
 */
public class InicialPresenterStateAdmin extends PresenterStateAdmin {
    
    public InicialPresenterStateAdmin(IPresenterAdmin presenter, User user) {
        super(presenter, user);
    }
    
    @Override
    public void manterUsuarios(){
        presenter.setState(new GerenciarUsuariosPresenterStateAdmin(GerenciarUsuariosPresenterAdmin.getInstance(user), user));
    }
    
    @Override
    public void verNotificacoes(){
        presenter.setState(new NotificacaoPresenterStateAdmin(NotificacaoPresenterAdmin.getInstance(user), user));
    }
    
    @Override
    public void fechar(){
        presenter.setState(new InicialPresenterStateAdmin(PrincipalPresenterAdmin.getInstance(user), user));
    }
}
