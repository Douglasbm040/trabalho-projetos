/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.Datasource.DAO.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import repository.Datasource.DAO.NotificationDAO.UserDAO.IUserDAO;
import repository.Datasource.DatabaseSQLiteConnection;

public class UserDAOSQLite implements IUserDAO {

    private Connection connection;

    public UserDAOSQLite() {
        this.connection = DatabaseSQLiteConnection.getConnection();
    }
    
    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO USER (NAME, TOKEN_ACCESS, TAG_ACCESS) VALUES (?, ?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getTokenAccess());
            preparedStatement.setInt(3, user.getTagAccess());

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
    public User selectById(int userId) {
        String sql = "SELECT * FROM USER WHERE ID_USER = ?";
        User user = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId); // Definir o valor do parâmetro

            // Executar a consulta
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Processar os resultados
                if (resultSet.next()) {
                    String name = resultSet.getString("NAME");
                    String token = resultSet.getString("TOKEN_ACCESS");
                    int tagAcess = resultSet.getInt("TAG_ACESS");

                    user = new User(name, token, tagAcess);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    
    @Override
    public void selectUserAll(User user) {

        String sql = "SELECT * FROM USER";

        // Preparar a instrução SQL
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            System.out.println("User ID: ");
            // Executar a consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            // Processar os resultados
            while (resultSet.next()) {
                int userId = resultSet.getInt("ID_USER");
                String name = resultSet.getString("NAME");
                String token = resultSet.getString("TOKEN_ACCESS");

                // Exibir os resultados (você pode fazer o que quiser com esses dados)
                System.out.println("User ID: " + userId + ", Name: " + name + ", Token: " + token);
            }
            System.out.println("User ID:  Token: " + resultSet.next());

        } catch (SQLException e) {
            System.out.println("asdasd");
            e.printStackTrace();

        }
    }
    
    @Override
    public void updateUser(User user, int userId) {
        String sql = "UPDATE USER SET NAME = ?, TOKEN_ACCESS = ? WHERE ID_USER = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getTokenAccess());
            preparedStatement.setInt(3, userId);

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
    
    @Override
    public void deleteUserAll() {
        String sql = "DELETE FROM USER";

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
    public void deleteUser(int userId) {
        String sql = "DELETE FROM USER WHERE ID_USER = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId);

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
