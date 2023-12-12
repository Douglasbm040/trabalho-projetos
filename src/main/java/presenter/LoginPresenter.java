/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import presenter.strategy.admin.PrincipalPresenterAdmin;
import presenter.strategy.user.PrincipalPresenterUser;
import Service.validation.Adapter.FactoryValidationMethodExtern;

import java.util.List;
import javax.swing.JOptionPane;
import model.Notification;
import model.User;
import repository.Datasource.Factories.NotificationFactory.NotificationDAOSQLiteFactory;
import repository.Datasource.Factories.UserFactory.UserDAOSQLiteFactory;
import view.LoginView;

/**
 *
 * @author isaac
 */
public class LoginPresenter {

    private LoginView view;
    private static LoginPresenter presenter;

    private LoginPresenter() {
        this.view = new LoginView();
        view.setVisible(true);

        configuraTela();
    }

    public void configuraTela() {
        view.getBtnEntrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDAOSQLiteFactory UserFactory = new UserDAOSQLiteFactory();
                NotificationDAOSQLiteFactory notificationFactory = new NotificationDAOSQLiteFactory();
                List<User> listUser = UserFactory.create().selectUserAll();
                final FactoryValidationMethodExtern validador = new FactoryValidationMethodExtern();
                List<String> retornoValidador = validador.Create().validar(view.getTxtSenha().getText());
                if (view.getTxtUsuario().getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Campo usuarios está vazio !");
                    return;
                }
                if (retornoValidador.isEmpty()) {
                    User userCadastro = null;
                    for (User usuario : listUser) {
                        if (view.getTxtUsuario().getText().equals(usuario.getName()) && view.getTxtSenha().getText().equals(usuario.getTokenAccess())) {
                            userCadastro = usuario;
                        }
                    }
                    if (userCadastro != null) {
                        List<Notification> listNotificationAdmin = notificationFactory.Create().SelectNotificationALLAdmin();
                        List<Notification> listNotificationUser = notificationFactory.Create().SelectNotificationALLUser(userCadastro.getId());
                        switch (userCadastro.getTagAccess()) {
                            case 0:
                                System.out.println(userCadastro.getId());
                                for (Notification n : listNotificationAdmin) {
                                    System.out.println(n.getContent() + n.getDataEnvio() + n.getIdReceptor());
                                }
                                for (Notification n : listNotificationUser) {
                                    System.out.println(n.getContent() + n.getDataEnvio() + n.getIdReceptor());
                                }
                                JOptionPane.showMessageDialog(null, "Aguarde a confirmação do admin !");
                                break;
                            case 1:
                                PrincipalPresenterAdmin.getInstance(userCadastro);
                                view.dispose();
                                break;
                            case 2:

                                PrincipalPresenterUser.getInstance(userCadastro);
                                view.dispose();
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Aguarde a confirmação do admin !");
                        }

                    } else {

                        JOptionPane.showMessageDialog(null, "Usuário não cadastrado !");

                    }
                } else {
                    JOptionPane.showMessageDialog(null, retornoValidador.get(0));
                }
            }
        });
        view.getLblNovaConta().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CadastroPresenter.getInstance();
            }
        });
    }

    public static LoginPresenter getInstance() {
        if (presenter == null) {
            return new LoginPresenter();
        }
        return presenter;
    }
}
