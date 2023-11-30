/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.Datasource.DAO.NotificationDAO.UserDAO;

import model.User;

/**
 *
 * @author dougl
 */
public interface IUserDAO {
    public void insertUser(User user);
     public void SelectUserALL(User user);
     public void updateUser(User user, int id_User);
      public void deleteUser(int userId);
}
