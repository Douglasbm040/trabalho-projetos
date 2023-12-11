/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
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
    
    public GerenciarUsuariosPresenterAdmin (){
        this.view = new GerenciarUsuariosViewAdmin();
        this.state = new GerenciarUsuariosPresenterStateAdmin(this);
        
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
    public JInternalFrame getView() {
        return view;
    }
 
}
