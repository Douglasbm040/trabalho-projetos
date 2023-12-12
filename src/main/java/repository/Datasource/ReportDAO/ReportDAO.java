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
                + "    U.ID_USER,\n"
                + "    U.NAME,\n"
                + "    U.REGISTER_DATE,\n"
                + "    COUNT(N.ID_NOTIFICATION) AS QTD_NOTIFICACOES_ENVIADAS,\n"
                + "    COALESCE(SUM(N.IS_READ), 0) AS QTD_NOTIFICACOES_LIDAS\n"
                + "FROM\n"
                + "    USER U\n"
                + "    LEFT JOIN NOTIFICATION N \n"
                + "    ON U.ID_USER = N.ID_USER_RECEIVER AND N.ID_USER_SENDER = ?\n"
                + "WHERE\n"
                + "    U.TAG_ACCESS = 2\n"
                + "GROUP BY\n"
                + "    U.ID_USER,\n"
                + "    U.NAME,\n"
                + "    U.REGISTER_DATE;";

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
