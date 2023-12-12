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
import model.User;
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
        UserDAOSQLiteFactory UserFactory = new UserDAOSQLiteFactory();
        List<User> userList = UserFactory.create().selectUserAllTypeUser();
        JTable tblUsuarios = view.getTblUsuarios();

        DefaultTableModel model = (DefaultTableModel) tblUsuarios.getModel();

        for (User user : userList) {
            // Substitua os valores abaixo pelos atributos reais do seu objeto User
            Object[] rowData = {user.getName()};
            model.addRow(rowData);
        }
        
        model.fireTableDataChanged();
        
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
