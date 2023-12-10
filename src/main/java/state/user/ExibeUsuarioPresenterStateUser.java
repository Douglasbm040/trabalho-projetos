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
public class ExibeUsuarioPresenterStateUser extends PresenterStateUser {

    public ExibeUsuarioPresenterStateUser(IPresenterUser presenter) {
        super(presenter);
        principalPresenter.getInstance().getViewPrin().getDkstpPrincipal().add(presenter.getView(),0);
        presenter.getView().setVisible(true);
   
    }

    public void fechar() { 
        principalPresenter.getInstance().setState(new InicialPresenterStateUser(principalPresenter.getInstance()));
        presenter.getView().dispose();
    }

}
