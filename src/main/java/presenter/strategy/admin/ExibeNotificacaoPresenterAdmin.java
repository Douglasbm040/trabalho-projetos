/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import model.Notification;
import model.User;
import state.admin.ExibeNotificacaoPresenterStateAdmin;
import state.admin.PresenterStateAdmin;
import view.admin.DetalhesNotificacaoViewAdmin;

/**
 *
 * @author isaac
 */
public class ExibeNotificacaoPresenterAdmin extends IPresenterAdmin {
    
    private DetalhesNotificacaoViewAdmin view;
    private PresenterStateAdmin state;
    private User userState;
    private Notification notification;
    
    public ExibeNotificacaoPresenterAdmin(User user,Notification notification) {
        userState = user;
        this.notification = notification;
        view = new DetalhesNotificacaoViewAdmin();
        state = new ExibeNotificacaoPresenterStateAdmin(this, user);
        
        configuraTela();
    }
    
    @Override
    public void setState(PresenterStateAdmin state) {
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
    public JInternalFrame getView(){
        return view;
    }
}
