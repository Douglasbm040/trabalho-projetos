/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.LoginView;

/**
 *
 * @author isaac
 */
public class LoginPresenter {
    private LoginView view;

    public LoginPresenter() {
        this.view = new LoginView();
        view.setVisible(true);
        
        configuraTela();
    }
    
    public void configuraTela(){
        view.getLblNovaConta().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                view.getLblNovaConta().setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
    }
}
