/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state;

import presenter.strategy.IPresenterUser;
import presenter.strategy.PrincipalPresenterUser;

/**
 *
 * @author isaac
 */
public class ExibeUsuarioPresenterState extends PresenterState {

    public ExibeUsuarioPresenterState(IPresenterUser presenter) {
        super(presenter);
    }
    
    @Override
    public void fechar() {
        presenter.setState(new InicialPresenterState(new PrincipalPresenterUser()));
    }
    
}
