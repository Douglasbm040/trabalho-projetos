/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presenter.LoginPresenter;
import state.user.PresenterStateUser;
import view.user.ExibeUsuarioViewUser;

/**
 *
 * @author isaac
 */
public class ExibeUsuarioPresenterUser implements IPresenterUser<ExibeUsuarioPresenterUser> {
    private ExibeUsuarioViewUser view;
    private PresenterStateUser state;

    public ExibeUsuarioPresenterUser() {
        this.view = new ExibeUsuarioViewUser();

        configuraTela();

        view.setVisible(true);
    }

    @Override
    public void setState(PresenterStateUser state) {
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
