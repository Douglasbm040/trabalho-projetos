/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.user;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.Notification;
import model.User;
import repository.Datasource.Factories.NotificationFactory.NotificationDAOSQLiteFactory;
import repository.Datasource.Factories.UserFactory.UserDAOSQLiteFactory;
import state.user.NotificacaoPresenterStateUser;
import state.user.PresenterStateUser;
import view.user.NotificacoesViewUser;

/**
 *
 * @author isaac
 */
public class NotificacaoPresenterUser extends IPresenterUser {

    private NotificacoesViewUser view;
    private PresenterStateUser state;
    private static NotificacaoPresenterUser instance;
    private User userState;

    NotificationDAOSQLiteFactory notificationFactory = new NotificationDAOSQLiteFactory();
    UserDAOSQLiteFactory userFactory = new UserDAOSQLiteFactory(); 
    private List<Notification> listNotificationUser;

    private NotificacaoPresenterUser(User user) {
        userState = user;
        view = new NotificacoesViewUser();
        state = new NotificacaoPresenterStateUser(this, userState);
        listNotificationUser = notificationFactory.Create().SelectNotificationALLUser(user.getId());
        configuraTela();
        view.setVisible(true);
    }

    public static NotificacaoPresenterUser getInstance(User user) {
        if (instance == null) {
            instance = new NotificacaoPresenterUser(user);
        }

        return instance;
    }

    @Override
    public void setState(PresenterStateUser state) {
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
        view.getBtnAbrirNotificacao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = view.getTblNotificacoes().getSelectedRow();
                if(row >= 0){
                    state.exibeNotificacao(listNotificationUser.get(row));
                }
                notificationFactory.Create().updateToRead(listNotificationUser.get(row));
                listNotificationUser.get(row).getContent();
            }

        });

        
        DefaultTableModel modelo = (DefaultTableModel) view.getTblNotificacoes().getModel();
        
        for (Notification notificationUser : listNotificationUser) {
            String isRead  = notificationUser.getIsRead() == 0 ? "não lida" : "lida";
            String conteudo = notificationUser.getContent();
            Object[] dadosLinha = {notificationUser.getContent(),userFactory.create().selectById(notificationUser.getIdSender()).getName(),notificationUser.getDataEnvio(),isRead};  // Criar um array com o conteúdo
            modelo.addRow(dadosLinha);
        }
        
        
        
    }

    @Override
    public javax.swing.JInternalFrame getView() {
        return view;
    }
}
