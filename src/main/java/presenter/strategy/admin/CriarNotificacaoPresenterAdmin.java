/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import model.User;
import state.admin.CriarNotificacaoPresenterStateAdmin;
import state.admin.CriarNovoUsuarioPresenterStateAdmin;
import state.admin.PresenterStateAdmin;
import view.admin.CriarNotificacaoViewAdmin;
import view.admin.CriarNovoUsuarioViewAdmin;

/**
 *
 * @author isaac
 */
public class CriarNotificacaoPresenterAdmin extends IPresenterAdmin {
    private CriarNotificacaoViewAdmin view;
    private PresenterStateAdmin state;
    private User userState;
    
    public CriarNotificacaoPresenterAdmin(User user) {
        userState = user;
        view = new CriarNotificacaoViewAdmin();
        state = new CriarNotificacaoPresenterStateAdmin(this, user);
        
        configuraTela();
    }
    
    @Override
    public void setState(PresenterStateAdmin state) {
        this.state = state;
    }

    @Override
    public void configuraTela() {
        view.getBtnCancelar().addActionListener(new ActionListener() {
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
