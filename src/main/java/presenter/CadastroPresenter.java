/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CadastroView;

/**
 *
 * @author isaac
 */
public class CadastroPresenter {
    private CadastroView view;
    private static CadastroPresenter presenter;
    
    private CadastroPresenter() {
        this.view = new CadastroView();
        view.setVisible(true);
        
        configuraTela();
    }
    
    public void configuraTela(){
        view.getBtnFechar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
    }
    
    public static CadastroPresenter getInstance(){
        if(presenter == null){
            return new CadastroPresenter();
        }
        return presenter;
    }
}
