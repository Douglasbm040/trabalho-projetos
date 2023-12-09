/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presenter.LoginPresenter;
import state.InicialPresenterState;
import state.PresenterState;
import view.user.PrincipalViewUser;

/**
 *
 * @author isaac
 */
public class PrincipalPresenterUser implements IPresenterUser {

    private PrincipalViewUser view;
    private PresenterState state;

    public PrincipalPresenterUser() {
        this.view = new PrincipalViewUser();
        this.state = new InicialPresenterState(this);

        configuraTela();
    }

    @Override
    public void setState(PresenterState state) {
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
        view.getMenuUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               state.manterUsuarios();
            }
        });
        view.setVisible(true);
    }

}
