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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
        view.getBtnEditar().setEnabled(false);
        view.getBtnExcluir().setEnabled(false);
        ReportDAOSQLiteFactory reportFactory = new ReportDAOSQLiteFactory();
        List<RelatorioUsuario> relUserList = reportFactory.create().selectQtdNotificationSended(userState);

        DefaultTableModel model = (DefaultTableModel) view.getTblUsuarios().getModel();

        for (RelatorioUsuario relUser : relUserList) {
            System.out.println(relUser.getName() + "\n" + relUser.getQtdNotificacoesEnviadas());
            Object[] rowData = {relUser.getName(), relUser.getRegisterDate(), relUser.getQtdNotificacoesEnviadas(), relUser.getQtdNotificacoesLidas()};
            model.addRow(rowData);
        }
        
        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.fechar();
            }
        });
        view.getTblUsuarios().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Verificar se há uma linha selecionada
                boolean linhaSelecionada = view.getTblUsuarios().getSelectedRow() != -1;

                // Ativar ou desativar o botão com base na presença de uma linha selecionada
                view.getBtnEditar().setEnabled(linhaSelecionada);
                view.getBtnExcluir().setEnabled(linhaSelecionada);
            }
        });
        view.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDAOSQLiteFactory userFactory = new UserDAOSQLiteFactory(); 
                int row = view.getTblUsuarios().getSelectedRow();
                
                System.out.println("Row: " + row);
                System.out.println("List size: " + relUserList.size());
                
                List<RelatorioUsuario> listAtt = reportFactory.create().selectQtdNotificationSended(userState);
                
                if(row >= 0){
                    User userEdit = userFactory.create().selectById(listAtt.get(row).getIdUser());
                    state.editarUsuario(userEdit);
                }
            }
        });
        view.getBtnNovo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.criarNovoUsuario();
            }
        });
        view.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                List<RelatorioUsuario> relUserList = reportFactory.create().selectQtdNotificationSended(userState);

                DefaultTableModel model = (DefaultTableModel) view.getTblUsuarios().getModel();
                
                model.setRowCount(0);
                
                for (RelatorioUsuario relUser : relUserList) {
                    System.out.println(relUser.getName() + "\n" + relUser.getQtdNotificacoesEnviadas());
                    Object[] rowData = {relUser.getName(), relUser.getRegisterDate(), relUser.getQtdNotificacoesEnviadas(), relUser.getQtdNotificacoesLidas()};
                    model.addRow(rowData);
                }
            }
        });
    }

    @Override
    public JInternalFrame getView() {
        return view;
    }

}
