/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.User;
import repository.Datasource.Factories.UserFactory.UserDAOSQLiteFactory;
import state.admin.EditarUsuarioPresenterStateAdmin;
import state.admin.PresenterStateAdmin;
import view.admin.EditarUsuarioViewAdmin;

/**
 *
 * @author isaac
 */
public class EditarUsuarioPresenterAdmin extends IPresenterAdmin {
    
    private EditarUsuarioViewAdmin view;
    private PresenterStateAdmin state;
    private User userState;
    private User userEdit;
    
    UserDAOSQLiteFactory UserFactory = new UserDAOSQLiteFactory();
    
    public EditarUsuarioPresenterAdmin(User user, User userEdit) {
        userState = user;
        this.userEdit = userEdit;
        view = new EditarUsuarioViewAdmin();
        state = new EditarUsuarioPresenterStateAdmin(this, user);
        System.out.println(this.userEdit.getName());
        configuraTela();
    }
    
    @Override
    public void setState(PresenterStateAdmin state) {
        this.state = state;
    }

    @Override
    public void configuraTela() {
        view.getTxtNome().setText(userEdit.getName());
        view.getTxtSenha().setText(userEdit.getTokenAccess());
        view.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.fechar();
            }
        });
        view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userEdit.setName(view.getTxtNome().getText());
                userEdit.setTokenAccess(view.getTxtSenha().getText());
                UserFactory.create().updateUserById(userEdit);
                JOptionPane.showMessageDialog(null, "Alteração realizada!");
                state.fechar();
            }
        });
    }
    
    @Override
    public JInternalFrame getView(){
        return view;
    }
}
