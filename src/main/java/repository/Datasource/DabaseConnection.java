/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.Datasource;

import java.sql.Connection;

/**
 *
 * @author dougl
 */
public abstract class DabaseConnection {
    
    private static final String URL = "jdbc:sqlite:./src/main/java/repository/BANCO.db";
      
    private static Connection connection;
}
