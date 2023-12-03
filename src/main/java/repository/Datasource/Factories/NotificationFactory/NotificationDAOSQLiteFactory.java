/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.Datasource.Factories.NotificationFactory;

import repository.Datasource.DAO.NotificationDAO.INotificationDAO;
import repository.Datasource.DAO.NotificationDAO.NotificationDAOSQLite;
/**
 *
 * @author dougl
 */
public class NotificationDAOSQLiteFactory implements IStrategyFactoryNotificationDAODatabase {
    @Override
    public INotificationDAO Create() {
        return new NotificationDAOSQLite();
    }
    
}
