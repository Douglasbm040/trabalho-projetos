/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.user;

import model.Notification;
import model.User;
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
    protected User user;
    
    public PresenterStateUser (IPresenterUser presenter, User user){
        this.presenter = presenter;
        this.user = user;
    }
    
    public void manterUsuarios(){
        throw new RuntimeException("Não é possível ver os usuários");
    }
    
    public void verNotificacoes(){
        throw new RuntimeException("Não é possível ver notificacoes");
    }
    
    public void exibeNotificacao(Notification notification){
        throw new RuntimeException("Não é possível ver a notificacao");
    }
    
    public void fechar(){
        throw new RuntimeException("Não é possível fechar a tela");
    }
    
}
