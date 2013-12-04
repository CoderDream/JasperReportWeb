package com.coderdream;

import junit.framework.TestCase;

public class JasperVoListUtilTest extends TestCase {

	private static String jrxmlFileName = "voList.jrxml";
	private static String jasperFileName = "voList.jasper";
	private static String jrprintFileName = "voList.jrprint";
	private static String pdfFileName = "voList.pdf";
	private static String excelFileName = "voList.xls";
	private static String xmlFileName = "voList.xml";

	protected void setUp() throws Exception {
		super.setUp();
	}

	public static void testCompileJrxmlToJasper() {
		try {
			JasperVoListUtil.compileJrxmlToJasper(jrxmlFileName, jasperFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testFillJasperToJrprint() {
		try {
			JasperVoListUtil.fillJasperToJrprint(jasperFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportToPdf() {
		try {
			JasperVoListUtil.exportToPdf(jrprintFileName, pdfFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportToExcel() {
		try {
			JasperVoListUtil.exportToExcel(jrprintFileName, excelFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportToXml() {
		try {
			JasperVoListUtil.exportToXml(jrprintFileName, xmlFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportJrxmlToPdf() {
		try {
			JasperVoListUtil.exportJrxmlToPdf(jrxmlFileName, pdfFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportJrxmlToExcel() {
		try {
			JasperVoListUtil.exportJrxmlToExcel(jrxmlFileName, excelFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportJrxmlToXml() {
		try {
			JasperVoListUtil.exportJrxmlToXml(jrxmlFileName, xmlFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testViewInFrameByJrxml() {
		try {
			JasperVoListUtil.viewInFrameByJrxml(jrxmlFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}