/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter.strategy.admin;

import state.admin.PresenterStateAdmin;

/**
 *
 * @author isaac
 */
public interface IPresenterAdmin<T> {
    void setState(PresenterStateAdmin state);
    void configuraTela();
    T getPresenter();
}
