/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presenter.LoginPresenter;
import state.PresenterState;
import view.user.ExibeUsuarioViewUser;

/**
 *
 * @author isaac
 */
public class ExibeUsuarioPresenterUser implements IPresenterUser<ExibeUsuarioPresenterUser> {
    private ExibeUsuarioViewUser view;
    private PresenterState state;

    public ExibeUsuarioPresenterUser() {
        this.view = new ExibeUsuarioViewUser();

        configuraTela();

        view.setVisible(true);
    }

    @Override
    public void setState(PresenterState state) {
        this.state = state;
    }

    @Override
    public void configuraTela() {
        
    }

   

    public ExibeUsuarioViewUser getView() {
        return view;
    }

    @Override
    public ExibeUsuarioPresenterUser getPresenter() {
        return this;
   }
    
    
}
