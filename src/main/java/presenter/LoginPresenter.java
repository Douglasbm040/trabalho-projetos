/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import presenter.strategy.admin.PrincipalPresenterAdmin;
import presenter.strategy.user.PrincipalPresenterUser;
import Service.validation.Adapter.FactoryValidationMethodExtern;

import java.util.List;
import javax.swing.JOptionPane;
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
                final FactoryValidationMethodExtern validador = new FactoryValidationMethodExtern();
                List<String> retornoValidador = validador.Create().validar(view.getTxtSenha().getText());
                if (retornoValidador.isEmpty()) {
                 PrincipalPresenterUser.getInstance();
                 //PrincipalPresenterAdmin.getInstance();
                    view.dispose();

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
