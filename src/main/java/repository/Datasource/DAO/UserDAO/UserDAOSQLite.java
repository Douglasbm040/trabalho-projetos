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
        String sql = "INSERT INTO USER (NAME, TOKEN_ACCESS, TAG_ACCESS, REGISTER_DATE) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getTokenAccess());
            preparedStatement.setInt(3, user.getTagAccess());
            preparedStatement.setString(4, user.getRegisterDate());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Inserção bem-sucedida!");

                // Consulta para obter o último ID inserido
                String query = "SELECT last_insert_rowid() as id";
                try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
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
            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("NAME");
                    String token = resultSet.getString("TOKEN_ACCESS");
                    int tagAccess = resultSet.getInt("TAG_ACCESS");
                    String registerDate = resultSet.getString("REGISTER_DATE");

                    user = new User(name, token, tagAccess, registerDate);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User selectByName(String userName) {
        String sql = "SELECT * FROM USER WHERE NAME = ?";
        User user = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, userName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("NAME");
                    String token = resultSet.getString("TOKEN_ACCESS");
                    int tagAccess = resultSet.getInt("TAG_ACCESS");
                    String registerDate = resultSet.getString("REGISTER_DATE");

                    user = new User(name, token, tagAccess, registerDate);
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

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getString("NAME"),
                        resultSet.getString("TOKEN_ACCESS"),
                        resultSet.getInt("TAG_ACCESS"),
                        resultSet.getInt("ID_USER"),
                        resultSet.getString("REGISTER_DATE")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User selectAdmin() {
        String sql = "SELECT * FROM USER WHERE TAG_ACCESS = 1";
        User userAdmin = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {
            userAdmin = new User(
                    resultSet.getString("NAME"),
                    resultSet.getString("TOKEN_ACCESS"),
                    resultSet.getInt("TAG_ACCESS"),
                    resultSet.getInt("ID_USER"),
                    resultSet.getString("REGISTER_DATE")
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userAdmin;
    }

    @Override
    public List<User> selectUserAllTypeUser() {
        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM USER WHERE TAG_ACCESS = 2";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getString("NAME"),
                        resultSet.getString("TOKEN_ACCESS"),
                        resultSet.getInt("TAG_ACCESS"),
                        resultSet.getInt("ID_USER"),
                        resultSet.getString("REGISTER_DATE")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public void updateUserById(User user) {
        if (user == null || user.getName() == null || user.getTokenAccess() == null) {
            System.out.println("Falha na atualização. Usuário ou dados inválidos.");
            return;
        }

        String sql = "UPDATE USER SET NAME = ?, TOKEN_ACCESS = ? WHERE ID_USER = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getTokenAccess());
            preparedStatement.setInt(3, user.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Atualização bem-sucedida!");
            } else {
                System.out.println("Falha na atualização. Nenhum usuário encontrado com ID: " + user.getId());
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a atualização: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserTagAccess(int tagAccess, int userId) {
        String sql = "UPDATE USER SET TAG_ACCESS = ? WHERE ID_USER = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(2, userId);
            preparedStatement.setInt(1, tagAccess);

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
