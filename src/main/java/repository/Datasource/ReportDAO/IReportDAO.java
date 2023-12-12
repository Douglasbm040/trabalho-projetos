/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.Datasource.ReportDAO;

import java.util.List;
import model.RelatorioUsuario;
import model.User;

/**
 *
 * @author dougl
 */
public interface IReportDAO {
    public List<RelatorioUsuario> selectQtdNotificationSended(User userAdmin);
}
