/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import model.User;
import state.admin.GerenciarUsuariosPresenterStateAdmin;
import state.admin.PresenterStateAdmin;
import view.admin.GerenciarUsuariosViewAdmin;

/**
 *
 * @author isaac
 */
public class GerenciarUsuariosPresenterAdmin extends IPresenterAdmin {
    private GerenciarUsuariosViewAdmin view;
    private PresenterStateAdmin state;
    private User userState;
    private static GerenciarUsuariosPresenterAdmin instance;
    
    private GerenciarUsuariosPresenterAdmin (User user){
        userState = user;
        this.view = new GerenciarUsuariosViewAdmin();
        this.state = new GerenciarUsuariosPresenterStateAdmin(this, userState);
        
        configuraTela();
    }
    
    public static GerenciarUsuariosPresenterAdmin getInstance(User user){
        if(instance == null){
            instance = new GerenciarUsuariosPresenterAdmin(user);
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
        view.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.editarUsuario();
            }
        });
        view.getBtnNovo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.criarNovoUsuario();
            }
        });
    }
    
    @Override
    public JInternalFrame getView() {
        return view;
    }
 
}
