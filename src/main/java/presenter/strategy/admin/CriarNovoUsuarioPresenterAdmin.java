/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.User;
import repository.Datasource.Factories.UserFactory.UserDAOSQLiteFactory;
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
    UserDAOSQLiteFactory UserFactory = new UserDAOSQLiteFactory();
    
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
        view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime dataAtual = LocalDateTime.now();
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String dataAtualFormatada = dataAtual.format(formato);
                
                String nome = view.getTxtNome().getText();
                String senha = view.getTxtSenha().getText();
                
                if (nome.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Campo de usuário não pode ser vazio!");
                    return;
                }
                if (senha.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Campo senha não pode esta vazio !");
                    return;
                }
                
                User newUser = new User(nome, senha, 2, dataAtualFormatada);
                UserFactory.create().insertUser(newUser);
                JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso!");
                state.fechar();
            }
        });
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
