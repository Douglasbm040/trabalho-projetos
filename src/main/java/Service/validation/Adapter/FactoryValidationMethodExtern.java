/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.validation.Adapter;

/**
 *
 * @author dougl
 */
public class FactoryValidationMethodExtern implements IFactoryValidation{

    @Override
    public ValidationAdapter Create() {
        return new Validation();
    }
    
}
