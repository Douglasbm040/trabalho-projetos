/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.validation.Adapter;
import com.pss.senha.validacao.ValidadorSenha;
import java.util.List;

/**
 *
 * @author dougl
 */

public class Validation implements ValidationAdapter {
    final ValidadorSenha validador = new ValidadorSenha();

    @Override
    public List<String> validar(String senha) {
       return validador.validar(senha);
    }
    
    
}
