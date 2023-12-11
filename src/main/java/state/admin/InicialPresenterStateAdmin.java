/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.admin;

import presenter.strategy.admin.GerenciarUsuariosPresenterAdmin;
import presenter.strategy.admin.IPresenterAdmin;
import presenter.strategy.admin.NotificacaoPresenterAdmin;

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
        presenter.setState(new NotificacaoPresenterStateAdmin(NotificacaoPresenterAdmin.getInstance()));
    }
    
    public void fechar(){
       // presenter.setState(new InicialPresenterStateAdmin(PrincipalPresenterUser.getInstance()));
    }
}
