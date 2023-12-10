/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import state.admin.PresenterStateAdmin;
import state.user.PresenterStateUser;
import view.admin.GerenciarUsuariosViewAdmin;

/**
 *
 * @author isaac
 */
public class GerenciarUsuariosPresenterAdmin implements IPresenterAdmin {
    private GerenciarUsuariosViewAdmin view;
    private PresenterStateAdmin state;
    private static GerenciarUsuariosPresenterAdmin instance;
    
    private GerenciarUsuariosPresenterAdmin (){
        this.view = new GerenciarUsuariosViewAdmin();
        
        configuraTela();
    }
    
    public static GerenciarUsuariosPresenterAdmin getInstance(){
        if (instance == null) {
            instance = new GerenciarUsuariosPresenterAdmin();
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
    public GerenciarUsuariosPresenterAdmin getPresenter() {
        return getInstance();
    }

    public GerenciarUsuariosViewAdmin getView() {
        return view;
    }
    
    
}
