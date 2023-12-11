/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
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
    
    private NotificacaoPresenterAdmin() {
        view = new NotificacoesViewAdmin();
        state = new NotificacaoPresenterStateAdmin(this);
        
        configuraTela();
    }
    
    public static NotificacaoPresenterAdmin getInstance(){
        if(instance == null){
            instance = new NotificacaoPresenterAdmin();
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
    }
    
    @Override
    public JInternalFrame getView(){
        return view;
    }
}
