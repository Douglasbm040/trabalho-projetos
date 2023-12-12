package repository.Datasource.DAO.NotificationDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Notification;
import repository.Datasource.DatabaseSQLiteConnection;

public class NotificationDAOSQLite implements INotificationDAO {
    private Connection connection;

    public NotificationDAOSQLite() {
        this.connection = DatabaseSQLiteConnection.getConnection();
    }

    @Override
    public void insertNotification(Notification notification) {
        String sql = "INSERT INTO NOTIFICATION (CONTENT, DATA_NOTIFICATION, ID_USER_SENDER, ID_USER_RECEIVER, IS_READ) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, notification.getContent());
            preparedStatement.setString(2, notification.getDataEnvio());
            preparedStatement.setInt(3, notification.getIdSender());
            preparedStatement.setInt(4, notification.getIdReceptor());
            preparedStatement.setInt(5, notification.getIsRead());

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
    public List<Notification> SelectNotificationALLUser(int userId) {
        List<Notification> listaNotification = new ArrayList<>();
        String sql = "SELECT * FROM NOTIFICATION WHERE ID_USER_RECEIVER = ?";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idNotification = resultSet.getInt("ID_NOTIFICATION");
                String content = resultSet.getString("CONTENT");
                String dataEnvio = resultSet.getString("DATA_NOTIFICATION");
                int idSender = resultSet.getInt("ID_USER_SENDER");
                int idReceptor = resultSet.getInt("ID_USER_RECEIVER");
                int isRead = resultSet.getInt("IS_READ");

                listaNotification.add(new Notification(content, dataEnvio, idSender, idReceptor, isRead,idNotification));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaNotification;
    }

    @Override
    public List<Notification> SelectNotificationALLAdmin() {
        List<Notification> listaNotification = new ArrayList<>();
        String sql = "SELECT * FROM NOTIFICATION WHERE ID_USER_RECEIVER IN (SELECT ID_USER FROM USER WHERE TAG_ACCESS = 1)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idNotification = resultSet.getInt("ID_NOTIFICATION");
                String content = resultSet.getString("CONTENT");
                String dataEnvio = resultSet.getString("DATA_NOTIFICATION");
                int idSender = resultSet.getInt("ID_USER_SENDER");
                int idReceptor = resultSet.getInt("ID_USER_RECEIVER");
                int isRead = resultSet.getInt("IS_READ");

                listaNotification.add(new Notification(content, dataEnvio, idSender, idReceptor, isRead,idNotification));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaNotification;
    }

    @Override
    public void updateNotification(Notification notification, int id) {
        String sql = "UPDATE NOTIFICATION SET CONTENT = ?, DATA_NOTIFICATION = ?, IS_READ = ? WHERE ID_NOTIFICATION = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, notification.getContent());
            preparedStatement.setString(2, notification.getDataEnvio());
            preparedStatement.setInt(3, notification.getIsRead());
            preparedStatement.setInt(4, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Atualização bem-sucedida!");
            } else {
                System.out.println("Falha na atualização. Notificação não encontrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteNotificationALL() {
        String sql = "DELETE FROM NOTIFICATION";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Exclusão bem-sucedida!");
            } else {
                System.out.println("Falha na exclusão. Notificação não encontrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteNotification(int id) {
        String sql = "DELETE FROM NOTIFICATION WHERE ID_NOTIFICATION = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Exclusão bem-sucedida!");
            } else {
                System.out.println("Falha na exclusão. Notificação não encontrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}