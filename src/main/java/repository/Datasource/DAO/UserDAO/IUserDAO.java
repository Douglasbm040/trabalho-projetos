/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.Datasource.DAO.UserDAO;

import java.util.List;
import model.User;

/**
 *
 * @author dougl
 */
public interface IUserDAO {

    public int insertUser(User user);
    
    public User selectById(int userId);
    
    public User selectByName(String userName);
    
    public List<User> selectUserAll();
    
    public List<User> selectUserAllTypeUser();
    
    public User selectAdmin();
    
    public void updateUserById(User user);
    
    public void  updateUserTagAccess(int tagAccess, int userId);

    public void deleteUser(int userId);
    
    public void deleteUserAll();
}
