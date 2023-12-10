
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
    public ExibeNotificacaoPresenterStateUser (IPresenterUser presenter){
        super(presenter);
        this.presenter = presenter;
        
    }

   
    
    @Override
    public void fechar(){
        presenter.getView().dispose();
        presenter.setState(new InicialPresenterStateUser(PrincipalPresenterUser.getInstance()));
       
    }
    
   
}
