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
 * <li>Author Buddhi7770</li>
 * <li>Copyright 2024</li>
 *
 * @author Buddhi7770
 */
public class Jasper {

    /**
     *
     * @param name Name of the jasperReport Created in Reports Folder in your
     * project
     * @param parameters HashMap of Parameters
     * @param table Table of DataSource
     * @return jasperPrint
     * @throws java.lang.Exception
     */
    public JasperPrint viewReport(String name, HashMap parameters, JTable table) throws Exception {
        this.rootPath += name;
        JRTableModelDataSource dataSource = new JRTableModelDataSource(table.getModel());
        JasperPrint jasperPrint = JasperFillManager.fillReport(Jasper.class.getResourceAsStream(this.rootPath), parameters, dataSource);
        JasperViewer.viewReport(jasperPrint, false);
        return jasperPrint;
    }

    /**
     *
     * @param name Name of the jasperReport Created in Reports Folder in your
     * project
     * @param parameters HashMap of Parameters
     * @param connection MySQL Database connection
     * @return jasperPrint
     * @throws java.lang.Exception
     */
    public JasperPrint viewReport(String name, HashMap parameters, Connection connection) throws Exception {
        this.rootPath += name;
        JasperPrint jasperPrint = JasperFillManager.fillReport(Jasper.class.getResourceAsStream(this.rootPath), parameters, connection);
        JasperViewer.viewReport(jasperPrint, false);
        return jasperPrint;
    }

    /**
     *
     * A EmptyDatasource will be generated
     *
     * @param name Name of the jasperReport Created in Reports Folder in your
     * project
     * @param parameters HashMap of Parameters
     * @return jasperPrint
     * @throws java.lang.Exception
     */
    public JasperPrint viewReport(String name, HashMap parameters) throws Exception {
        this.rootPath += name;
        JREmptyDataSource dataSource = new JREmptyDataSource();
        JasperPrint jasperPrint = JasperFillManager.fillReport(Jasper.class.getResourceAsStream(this.rootPath), parameters, dataSource);
        JasperViewer.viewReport(jasperPrint, false);
        return jasperPrint;
    }

    /**
     * A Empty HashMap and EmptyDataSoucre will be generated
     *
     * @param name Name of the jasperReport Created in Reports Folder in your
     * project
     * @return jasperPrint
     * @throws java.lang.Exception
     */
    public JasperPrint viewReport(String name) throws Exception {
        this.rootPath += name;
        HashMap parameters = new HashMap();
        JREmptyDataSource dataSource = new JREmptyDataSource();
        JasperPrint jasperPrint = JasperFillManager.fillReport(Jasper.class.getResourceAsStream(this.rootPath), parameters, dataSource);
        JasperViewer.viewReport(jasperPrint, false);
        return jasperPrint;
    }

    /**
     * A JasperPrint returned by viewReport
     *
     * @param jasperPrint JasperPrint to Export as PDF
     * @param fileName FileName of the PDF
     * @throws java.lang.Exception
     */
    public void exportReportPDF(JasperPrint jasperPrint, String fileName) throws Exception {
        JasperExportManager.exportReportToPdfFile(jasperPrint, fileName);
    }

    /**
     * A JasperPrint returned by viewReport
     *
     * @param jasperPrint JasperPrint to Export as HTML
     * @param fileName Filename of the HTML
     * @throws java.lang.Exception
     */
    public void exportReportHTML(JasperPrint jasperPrint, String fileName) throws Exception {
        JasperExportManager.exportReportToHtmlFile(jasperPrint, fileName);
    }

    private String rootPath = "/Reports/";
}
