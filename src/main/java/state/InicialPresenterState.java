/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state;

import presenter.strategy.ExibeUsuarioPresenterUser;
import presenter.strategy.IPresenterUser;
import presenter.strategy.NotificacaoPresenterUser;
import presenter.strategy.PrincipalPresenterUser;

/**
 *
 * @author isaac
 */
public class InicialPresenterState extends PresenterState {
    
    public InicialPresenterState(IPresenterUser presenter) {
        super(presenter);
    }
    
    public void manterUsuarios(){
       
        presenter.setState(new ExibeUsuarioPresenterState(new ExibeUsuarioPresenterUser()));
    }
    
    public void verNotificacoes(){
        presenter.setState(new NotificacaoPresenterState(new NotificacaoPresenterUser()));
    }
    
    public void fechar(){
        presenter.setState(new InicialPresenterState(PrincipalPresenterUser.getInstance()));
    }
}
