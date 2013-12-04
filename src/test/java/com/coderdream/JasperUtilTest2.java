package com.coderdream;

import junit.framework.TestCase;

public class JasperUtilTest2 extends TestCase {

	private static String fileName = "fonts";

	protected void setUp() throws Exception {
		super.setUp();
	}

	public static void testHTMLDecoder() {
		System.out.println(HTMLDecoder.decode("&#20013;&#22269;"));
	}

	public static void testCompileJrxmlToJasper() {
		try {
			JasperUtil2.compileJrxmlToJasper(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testFillJasperToJrprint() {
		try {
			JasperUtil2.fillJasperToJrprint(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportToPdf() {
		try {
			JasperUtil2.exportToPdf(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportToExcel() {
		try {
			JasperUtil2.exportJrprintToExcel(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportToXml() {
		try {
			JasperUtil2.exportJrprintToXml(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportJrxmlToPdf() {
		try {
			JasperUtil2.exportJrxmlToPdf(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportJrxmlToExcel() {
		try {
			JasperUtil2.exportJrxmlToExcel(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExportJrxmlToXml() {
		try {
			JasperUtil2.exportJrxmlToXml(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testViewInFrameByJrxml() {
		try {
			JasperUtil2.viewInFrameByJrxml(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}