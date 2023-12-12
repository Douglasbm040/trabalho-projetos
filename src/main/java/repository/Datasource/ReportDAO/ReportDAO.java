/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.Datasource.ReportDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.RelatorioUsuario;
import model.User;
import repository.Datasource.DatabaseSQLiteConnection;

/**
 *
 * @author dougl
 */
public class ReportDAO implements IReportDAO {

    private Connection connection;

    public ReportDAO() {
        this.connection = DatabaseSQLiteConnection.getConnection();
    }

    @Override
    public List<RelatorioUsuario> selectQtdNotificationSended(User userAdmin) {
        String sql = "SELECT\n"
                + "  USER.ID_USER,\n"
                + "  USER.REGISTER_DATE,\n"
                + "  USER.NAME,\n"
                + "  COUNT(NOTIFICATION.ID_NOTIFICATION) AS QTD_NOTIFICACOES_ENVIADAS,\n"
                + "  SUM(NOTIFICATION.IS_READ) AS QTD_NOTIFICACOES_LIDAS\n"
                + "FROM\n"
                + "  USER\n"
                + "  LEFT JOIN NOTIFICATION\n"
                + "  ON USER.ID_USER = NOTIFICATION.ID_USER_RECEIVER\n"
                + "WHERE\n"
                + "  NOTIFICATION.ID_USER_SENDER = ?\n"
                + "GROUP BY\n"
                + "  USER.ID_USER,\n"
                + "  USER.NAME, \n"
                + "  USER.REGISTER_DATE";

        List<RelatorioUsuario> listRel = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userAdmin.getId());  // Defina o valor do parâmetro antes de executar a consulta
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    listRel.add(new RelatorioUsuario(
                            resultSet.getInt("ID_USER"),
                            resultSet.getString("NAME"),
                            resultSet.getString("REGISTER_DATE"),
                            resultSet.getInt("QTD_NOTIFICACOES_ENVIADAS"),
                            resultSet.getInt("QTD_NOTIFICACOES_LIDAS")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listRel;
    }

}
