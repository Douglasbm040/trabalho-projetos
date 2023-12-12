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
     public List<Notification> SelectNotificationALL();
     public void updateNotification(Notification notification);
     public void deleteNotification(Notification notification);  
}
