/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state;

import presenter.strategy.PrincipalPresenterAdmin;
import presenter.strategy.IPresenterUser;
import presenter.strategy.PrincipalPresenterUser;

/**
 *
 * @author isaac
 */
public abstract class PresenterState {
    protected IPresenterUser presenter;
    protected PrincipalPresenterUser principalPresenter;
    
    public PresenterState (IPresenterUser presenter){
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
