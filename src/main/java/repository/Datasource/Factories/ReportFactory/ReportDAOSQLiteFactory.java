/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.Datasource.Factories.ReportFactory;

import repository.Datasource.ReportDAO.IReportDAO;
import repository.Datasource.ReportDAO.ReportDAO;

/**
 *
 * @author dougl
 */
public class ReportDAOSQLiteFactory implements IStrategyFactoryReportDAO{

    @Override
    public IReportDAO create() {
        return new ReportDAO();
    }
    
}
