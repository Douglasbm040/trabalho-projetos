/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

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
        
    }
    
    public static CadastroPresenter getInstance(){
        if(presenter == null){
            return new CadastroPresenter();
        }
        return presenter;
    }
}
