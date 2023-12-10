/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.user;

import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presenter.LoginPresenter;
import state.user.ExibeUsuarioPresenterStateUser;
import state.user.PresenterStateUser;
import view.user.ExibeUsuarioViewUser;

/**
 *
 * @author isaac
 */
public class ExibeUsuarioPresenterUser extends IPresenterUser {
    private ExibeUsuarioViewUser view;
    private PresenterStateUser state;

    public ExibeUsuarioPresenterUser() {
        this.view = new ExibeUsuarioViewUser();
        this.state = new ExibeUsuarioPresenterStateUser(this);

        configuraTela();

        view.setVisible(true);
    }

    @Override
    public void setState(PresenterStateUser state) {
        this.state = state;
    }

    @Override
    public void configuraTela() {
        view.getBtnFechar().addActionListener(
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               state.fechar();
            }
            
        } );
      view.getTxtNome().setText("isaack");
    }

   

    
    @Override
    public javax.swing.JInternalFrame getView() {
        return view;
    }


    
    
}
