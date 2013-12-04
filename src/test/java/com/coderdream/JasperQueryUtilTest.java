package com.coderdream;

import junit.framework.TestCase;

public class JasperQueryUtilTest extends TestCase {

	private static String jrxmlFileName = "simpleQuery.jrxml";
	private static String jasperFileName = "simpleQuery.jasper";
	private static String jrprintFileName = "simpleQuery.jrprint";
	private static String pdfFileName = "simpleQuery.pdf";
	private static String excelFileName = "simpleQuery.xls";
	private static String xmlFileName = "simpleQuery.xml";

	protected void setUp() throws Exception {
		super.setUp();
	}

	public static void testCompileJrxmlToJasper() {
		try {
			JasperQueryUtil.compileJrxmlToJasper(jrxmlFileName, jasperFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testFillJasperToJrprint() {
		try {
			JasperQueryUtil.fillJasperToJrprint(jasperFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportToPdf() {
		try {
			JasperQueryUtil.exportToPdf(jrprintFileName, pdfFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportToExcel() {
		try {
			JasperQueryUtil.exportToExcel(jrprintFileName, excelFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportToXml() {
		try {
			JasperQueryUtil.exportToXml(jrprintFileName, xmlFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportJrxmlToPdf() {
		try {
			JasperQueryUtil.exportJrxmlToPdf(jrxmlFileName, pdfFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportJrxmlToExcel() {
		try {
			JasperQueryUtil.exportJrxmlToExcel(jrxmlFileName, excelFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportJrxmlToXml() {
		try {
			JasperQueryUtil.exportJrxmlToXml(jrxmlFileName, xmlFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testViewInFrameByJrxml() {
		try {
			JasperQueryUtil.viewInFrameByJrxml(jrxmlFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}