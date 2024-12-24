package Model;

import java.util.HashMap;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.Connection;

/**
 *
 * Create a Object of this class and call viewReport Method
 * <li>Author Lochana2005</li>
 * <li>Copyright 2024</li>
 *
 * @author Lochana2005
 */
public class Jasper {

  
    public JasperPrint viewReport(String name, HashMap parameters, JTable table) throws Exception {
        this.rootPath += name;
        JRTableModelDataSource dataSource = new JRTableModelDataSource(table.getModel());
        JasperPrint jasperPrint = JasperFillManager.fillReport(Jasper.class.getResourceAsStream(this.rootPath), parameters, dataSource);
        JasperViewer.viewReport(jasperPrint, false);
        return jasperPrint;
    }

   
    public JasperPrint viewReport(String name, HashMap parameters, Connection connection) throws Exception {
        this.rootPath += name;
        JasperPrint jasperPrint = JasperFillManager.fillReport(Jasper.class.getResourceAsStream(this.rootPath), parameters, connection);
        JasperViewer.viewReport(jasperPrint, false);
        return jasperPrint;
    }

   
    public JasperPrint viewReport(String name, HashMap parameters) throws Exception {
        this.rootPath += name;
        JREmptyDataSource dataSource = new JREmptyDataSource();
        JasperPrint jasperPrint = JasperFillManager.fillReport(Jasper.class.getResourceAsStream(this.rootPath), parameters, dataSource);
        JasperViewer.viewReport(jasperPrint, false);
        return jasperPrint;
    }

   
    public JasperPrint viewReport(String name) throws Exception {
        this.rootPath += name;
        HashMap parameters = new HashMap();
        JREmptyDataSource dataSource = new JREmptyDataSource();
        JasperPrint jasperPrint = JasperFillManager.fillReport(Jasper.class.getResourceAsStream(this.rootPath), parameters, dataSource);
        JasperViewer.viewReport(jasperPrint, false);
        return jasperPrint;
    }

    
    public void exportReportPDF(JasperPrint jasperPrint, String fileName) throws Exception {
        JasperExportManager.exportReportToPdfFile(jasperPrint, fileName);
    }

   
    public void exportReportHTML(JasperPrint jasperPrint, String fileName) throws Exception {
        JasperExportManager.exportReportToHtmlFile(jasperPrint, fileName);
    }

    private String rootPath = "/Reports/";
}
