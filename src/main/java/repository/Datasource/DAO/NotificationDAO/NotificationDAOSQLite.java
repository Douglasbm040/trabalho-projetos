/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.Datasource.DAO.NotificationDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Notification;
import repository.Datasource.DatabaseSQLiteConnection;


/**
 *
 * @author dougl
 */
public class NotificationDAOSQLite implements INotificationDAO{
        private Connection connection;

    public NotificationDAOSQLite() {
        this.connection = DatabaseSQLiteConnection.getConnection();
    }

        @Override
    public void insertNotification(Notification notification) {
        String sql = "INSERT INTO NOTIFICATION (CONTENT, DATA_NOTIFICATION, ID_USER) VALUES (?, ?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, notification.getContent());
            preparedStatement.setString(2, notification.getDataEnvio());
            preparedStatement.setInt(3, notification.getIdReceptor());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Inserção bem-sucedida!");
            } else {
                System.out.println("Falha na inserção.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        @Override
      public List<Notification> SelectNotificationALLUser(int userId){
          List<Notification> listaNotification = new ArrayList<>();
            String sql = "SELECT NOTIFICATION.CONTENT ,NOTIFICATION.DATA_NOTIFICATION,NOTIFICATION.ID_USER FROM USER, NOTIFICATION WHERE NOTIFICATION.ID_USER = USER.ID_USER AND USER.ID_USER = ?";
            // Preparar a instrução SQL
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, userId); 
                // Executar a consulta
                ResultSet resultSet = preparedStatement.executeQuery();
                // Processar os resultados
                while (resultSet.next()) {
                    String content = resultSet.getString("CONTENT");
                    String dataEnvio = resultSet.getString("DATA_NOTIFICATION");
                    int idReceptor = resultSet.getInt("ID_USER");

                   
           listaNotification.add(new Notification(content, dataEnvio, idReceptor));
                }
                  System.out.println("User ID:  Token: "+ resultSet.next());
            
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return listaNotification;
    }
        @Override
      public List<Notification> SelectNotificationALLAdmin (){
          List<Notification> listaNotification = new ArrayList<>();
            String sql = "SELECT NOTIFICATION.CONTENT ,NOTIFICATION.DATA_NOTIFICATION,NOTIFICATION.ID_USER FROM USER, NOTIFICATION WHERE NOTIFICATION.ID_USER = USER.ID_USER AND TAG_ACCESS = 0";
            // Preparar a instrução SQL
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Executar a consulta
                ResultSet resultSet = preparedStatement.executeQuery();
                // Processar os resultados
                while (resultSet.next()) {
                    String content = resultSet.getString("CONTENT");
                    String dataEnvio = resultSet.getString("DATA_NOTIFICATION");
                    int idReceptor = resultSet.getInt("ID_USER");

                   
           listaNotification.add(new Notification(content, dataEnvio, idReceptor));
                }
                  System.out.println("User ID:  Token: "+ resultSet.next());
            
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return listaNotification;
    } 
      @Override
   public void updateNotification(Notification notification) {
        String sql = "UPDATE NOTIFICATION SET CONTENT = ?, DATE_ENVIO = ? WHERE ID_NOTIFICATION = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, notification.getContent());
            //preparedStatement.setString(2, notification.getDataEnvio());
            preparedStatement.setInt(3, notification.getIdReceptor());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Atualização bem-sucedida!");
            } else {
                System.out.println("Falha na atualização. Usuário não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
          public void deleteNotificationALL() {
        String sql = "DELETE FROM NOTIFICATION";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
           

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Exclusão bem-sucedida!");
            } else {
                System.out.println("Falha na exclusão. Usuário não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
                  @Override
       public void deleteNotification(Notification notification) {
        String sql = "DELETE FROM NOTIFICATION WHERE ID_USER = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, notification.getIdReceptor());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Exclusão bem-sucedida!");
            } else {
                System.out.println("Falha na exclusão. Usuário não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
