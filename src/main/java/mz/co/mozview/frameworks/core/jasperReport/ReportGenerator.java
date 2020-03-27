/**
 * 
 */
package mz.co.mozview.frameworks.core.jasperReport;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

/**
 * @author St�lio Moiane
 * 
 */
@SuppressWarnings("deprecation")
public class ReportGenerator {

	public static void compileJRxml(final String fileName) throws JRException {
		JasperCompileManager.compileReportToFile(fileName);
	}

	public static void pdfFillReportBeans(final String jasperFile,
			final Map<String, Object> params,
			final Collection<? extends Object> beans, final String reportName)
					throws JRException, FileNotFoundException {

		JasperPrint fillReport = JasperFillManager.fillReport(jasperFile,
				params, new JRBeanCollectionDataSource(beans));

		JRPdfExporter pdfExporter = new JRPdfExporter();

		pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, fillReport);
		pdfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
				new FileOutputStream(reportName + ".pdf"));

		pdfExporter.exportReport();
	}
}
