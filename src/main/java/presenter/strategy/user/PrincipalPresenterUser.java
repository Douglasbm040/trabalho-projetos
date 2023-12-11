/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.user;

import Service.observer.IObserver;
import Service.observer.Observable;
import Service.observer.UserObservable;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.User;
import presenter.LoginPresenter;
import state.user.InicialPresenterStateUser;
import state.user.PresenterStateUser;
import view.user.ExibeUsuarioViewUser;
import view.user.PrincipalViewUser;

/**
 *
 * @author isaac
 */
public class PrincipalPresenterUser extends IPresenterUser implements IObserver<User> {

    private static PrincipalPresenterUser instance;

    private PrincipalViewUser view;
    private PresenterStateUser state;
    private User userState;

    private PrincipalPresenterUser() {
        this.view = new PrincipalViewUser();
        this.state = new InicialPresenterStateUser(this);
        configuraTela();
    }

    public static PrincipalPresenterUser getInstance() {
        if (instance == null) {
            instance = new PrincipalPresenterUser();
        }
        return instance;
    }

    @Override
    public void setState(PresenterStateUser state) {
        this.state = state;
    }

    @Override
    public void configuraTela() {
        view.setExtendedState(MAXIMIZED_BOTH);
        view.getMenuSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                LoginPresenter.getInstance();
            }
        });
        view.getMenuUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.manterUsuarios();
                Observable observable = new UserObservable();
                observable.notifyObserver(userState);  
            }

        });
        view.getBtnNotificacao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.verNotificacoes();
            }
        });
        if (userState != null) {
            view.getLblTipoUsuarioRodape().setText("Tipo: User");
            view.getLblUsuarioRodape().setText("Usuário :"+ userState.getName());
        }
        view.setVisible(true);
    }

    public User getUserState() {
        return userState;
    }

    public void setUserState(User userState) {
        this.userState = userState;
    }

    public PrincipalViewUser getViewPrin() {
        return view;
    }

    @Override
    public void update(User obsersable) {
        setUserState(obsersable);
        configuraTela();
    }

}
