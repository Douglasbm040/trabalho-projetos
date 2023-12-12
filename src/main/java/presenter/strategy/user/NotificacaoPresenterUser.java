/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.user;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.User;
import state.user.NotificacaoPresenterStateUser;
import state.user.PresenterStateUser;
import view.user.NotificacoesViewUser;

/**
 *
 * @author isaac
 */
public class NotificacaoPresenterUser extends IPresenterUser {

    private NotificacoesViewUser view;
    private PresenterStateUser state;
    private static NotificacaoPresenterUser instance;
    private User userState;

    private NotificacaoPresenterUser(User user) {
        userState = user;
        view = new NotificacoesViewUser();
        state = new NotificacaoPresenterStateUser(this, userState);
        configuraTela();
        view.setVisible(true);
    }

    public static NotificacaoPresenterUser getInstance(User user) {
        if (instance == null) {
            instance = new NotificacaoPresenterUser(user);
        }

        return instance;
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
        view.getBtnAbrirNotificacao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.exibeNotificacao();
            }
        });
    }

    @Override
    public javax.swing.JInternalFrame getView() {
        return view;
    }
}
