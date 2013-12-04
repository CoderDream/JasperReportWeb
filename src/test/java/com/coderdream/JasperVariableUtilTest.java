package com.coderdream;

import junit.framework.TestCase;

public class JasperVariableUtilTest extends TestCase {

	private static String jrxmlFileName = "simpleVariable.jrxml";
	private static String jasperFileName = "simpleVariable.jasper";
	private static String jrprintFileName = "simpleVariable.jrprint";
	private static String pdfFileName = "simpleVariable.pdf";
	private static String excelFileName = "simpleVariable.xls";
	private static String xmlFileName = "simpleVariable.xml";

	protected void setUp() throws Exception {
		super.setUp();
	}

	public static void testCompileJrxmlToJasper() {
		try {
			JasperVariableUtil.compileJrxmlToJasper(jrxmlFileName, jasperFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testFillJasperToJrprint() {
		try {
			JasperVariableUtil.fillJasperToJrprint(jasperFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportToPdf() {
		try {
			JasperVariableUtil.exportToPdf(jrprintFileName, pdfFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportToExcel() {
		try {
			JasperVariableUtil.exportToExcel(jrprintFileName, excelFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportToXml() {
		try {
			JasperVariableUtil.exportToXml(jrprintFileName, xmlFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportJrxmlToPdf() {
		try {
			JasperVariableUtil.exportJrxmlToPdf(jrxmlFileName, pdfFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportJrxmlToExcel() {
		try {
			JasperVariableUtil.exportJrxmlToExcel(jrxmlFileName, excelFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportJrxmlToXml() {
		try {
			JasperVariableUtil.exportJrxmlToXml(jrxmlFileName, xmlFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testViewInFrameByJrxml() {
		try {
			JasperVariableUtil.viewInFrameByJrxml(jrxmlFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}