/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.strategy.admin;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import model.Notification;
import model.User;
import presenter.LoginPresenter;
import repository.Datasource.Factories.NotificationFactory.NotificationDAOSQLiteFactory;
import state.admin.InicialPresenterStateAdmin;
import state.admin.PresenterStateAdmin;
import view.admin.PrincipalViewAdmin;

/**
 *
 * @author isaac
 */
public class PrincipalPresenterAdmin extends IPresenterAdmin {

    private static PrincipalPresenterAdmin instance;

    private PrincipalViewAdmin view;
    private PresenterStateAdmin state;
    private User userState;
    NotificationDAOSQLiteFactory notificationFactory = new NotificationDAOSQLiteFactory();
    private List<Notification> listNotificationAdmin ;
    private PrincipalPresenterAdmin(User user) {
        userState = user;
        this.view = new PrincipalViewAdmin();
        this.state = new InicialPresenterStateAdmin(this, user);
        listNotificationAdmin = notificationFactory.Create().SelectNotificationALLAdmin();
        configuraTela();
    }

    public static PrincipalPresenterAdmin getInstance(User user) {
        if (instance == null) {
            instance = new PrincipalPresenterAdmin(user);
        }
        return instance;
    }

    @Override
    public void setState(PresenterStateAdmin state) {
        this.state = state;
    }

    @Override
    public void configuraTela() {
        view.setExtendedState(MAXIMIZED_BOTH);
        view.getMenuSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                instance = null;
                view.dispose();
            }
        });
        view.getMenuGerenciarUsuarios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.manterUsuarios();
            }
        });
        view.getBtnNotificacao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.verNotificacoes();
            }
        });
        int countNotification = listNotificationAdmin.size();
        view.getBtnNotificacao().setText("Notificações: " + countNotification);
        if (userState != null) {
            view.getLblTipoUsuarioRodape().setText("Tipo: Admin");
            view.getLblUsuarioRodape().setText("Usuário: "+ userState.getName());
        }
        view.setVisible(true);
    }
    
    
    public PrincipalViewAdmin getViewPrin() {
        return view;
    }

}
