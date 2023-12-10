/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.user;

import presenter.strategy.admin.PrincipalPresenterAdmin;
import presenter.strategy.user.IPresenterUser;
import presenter.strategy.user.PrincipalPresenterUser;

/**
 *
 * @author isaac
 */
public abstract class PresenterStateUser {
    protected IPresenterUser presenter;
    protected PrincipalPresenterUser principalPresenter;
    
    public PresenterStateUser (IPresenterUser presenter){
        this.presenter = presenter;
    }
    
    public void manterUsuarios(){
        throw new RuntimeException("Não é possível ver os usuários");
    }
    
    public void verNotificacoes(){
        throw new RuntimeException("Não é possível ver notificacoes");
    }
    
    public void fechar(){
        throw new RuntimeException("Não é possível fechar a tela");
    }
    
}
