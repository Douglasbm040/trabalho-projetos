/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import state.user.ExibeNotificacaoPresenterStateUser;
import state.user.PresenterStateUser;
import view.user.DetalhesNotificacaoViewUser;

/**
 *
 * @author isaac
 */
public class ExibeNotificacaoPresenterUser extends IPresenterUser {

    private DetalhesNotificacaoViewUser view;
    private PresenterStateUser state;
    
    public ExibeNotificacaoPresenterUser() {
        view = new DetalhesNotificacaoViewUser();
        state = new ExibeNotificacaoPresenterStateUser(this);

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
    }

    @Override
    public javax.swing.JInternalFrame getView() {
        return view;
    }
}

