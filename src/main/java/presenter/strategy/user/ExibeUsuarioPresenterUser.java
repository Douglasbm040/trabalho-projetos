/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.User;
import state.user.ExibeUsuarioPresenterStateUser;
import state.user.PresenterStateUser;
import view.user.ExibeUsuarioViewUser;

/**
 *
 * @author isaac
 */
public class ExibeUsuarioPresenterUser extends IPresenterUser {

    private ExibeUsuarioViewUser view;
    private PresenterStateUser state;
    private User userState;

    public ExibeUsuarioPresenterUser(User user) {
        userState = user;
        this.view = new ExibeUsuarioViewUser();
        this.state = new ExibeUsuarioPresenterStateUser(this, userState);
        
        configuraTela();
        view.setVisible(true);
    }

    @Override
    public void setState(PresenterStateUser state) {
        this.state = state;
    }

    @Override
    public void configuraTela() {
        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.fechar();
            }

        });
        if (getUserState() != null) {
            view.getTxtUsuario().setText(getUserState().getName());
            view.getTxtSenha().setText(getUserState().getTokenAccess());
        }
    }

    @Override
    public javax.swing.JInternalFrame getView() {
        return view;
    }

    public User getUserState() {
        return userState;
    }

    public void setUserState(User userState) {
        this.userState = userState;
    }

}
