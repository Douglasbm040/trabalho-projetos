/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.douglasbm04.trabalho_de_projetos;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Notification;
import repository.Datasource.DAO.NotificationDAO.UserDAO.UserDAO;
import java.util.Date;
import model.User;
import repository.Datasource.NotificationDAO;


/**
 *
 * @author dougl
 */
public class Trabalho_de_projetos {
        
    public static void main(String[] args) {
        //User n = new User("Radyja ","asfAGSJDFGJAGS",2);
        Notification n3 = new Notification("ola mundo", "asd", 1);
        NotificationDAO n2 = new NotificationDAO();
        //n2.deleteNotificationALL();
        //n2.insertNotification(n1);
        n2.SelectNotificationALL();
        /*UserDAO A = new  UserDAO();
        A.insertUser(n);
        //A.updateUser(n, 1);
        //A.deleteUserALL();
        A.SelectUserALL(n);*/
    }
   
}
