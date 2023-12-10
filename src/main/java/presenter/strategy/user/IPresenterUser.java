/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package presenter.strategy.user;

import state.user.PresenterStateUser;

/**
 *
 * @author isaac
 */
public interface IPresenterUser<T> {
    void setState(PresenterStateUser state);
    void configuraTela();
    T getPresenter();


}