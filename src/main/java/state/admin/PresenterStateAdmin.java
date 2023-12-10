/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.admin;

import presenter.strategy.admin.IPresenterAdmin;
import state.user.*;
import presenter.strategy.admin.PrincipalPresenterAdmin;
import presenter.strategy.user.IPresenterUser;
import presenter.strategy.user.PrincipalPresenterUser;

/**
 *
 * @author isaac
 */
public abstract class PresenterStateAdmin {
    protected IPresenterAdmin presenter;
    protected PrincipalPresenterAdmin principalPresenter;
    
    public PresenterStateAdmin (IPresenterAdmin presenter){
        this.presenter = presenter;
    }
    
    public void manterUsuarios(){
        throw new RuntimeException("Não é possível ver os usuários");
    }
    
    public void exibirUsuario(){
        throw new RuntimeException("Não é possível exibir os usuários");
    }
    
    public void verNotificacoes(){
        throw new RuntimeException("Não é possível ver notificacoes");
    }
    
    public void verDetalhesNotificacao(){
        throw new RuntimeException("Não é possível ver detalhes das notificacoes");
    }
    
    public void criarNotificacao(){
        throw new RuntimeException("Não é possível criar notificacoes");
    }
    
    public void fechar(){
        throw new RuntimeException("Não é possível fechar a tela");
    }
    
}
