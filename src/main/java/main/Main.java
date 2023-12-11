/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;



import model.Notification;
import presenter.LoginPresenter;
import repository.Datasource.DAO.NotificationDAO.INotificationDAO;
import repository.Datasource.Factories.NotificationFactory.NotificationDAOSQLiteFactory;


/**
 *
 * @author dougl
 */
public class Main {
        
    public static void main(String[] args) {
        //User n = new User("Radyja ","asfAGSJDFGJAGS",2);
        Notification n3 = new Notification("ola mundo", "asd", 1);
        INotificationDAO notificationSQLite = new NotificationDAOSQLiteFactory().Create() ;
        //n2.deleteNotificationALL();
        //n2.insertNotification(n1);
        //n2.SelectNotificationALL();
        /*UserDAO A = new  UserDAO();
        A.insertUser(n);
        //A.updateUser(n, 1);
        //A.deleteUserALL();
        A.SelectUserALL(n);*/
        LoginPresenter lp = LoginPresenter.getInstance();
    }
   
}
