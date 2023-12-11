/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.admin;

import presenter.strategy.admin.GerenciarUsuariosPresenterAdmin;
import presenter.strategy.admin.IPresenterAdmin;
import presenter.strategy.admin.PrincipalPresenterAdmin;
import state.user.*;
import presenter.strategy.user.ExibeUsuarioPresenterUser;
import presenter.strategy.user.IPresenterUser;
import presenter.strategy.user.PrincipalPresenterUser;

/**
 *
 * @author isaac
 */
public class GerenciarUsuariosPresenterStateAdmin extends PresenterStateAdmin {

    public GerenciarUsuariosPresenterStateAdmin(IPresenterAdmin presenter) {
        super(presenter);

        principalPresenter.getInstance().getViewPrin().getDkstpPrincipal().add(presenter.getView(), 0);
        presenter.getView().setVisible(true);
    }
    
    @Override
    public void fechar() {
        principalPresenter.getInstance().setState(new InicialPresenterStateAdmin(principalPresenter.getInstance()));
        presenter.getView().dispose();
    }
    
}
