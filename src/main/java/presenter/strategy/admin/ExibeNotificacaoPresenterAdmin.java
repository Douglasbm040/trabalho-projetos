/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import model.Notification;
import model.User;
import repository.Datasource.DAO.NotificationDAO.NotificationDAOSQLite;
import repository.Datasource.Factories.NotificationFactory.NotificationDAOSQLiteFactory;
import repository.Datasource.Factories.UserFactory.UserDAOSQLiteFactory;
import state.admin.ExibeNotificacaoPresenterStateAdmin;
import state.admin.PresenterStateAdmin;
import view.admin.DetalhesNotificacaoViewAdmin;

/**
 *
 * @author isaac
 */
public class ExibeNotificacaoPresenterAdmin extends IPresenterAdmin {
    
    private DetalhesNotificacaoViewAdmin view;
    private PresenterStateAdmin state;
    private User userState;
    private Notification notification;
    UserDAOSQLiteFactory user = new UserDAOSQLiteFactory(); 
    NotificationDAOSQLiteFactory notificaDAO =new NotificationDAOSQLiteFactory();
    public ExibeNotificacaoPresenterAdmin(User user,Notification notification) {
        userState = user;
        this.notification = notification;
        view = new DetalhesNotificacaoViewAdmin();
        state = new ExibeNotificacaoPresenterStateAdmin(this, user);
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
        view.getBtnAceitar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.create().updateUserTagAccess(2, notification.getIdSender());
                notificaDAO.Create().deleteNotification(notification.getIdNotification());
            }
        });
         view.getBtnRecusar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notificaDAO.Create().deleteNotification(notification.getIdNotification());
                user.create().deleteUser(notification.getIdSender());
                                
            }
        });
        if(notification != null){
            view.getTxtRemetente().setText(user.create().selectById(notification.getIdSender()).getName());
            view.getTxtAreaMensagem().setText(notification.getContent());
            view.getTxtData().setText(notification.getDataEnvio());
        }
    }
    
    @Override
    public JInternalFrame getView(){
        return view;
    }
}
