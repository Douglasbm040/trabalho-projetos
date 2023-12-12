/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import model.User;
import state.admin.NotificacaoPresenterStateAdmin;
import state.admin.PresenterStateAdmin;
import view.admin.NotificacoesViewAdmin;

/**
 *
 * @author isaac
 */
public class NotificacaoPresenterAdmin extends IPresenterAdmin {
    private NotificacoesViewAdmin view;
    private PresenterStateAdmin state;
    private static NotificacaoPresenterAdmin instance;
    private User userState;
    
    private NotificacaoPresenterAdmin(User user) {
        userState = user;
        view = new NotificacoesViewAdmin();
        state = new NotificacaoPresenterStateAdmin(this, userState);
        
        configuraTela();
    }
    
    public static NotificacaoPresenterAdmin getInstance(User user){
        if(instance == null){
            instance = new NotificacaoPresenterAdmin(user);
        }
        
        return instance;
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
        view.getBtnAbrirNotificacao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.verDetalhesNotificacao();
            }
        });
        view.getBtnNovaNotificacao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.criarNovaNotificacao();
            }
        });
    }
    
    @Override
    public JInternalFrame getView(){
        return view;
    }
}
