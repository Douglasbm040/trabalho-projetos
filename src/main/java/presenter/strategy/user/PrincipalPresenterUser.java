/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.user;

import Service.observer.IObserver;
import Service.observer.Observable;
import Service.observer.UserObservable;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import model.Notification;
import model.User;
import presenter.LoginPresenter;
import repository.Datasource.Factories.NotificationFactory.NotificationDAOSQLiteFactory;
import state.user.InicialPresenterStateUser;
import state.user.PresenterStateUser;
import view.user.ExibeUsuarioViewUser;
import view.user.PrincipalViewUser;

/**
 *
 * @author isaac
 */
public class PrincipalPresenterUser extends IPresenterUser {

    private static PrincipalPresenterUser instance;

    private PrincipalViewUser view;
    private PresenterStateUser state;
    private User userState;
    //
    NotificationDAOSQLiteFactory notificationFactory = new NotificationDAOSQLiteFactory();
    private List<Notification> listNotificationUser ;
    private PrincipalPresenterUser(User user) {
        this.view = new PrincipalViewUser();
        this.state = new InicialPresenterStateUser(this, user); 
        userState = user;
        listNotificationUser = notificationFactory.Create().SelectNotificationALLUser(userState.getId());
        configuraTela();
        
        view.setVisible(true);
    }

    public static PrincipalPresenterUser getInstance(User user) {
        if (instance == null) {
            instance = new PrincipalPresenterUser(user);
        }
        return instance;
    }

    @Override
    public void setState(PresenterStateUser state) {
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
        view.getMenuUsuario().addActionListener(new ActionListener() {
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
        int countNotification = listNotificationUser.size();
        if (userState != null) {
            view.getLblTipoUsuarioRodape().setText("Tipo: User");
            view.getLblUsuarioRodape().setText("Usuário :"+ userState.getName());
        }
        
        view.getBtnNotificacao().setText("Notificações: " + countNotification);
        
    }

    public User getUserState() {
        return userState;
    }

    public void setUserState(User userState) {
        this.userState = userState;
    }

    public PrincipalViewUser getViewPrin() {
        return view;
    }

}
