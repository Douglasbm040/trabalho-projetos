/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import Service.validation.Adapter.FactoryValidationMethodExtern;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import model.Notification;
import model.User;
import repository.Datasource.DAO.UserDAO.UserDAOSQLite;
import repository.Datasource.Factories.NotificationFactory.NotificationDAOSQLiteFactory;
import repository.Datasource.Factories.UserFactory.UserDAOSQLiteFactory;
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
        UserDAOSQLiteFactory UserDAO = new UserDAOSQLiteFactory();
        NotificationDAOSQLiteFactory notificationDAO = new NotificationDAOSQLiteFactory();
        List<User> listUser = UserDAO.create().selectUserAll();
        view.getBtnCriarConta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getTxtUsuario().getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Campo usuarios está vazio !");
                    return;
                }
                for (User usuario : listUser) {
                    System.out.println(usuario.getName());
                    if (view.getTxtUsuario().getText().equals(usuario.getName())) {
                        JOptionPane.showMessageDialog(null, "Este Usuario já está em uso !");
                        return;
                    }
                }
                final FactoryValidationMethodExtern validador = new FactoryValidationMethodExtern();
                List<String> retornoValidador = validador.Create().validar(view.getTxtSenha().getText());
                if (retornoValidador.isEmpty()) {
                    if (listUser.isEmpty()) {
                        int row = UserDAO.create().insertUser(new User(view.getTxtUsuario().getText(), view.getTxtSenha().getText(), 0));
                        if (row > 0) {
                            LocalDateTime dataAtual = LocalDateTime.now();
                            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            String dataAtualFormatada = dataAtual.format(formato);
                            notificationDAO.Create().insertNotification(new Notification("O usuário solicio de acesso ", dataAtualFormatada, row));
                        }
                        JOptionPane.showMessageDialog(null, "Cadastro concluido !");
                        view.dispose();
                        return;
                    }
                    
                    UserDAO.create().insertUser(new User(view.getTxtUsuario().getText(), view.getTxtSenha().getText(), 2));
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
