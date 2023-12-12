/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import model.Notification;
import model.User;
import repository.Datasource.Factories.NotificationFactory.NotificationDAOSQLiteFactory;
import state.admin.NotificacaoPresenterStateAdmin;
import state.admin.PresenterStateAdmin;
import view.admin.NotificacoesViewAdmin;

/**
 *
 * @author isaac
 */
public class NotificacaoPresenterAdmin extends IPresenterAdmin {
    private NotificacoesViewAdmin view;
    private PresenterStateAdmin state;
    private static NotificacaoPresenterAdmin instance;
    private User userState;
    NotificationDAOSQLiteFactory notificationFactory = new NotificationDAOSQLiteFactory();
    private List<Notification> listNotificationAdmin = notificationFactory.Create().SelectNotificationALLAdmin();
    private NotificacaoPresenterAdmin(User user) {
        userState = user;
        
        view = new NotificacoesViewAdmin();
        state = new NotificacaoPresenterStateAdmin(this, userState);
        
        configuraTela();
    }
    
    public static NotificacaoPresenterAdmin getInstance(User user){
        if(instance == null){
            instance = new NotificacaoPresenterAdmin(user);
        }
        
        return instance;
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
        view.getBtnAbrirNotificacao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = view.getTblNotificacoes().getSelectedRow();
                if(row >= 0){
                   state.verDetalhesNotificacao(listNotificationAdmin.get(row));
                }
                
            }
        });
        view.getBtnNovaNotificacao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.criarNovaNotificacao();
            }
        });
        DefaultTableModel modelo = (DefaultTableModel) view.getTblNotificacoes().getModel();

        for (Notification notificationUser : listNotificationAdmin) {
            String conteudo = notificationUser.getContent();
            Object[] dadosLinha = {notificationUser.getContent(),"user",notificationUser.getDataEnvio(),"lida"};  // Criar um array com o conteúdo
            modelo.addRow(dadosLinha);
        }
    }
    
    @Override
    public JInternalFrame getView(){
        return view;
    }
}
