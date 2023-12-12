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
import model.Notification;
import model.User;
import repository.Datasource.Factories.NotificationFactory.NotificationDAOSQLiteFactory;
import repository.Datasource.Factories.UserFactory.UserDAOSQLiteFactory;
import state.admin.CriarNotificacaoPresenterStateAdmin;
import state.admin.CriarNovoUsuarioPresenterStateAdmin;
import state.admin.PresenterStateAdmin;
import view.admin.CriarNotificacaoViewAdmin;
import view.admin.CriarNovoUsuarioViewAdmin;

/**
 *
 * @author isaac
 */
public class CriarNotificacaoPresenterAdmin extends IPresenterAdmin {

    private CriarNotificacaoViewAdmin view;
    private PresenterStateAdmin state;
    private User userState;
    UserDAOSQLiteFactory userDAO = new UserDAOSQLiteFactory();
    NotificationDAOSQLiteFactory notificationDAO = new NotificationDAOSQLiteFactory();

    public CriarNotificacaoPresenterAdmin(User user) {
        userState = user;
        view = new CriarNotificacaoViewAdmin();
        state = new CriarNotificacaoPresenterStateAdmin(this, user);

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
        view.getBtnEnviar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = null;
                if (view.getTxtAreaMensagem().getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Campo de mensagem não pode ser vazio!");
                    return;
                }
                if (view.getTxtDestinatario().getText() == null) {
                    JOptionPane.showMessageDialog(null, "Campo usuário não pode esta vazio !");
                    return;
                }
                System.out.println("texto");
                    System.out.println(view.getTxtDestinatario().getText());
                for (User usuario : userDAO.create().selectUserAll()) {
                    System.out.println(usuario.getName());

                    if (view.getTxtDestinatario().getText().equals(usuario.getName())) {
                        System.out.println(usuario.getId());
                        user = usuario;
                    }
                }
                if (user != null) {
                    LocalDateTime dataAtual = LocalDateTime.now();
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String dataAtualFormatada = dataAtual.format(formato);
                    Notification notification = new Notification(view.getTxtAreaMensagem().getText(), dataAtualFormatada, userState.getId(), user.getId(), 0);
                    notificationDAO.Create().insertNotification(notification);
                    JOptionPane.showMessageDialog(null, "Mensagem enviado !");
                    return;
                }
                JOptionPane.showMessageDialog(null, "Campo usuário não encontrado !");
            }
        });
    }

    @Override
    public JInternalFrame getView() {
        return view;
    }
}
