/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.Datasource.Factories.UserFactory;


import repository.Datasource.DAO.UserDAO.IUserDAO;

/**
 *
 * @author dougl
 */
public interface IStrategyFactoryUserDAODatabase {
    IUserDAO create();
}
