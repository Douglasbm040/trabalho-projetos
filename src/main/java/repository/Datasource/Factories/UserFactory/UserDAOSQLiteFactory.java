/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.Datasource.Factories.UserFactory;


import repository.Datasource.DAO.UserDAO.IUserDAO;
import repository.Datasource.DAO.UserDAO.UserDAOSQLite;

/**
 *
 * @author dougl
 */
public class UserDAOSQLiteFactory implements IStrategyFactoryUserDAODatabase{

    @Override
    public IUserDAO create() {
       return new UserDAOSQLite();
    }
    
}
