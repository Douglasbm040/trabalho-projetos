/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.Datasource.DAO.NotificationDAO;

import java.util.List;
import model.Notification;

/**
 *
 * @author dougl
 */
public interface INotificationDAO {
     public void insertNotification(Notification notification);
     public List<Notification> SelectNotificationALLUser(int userId);
     public List<Notification> SelectNotificationALLAdmin();
     public void updateNotification(Notification notification, int id);
     public void deleteNotificationALL();
     public void deleteNotification(Notification notification, int id);  
}
