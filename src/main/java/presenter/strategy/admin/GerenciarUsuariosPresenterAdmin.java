/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.RelatorioUsuario;
import model.User;
import repository.Datasource.Factories.ReportFactory.ReportDAOSQLiteFactory;
import repository.Datasource.Factories.UserFactory.UserDAOSQLiteFactory;
import state.admin.GerenciarUsuariosPresenterStateAdmin;
import state.admin.PresenterStateAdmin;
import view.admin.GerenciarUsuariosViewAdmin;

/**
 *
 * @author isaac
 */
public class GerenciarUsuariosPresenterAdmin extends IPresenterAdmin {

    private GerenciarUsuariosViewAdmin view;
    private PresenterStateAdmin state;
    private User userState;
    private static GerenciarUsuariosPresenterAdmin instance;

    private GerenciarUsuariosPresenterAdmin(User user) {
        userState = user;
        this.view = new GerenciarUsuariosViewAdmin();
        this.state = new GerenciarUsuariosPresenterStateAdmin(this, userState);

        configuraTela();
    }

    public static GerenciarUsuariosPresenterAdmin getInstance(User user) {
        if (instance == null) {
            instance = new GerenciarUsuariosPresenterAdmin(user);
        }
        return instance;
    }

    @Override
    public void setState(PresenterStateAdmin state) {
        this.state = state;
    }

    @Override
    public void configuraTela() {
        ReportDAOSQLiteFactory reportFactory = new ReportDAOSQLiteFactory();
        List<RelatorioUsuario> relUserList = reportFactory.create().selectQtdNotificationSended(userState);

        DefaultTableModel model = (DefaultTableModel) view.getTblUsuarios().getModel();

        for (RelatorioUsuario relUser : relUserList) {
            // Substitua os valores abaixo pelos atributos reais do seu objeto User
            System.out.println(relUser.getName() + "\n" + relUser.getQtdNotificacoesEnviadas());
            Object[] rowData = {relUser.getName(), relUser.getRegisterDate(), relUser.getQtdNotificacoesEnviadas(), relUser.getQtdNotificacoesLidas()};
            model.addRow(rowData);
        }
        
       // model.fireTableDataChanged();
//        DefaultTableModel modelo = (DefaultTableModel) view.getTblNotificacoes().getModel();
//
//        for (Notification notificationUser : listNotificationAdmin) {
//            String conteudo = notificationUser.getContent();
//            Object[] dadosLinha = {notificationUser.getContent(),"user",notificationUser.getDataEnvio(),"lida"};  // Criar um array com o conteúdo
//            modelo.addRow(dadosLinha);
//        }
        
        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.fechar();
            }
        });
        view.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.editarUsuario();
            }
        });
        view.getBtnNovo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.criarNovoUsuario();
            }
        });
    }

    @Override
    public JInternalFrame getView() {
        return view;
    }

}
