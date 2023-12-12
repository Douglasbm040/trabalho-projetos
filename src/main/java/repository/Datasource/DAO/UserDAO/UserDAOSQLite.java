/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.Datasource.DAO.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;
import repository.Datasource.DatabaseSQLiteConnection;

public class UserDAOSQLite implements IUserDAO {

    private Connection connection;

    public UserDAOSQLite() {
        this.connection = DatabaseSQLiteConnection.getConnection();
    }
    
    @Override
public int insertUser(User user) {
    int generatedId = 0;
    String sql = "INSERT INTO USER (NAME, TOKEN_ACCESS, TAG_ACCESS) VALUES (?, ?, ?)";

    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getTokenAccess());
        preparedStatement.setInt(3, user.getTagAccess());

        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Inserção bem-sucedida!");

            // Consulta para obter o último ID inserido
            String query = "SELECT last_insert_rowid() as id";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                if (resultSet.next()) {
                    generatedId = resultSet.getInt("id");
                    System.out.println("ID gerado: " + generatedId);
                } else {
                    System.out.println("Falha ao obter o ID gerado.");
                }
            }
        } else {
            System.out.println("Falha na inserção.");
        }

        return generatedId;
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return generatedId;
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
                    int tagAcess = resultSet.getInt("TAG_ACCESS");

                    user = new User(name, token, tagAcess);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    
    @Override
    public List<User> selectUserAll() {
        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM USER";

        // Preparar a instrução SQL
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            System.out.println("User ID: ");
            // Executar a consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            // Processar os resultados
            while (resultSet.next()) {
                users.add(new User(resultSet.getString("NAME"),resultSet.getString("TOKEN_ACCESS"),resultSet.getInt("TAG_ACCESS"),resultSet.getInt("ID_USER")));
            }
            System.out.println("User ID:  Token: " + resultSet.next());

        } catch (SQLException e) {
            System.out.println("asdasd");
            e.printStackTrace();

        }
        return users;
    }
    
    @Override
    public void updateUserTagAccess(String tagAccess, int userId) {
        String sql = "UPDATE USER SET NAME = ?, TAG_ACCESS = ? WHERE ID_USER = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, tagAccess);
            preparedStatement.setInt(2, userId);

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
