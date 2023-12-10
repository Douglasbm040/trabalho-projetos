/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import Service.validation.Adapter.FactoryValidationMethodExtern;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.User;
import presenter.strategy.user.PrincipalPresenterUser;
import repository.Datasource.DAO.UserDAO.UserDAOSQLite;
import view.CadastroView;

/**
 *
 * @author isaac
 */
public class CadastroPresenter {

    private CadastroView view;
    private static CadastroPresenter presenter;

    private CadastroPresenter() {
        this.view = new CadastroView();
        view.setVisible(true);

        configuraTela();
    }

    public void configuraTela() {
        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
        UserDAOSQLite UserDAO = new UserDAOSQLite();
        List<User> lista = UserDAO.selectUserAll();
        view.getBtnCriarConta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(view.getTxtUsuario().getText().isBlank()){
                   JOptionPane.showMessageDialog(null, "Campo usuarios está vazio !");
                    return; 
                }
                for (User usuario : lista) {
                    System.out.println(usuario.getName());
                    if (view.getTxtUsuario().getText().equals(usuario.getName())) {
                        JOptionPane.showMessageDialog(null, "Este Usuario já está em uso !");
                        return;
                    }
                }
                final FactoryValidationMethodExtern validador = new FactoryValidationMethodExtern();
                List<String> retornoValidador = validador.Create().validar(view.getTxtSenha().getText());
                if (retornoValidador.isEmpty()) {
                    if (lista.isEmpty()) {
                        UserDAO.insertUser(new User(view.getTxtNome().getText(), view.getTxtSenha().getText(), 1));
                        JOptionPane.showMessageDialog(null, "Cadastro concluido !");
                        view.dispose();
                        return;
                    }
                    UserDAO.insertUser(new User(view.getTxtNome().getText(), view.getTxtSenha().getText(), 2));
                        JOptionPane.showMessageDialog(null, "Cadastro concluido !");
                        view.dispose();
                        return;
                } else {
                    JOptionPane.showMessageDialog(null, retornoValidador.get(0));
                }

            }
        });

    }

    public static CadastroPresenter getInstance() {
        if (presenter == null) {
            return new CadastroPresenter();
        }
        return presenter;
    }
}
