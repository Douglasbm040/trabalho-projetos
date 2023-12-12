/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Notification;
import model.User;
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
    private User userState;
    private Notification notification;
   
    
    public ExibeNotificacaoPresenterUser(User user,Notification notification) {
        userState = user;
        this.notification = notification;
        view = new DetalhesNotificacaoViewUser();
        state = new ExibeNotificacaoPresenterStateUser(this, userState);

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
        if(userState != null && notification != null){
            view.getTxtData().setText(notification.getDataEnvio());
            view.getTxtRemetente().setText("User");
            view.getTxtAreaMensagem().setText(notification.getContent());
        }
    }

    @Override
    public javax.swing.JInternalFrame getView() {
        return view;
    }
}

