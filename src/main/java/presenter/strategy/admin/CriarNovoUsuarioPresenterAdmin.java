/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import model.User;
import state.admin.CriarNovoUsuarioPresenterStateAdmin;
import state.admin.EditarUsuarioPresenterStateAdmin;
import state.admin.PresenterStateAdmin;
import view.admin.CriarNovoUsuarioViewAdmin;
import view.admin.EditarUsuarioViewAdmin;

/**
 *
 * @author isaac
 */
public class CriarNovoUsuarioPresenterAdmin extends IPresenterAdmin {
    private CriarNovoUsuarioViewAdmin view;
    private PresenterStateAdmin state;
    private User userState;
    
    public CriarNovoUsuarioPresenterAdmin(User user) {
        userState = user;
        view = new CriarNovoUsuarioViewAdmin();
        state = new CriarNovoUsuarioPresenterStateAdmin(this, user);
        
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
