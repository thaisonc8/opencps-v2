package org.opencps.jasper.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

import org.apache.commons.lang.Validate;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExpressionCollector;
import net.sf.jasperreports.engine.JRReport;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseObjectFactory;

public class JRReportTemplate extends JasperReport {

	
	private static final long serialVersionUID = 1L;

	public JRReportTemplate(JRReport report, String compilerClass, Serializable compileData,
			JRExpressionCollector expressionCollector, String compileNameSuffix) {
		super(report, compilerClass, compileData, expressionCollector, compileNameSuffix);

	}

	public JRReportTemplate(JRReport report, String compilerClass, Serializable compileData,
			JRBaseObjectFactory factory, String compileNameSuffix) {
		super(report, compilerClass, compileData, factory, compileNameSuffix);

	}

	public static JasperReport getJasperReport(String jrxmlTemplate) {
		InputStream isTemplate = null;
		JasperReport reportTemplate = null;
		try {

			isTemplate = new ByteArrayInputStream(jrxmlTemplate.getBytes(StandardCharsets.UTF_8));
			reportTemplate = JasperCompileManager.compileReport(isTemplate);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			try {
				if(isTemplate != null){
					isTemplate.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return reportTemplate;
	}

	public static JRReportTemplate getJRReportTemplate(String jrxmlTemplate) throws JRException, IOException {

		InputStream isTemplate = new ByteArrayInputStream(jrxmlTemplate.getBytes(StandardCharsets.UTF_8));
		JRReportTemplate reportTemplate = (JRReportTemplate) JasperCompileManager.compileReport(isTemplate);

		if (isTemplate != null) {
			isTemplate.close();
		}

		return reportTemplate;
	}
}