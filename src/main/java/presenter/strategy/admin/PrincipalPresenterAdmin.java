/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.strategy.admin;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presenter.LoginPresenter;
import state.admin.InicialPresenterStateAdmin;
import state.admin.PresenterStateAdmin;
import state.user.InicialPresenterStateUser;
import state.user.PresenterStateUser;
import view.CadastroView;
import view.LoginView;
import view.admin.PrincipalViewAdmin;
import view.user.PrincipalViewUser;

/**
 *
 * @author isaac
 */
public class PrincipalPresenterAdmin implements IPresenterAdmin {

    private static PrincipalPresenterAdmin instance;

    private PrincipalViewAdmin view;
    private PresenterStateAdmin state;

    private PrincipalPresenterAdmin() {
        this.view = new PrincipalViewAdmin();
        this.state = new InicialPresenterStateAdmin(this);

        configuraTela();
    }

    public static PrincipalPresenterAdmin getInstance() {
        if (instance == null) {
            instance = new PrincipalPresenterAdmin();
        }
        return instance;
    }

    @Override
    public void setState(PresenterStateAdmin state) {
        this.state = state;
    }

    @Override
    public void configuraTela() {
        view.setExtendedState(MAXIMIZED_BOTH);
        view.getMenuSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                LoginPresenter.getInstance();
            }
        });
        view.getMenuGerenciarUsuarios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.manterUsuarios();
            }
        });
        view.setVisible(true);
    }

    public PrincipalViewAdmin getView() {
        return view;
    }

    @Override
    public PrincipalPresenterAdmin getPresenter() {
        return getInstance();
    }

}
