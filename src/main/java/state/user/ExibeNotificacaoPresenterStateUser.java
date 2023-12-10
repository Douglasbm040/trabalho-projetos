/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.user;

import presenter.strategy.user.ExibeUsuarioPresenterUser;
import presenter.strategy.user.IPresenterUser;
import presenter.strategy.user.PrincipalPresenterUser;

/**
 *
 * @author isaac
 */
public class ExibeNotificacaoPresenterStateUser extends PresenterStateUser {
    public ExibeNotificacaoPresenterStateUser (IPresenterUser<ExibeUsuarioPresenterUser> presenter){
        super(presenter);
        
    }
    
    @Override
    public void fechar(){
        presenter.setState(new InicialPresenterStateUser(PrincipalPresenterUser.getInstance()));
    }
}
