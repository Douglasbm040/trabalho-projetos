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

    public GerenciarUsuariosPresenterStateAdmin(IPresenterAdmin<GerenciarUsuariosPresenterAdmin> presenter) {
        super(presenter);

        principalPresenter.getInstance().getView().getDkstpPrincipal().add(presenter.getPresenter().getView());
        presenter.getPresenter().getView().setVisible(true);
    }
    
    @Override
    public void fechar() {
        presenter.setState(new InicialPresenterStateAdmin(PrincipalPresenterAdmin.getInstance()));
    }
    
}
