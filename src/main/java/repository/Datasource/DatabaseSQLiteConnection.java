/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.Datasource;

/**
 *
 * @author dougl
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSQLiteConnection {
    private static final String URL = "jdbc:sqlite:./src/main/java/repository/BANCO.db";
      
    private static Connection connection;

    private DatabaseSQLiteConnection() { }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(URL);
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException("Falha ao conectar com banco de dados", e.getCause());
            }
        }
        return connection;
    }
    public static void closerConnection() {
         try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("falha ao fechar conexao", e.getCause());
        }
    }
}

