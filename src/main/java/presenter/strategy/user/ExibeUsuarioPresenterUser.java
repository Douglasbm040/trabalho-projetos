/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.user;

import Service.observer.IObserver;
import Service.observer.Observable;
import Service.observer.UserObservable;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.User;
import presenter.LoginPresenter;
import state.user.ExibeUsuarioPresenterStateUser;
import state.user.PresenterStateUser;
import view.user.ExibeUsuarioViewUser;

/**
 *
 * @author isaac
 */
public class ExibeUsuarioPresenterUser extends IPresenterUser implements IObserver<User> {

    private ExibeUsuarioViewUser view;
    private PresenterStateUser state;

    private User userState;

    public ExibeUsuarioPresenterUser() {
        this.view = new ExibeUsuarioViewUser();
        this.state = new ExibeUsuarioPresenterStateUser(this);
        view.setVisible(true);
    }

    @Override
    public void setState(PresenterStateUser state) {
        this.state = state;
    }

    @Override
    public void configuraTela() {
        view.getBtnFechar().addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Observable observable = new UserObservable();
                observable.notifyObserver(userState); 
                state.fechar();
            }

        });
        if(getUserState() != null){
            view.getTxtUsuario().setText(getUserState().getTokenAccess()); //verifica se ta invertido usurio e senha no front
            view.getTxtSenha().setText(getUserState().getName()); 
        }
    }

    @Override
    public javax.swing.JInternalFrame getView() {
        return view;
    }

    public User getUserState() {
        return userState;
    }

    public void setUserState(User userState) {
        this.userState = userState;
    }

    @Override
    public void update(User obsersable) {
        System.out.println(obsersable.getName());
        System.out.println(obsersable.getTokenAccess());
        setUserState(obsersable);
        configuraTela();
    }

}
