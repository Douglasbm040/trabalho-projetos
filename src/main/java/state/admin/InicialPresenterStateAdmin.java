/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.admin;

import presenter.strategy.admin.GerenciarUsuariosPresenterAdmin;
import state.user.*;
import presenter.strategy.user.ExibeUsuarioPresenterUser;
import presenter.strategy.admin.IPresenterAdmin;
import presenter.strategy.user.IPresenterUser;
import presenter.strategy.user.NotificacaoPresenterUser;
import presenter.strategy.user.PrincipalPresenterUser;

/**
 *
 * @author isaac
 */
public class InicialPresenterStateAdmin extends PresenterStateAdmin {
    
    public InicialPresenterStateAdmin(IPresenterAdmin presenter) {
        super(presenter);
    }
    
    public void manterUsuarios(){
        presenter.setState(new GerenciarUsuariosPresenterStateAdmin(new GerenciarUsuariosPresenterAdmin()));
    }
    
    public void verNotificacoes(){
       // presenter.setState(new NotificacaoPresenterStateAdmin(new NotificacaoPresenterAdmin()));
    }
    
    public void fechar(){
       // presenter.setState(new InicialPresenterStateAdmin(PrincipalPresenterUser.getInstance()));
    }
}
