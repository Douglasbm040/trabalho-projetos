/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.Datasource.Factories.UserFactory;

import repository.Datasource.DAO.NotificationDAO.UserDAO.IUserDAO;
import repository.Datasource.DAO.NotificationDAO.UserDAO.UserDAOSQLite;

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
