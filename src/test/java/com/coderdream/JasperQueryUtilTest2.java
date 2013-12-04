package com.coderdream;

import junit.framework.TestCase;

public class JasperQueryUtilTest2 extends TestCase {
	private static String jrxmlFileName = "reportTest.jrxml";
	private static String jasperFileName = "reportTest.jasper";
	private static String jrprintFileName = "reportTest.jrprint";
	private static String pdfFileName = "reportTest.pdf";
	private static String excelFileName = "reportTest.xls";
	private static String xmlFileName = "reportTest.xml";

	protected void setUp() throws Exception {
		super.setUp();
	}

	public static void testCompileJrxmlToJasper() {
		try {
			JasperQueryUtil2.compileJrxmlToJasper(jrxmlFileName, jasperFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testFillJasperToJrprint() {
		try {
			JasperQueryUtil2.fillJasperToJrprint(jasperFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportToPdf() {
		try {
			JasperQueryUtil2.exportToPdf(jrprintFileName, pdfFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportToExcel() {
		try {
			JasperQueryUtil2.exportToExcel(jrprintFileName, excelFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportToXml() {
		try {
			JasperQueryUtil2.exportToXml(jrprintFileName, xmlFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportJrxmlToPdf() {
		try {
			JasperQueryUtil2.exportJrxmlToPdf(jrxmlFileName, pdfFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportJrxmlToExcel() {
		try {
			JasperQueryUtil2.exportJrxmlToExcel(jrxmlFileName, excelFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportJrxmlToXml() {
		try {
			JasperQueryUtil2.exportJrxmlToXml(jrxmlFileName, xmlFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testViewInFrameByJrxml() {
		try {
			JasperQueryUtil2.viewInFrameByJrxml(jrxmlFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}