/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state.admin;

import model.User;
import presenter.strategy.admin.CriarNovoUsuarioPresenterAdmin;
import presenter.strategy.admin.EditarUsuarioPresenterAdmin;
import presenter.strategy.admin.ExibeUsuarioPresenterAdmin;
import presenter.strategy.admin.IPresenterAdmin;

/**
 *
 * @author isaac
 */
public class GerenciarUsuariosPresenterStateAdmin extends PresenterStateAdmin {

    public GerenciarUsuariosPresenterStateAdmin(IPresenterAdmin presenter, User user) {
        super(presenter, user);

        principalPresenter.getInstance(user).getViewPrin().getDkstpPrincipal().add(presenter.getView(), 0);
        presenter.getView().setVisible(true);
    }
    
    @Override
    public void criarNovoUsuario(){
        principalPresenter.getInstance(user).setState(new CriarNovoUsuarioPresenterStateAdmin(new CriarNovoUsuarioPresenterAdmin(user), user));
    }
    @Override
    public void editarUsuario(User userEdit){
        principalPresenter.getInstance(user).setState(new EditarUsuarioPresenterStateAdmin(new EditarUsuarioPresenterAdmin(user, userEdit), user));
    }
    
    @Override
    public void exibirUsuario(){
        principalPresenter.getInstance(user).setState(new ExibeUsuarioPresenterStateAdmin(new ExibeUsuarioPresenterAdmin(user), user));
    }
    
    @Override
    public void fechar() {
        principalPresenter.getInstance(user).setState(new InicialPresenterStateAdmin(principalPresenter.getInstance(user), user));
        presenter.getView().dispose();
    }
    
}
