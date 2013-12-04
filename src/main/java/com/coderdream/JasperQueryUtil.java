package com.coderdream;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

public class JasperQueryUtil {

	public static String URL;

	public static Map<String, Object> PARAMS = new HashMap<String, Object>();

	// 定义用于获取数据库连接的方法
	private static Connection CONN;

	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String CONNECT_URL = "jdbc:mysql://localhost/javaee";
	private static String USERNAME = "root";
	private static String PASSWORD = "1234";

	static {
		URL = JasperQueryUtil.class.getClassLoader().getResource("").getPath() + "reports/";

		PARAMS.put("id", 1);
		// 加载驱动
		try {
			Class.forName(DRIVER);
			// 获得数据库连接
			CONN = DriverManager.getConnection(CONNECT_URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 编译static.jrxml报表设计文件，生成一个static.jasper报表文件
	 * 
	 * @param jrxmlFileName
	 * @param jasperFileName
	 * @throws Exception
	 */
	public static void compileJrxmlToJasper(String jrxmlFileName, String jasperFileName) throws Exception {
		JasperCompileManager.compileReportToFile(URL + jrxmlFileName, URL + jasperFileName);
		System.out.println("成功编译成JasperReport文件(*.jasper)");
	}

	/**
	 * 填充时，即使没有使用数据源，也必须指定一个新建的JREmptyDataSource实例，而不能直接使用null
	 * 
	 * @param jasperFileName
	 * @param jrprintFileName
	 * @throws Exception
	 */
	public static void fillJasperToJrprint(String jasperFileName) throws Exception {
		// 填充时，直接指定一个Connection作为数据库连接
		JasperFillManager.fillReportToFile(URL + jasperFileName, PARAMS, CONN);
		System.out.println("成功填充了一个报表文件(*.jrprint)");
	}

	/**
	 * 使用JasperExportManager将一个JasperPrint导出成PDF文档
	 * 
	 * @param jrprintFileName
	 * @param pdfFileName
	 * @throws Exception
	 */
	public static void exportToPdf(String jrprintFileName, String pdfFileName) throws Exception {
		JasperExportManager.exportReportToPdfFile(URL + jrprintFileName, URL + pdfFileName);
		System.out.println("成功创建了一个PDF文档");
	}

	/**
	 * @param jrxmlFileName
	 * @param pdfFileName
	 * @throws Exception
	 */
	public static void exportJrxmlToPdf(String jrxmlFileName, String pdfFileName) throws Exception {

		String tempJasperFileName = getJasperFileName(jrxmlFileName);
		String tempJrprintFileName = getJrprintFileName(jrxmlFileName);

		// 编译static.jrxml报表设计文件，生成一个static.jasper报表文件
		JasperCompileManager.compileReportToFile(URL + jrxmlFileName, URL + tempJasperFileName);
		// 编译static.jasper报表设计文件，生成一个static.jrprint报表文件
		// 填充时，直接指定一个Connection作为数据库连接
		JasperFillManager.fillReportToFile(URL + tempJasperFileName, PARAMS, CONN);

		// 使用JasperExportManager将一个JasperPrint导出成PDF文档
		JasperExportManager.exportReportToPdfFile(URL + tempJrprintFileName, URL + pdfFileName);
		System.out.println("成功创建了一个PDF文档");
	}

	/**
	 * @param jrxmlFileName
	 * @param pdfFileName
	 * @throws Exception
	 */
	public static void exportJrxmlToExcel(String jrxmlFileName, String excelFileName) throws Exception {
		String tempJrprintFileName = getJrprintFileName(jrxmlFileName);

		long start = System.currentTimeMillis();
		File sourceFile = new File(URL + tempJrprintFileName);
		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);
		File destFile = new File(URL + excelFileName);

		JRXlsExporter exporter = new JRXlsExporter();

		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile.toString());
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);

		exporter.exportReport();

		System.err.println("XLS creation time : " + (System.currentTimeMillis() - start));
		System.out.println("成功创建了一个Excel文档");
	}

	/**
	 * @param jrxmlFileName
	 * @param pdfFileName
	 * @throws Exception
	 */
	public static void exportJrxmlToXml(String jrxmlFileName, String xmlFileName) throws Exception {
		String tempJasperFileName = getJasperFileName(jrxmlFileName);
		String tempJrprintFileName = getJrprintFileName(jrxmlFileName);

		// 编译static.jrxml报表设计文件，生成一个static.jasper报表文件
		JasperCompileManager.compileReportToFile(URL + jrxmlFileName, URL + tempJasperFileName);
		// 编译static.jasper报表设计文件，生成一个static.jrprint报表文件
		// 填充时，直接指定一个Connection作为数据库连接
		JasperFillManager.fillReportToFile(URL + tempJasperFileName, PARAMS, CONN);

		// 使用JasperExportManager将一个JasperPrint导出成PDF文档
		JasperExportManager.exportReportToXmlFile(URL + tempJrprintFileName, URL + xmlFileName, true);
		System.out.println("成功创建了一个XML文档");
	}

	public static void viewInFrameByJrxml(String jrxmlFileName) throws Exception {
		String tempJasperFileName = getJasperFileName(jrxmlFileName);
		String tempJrprintFileName = getJrprintFileName(jrxmlFileName);

		// 编译static.jrxml报表设计文件，生成一个static.jasper报表文件
		JasperCompileManager.compileReportToFile(URL + jrxmlFileName, URL + tempJasperFileName);
		// 编译static.jasper报表设计文件，生成一个static.jrprint报表文件
		// 填充时，直接指定一个Connection作为数据库连接
		JasperFillManager.fillReportToFile(URL + tempJasperFileName, PARAMS, CONN);

		// 以指定的*.jsprint文件创建一个JRViewer实例
		JRViewer jr = new JRViewer(URL + tempJrprintFileName, false);
		// 创建一个主窗口
		JFrame jf = new JFrame("报表预览");
		// 把JRViewer实例加载在窗口中
		jf.add(jr);
		jf.pack();
		// 显示窗口
		jf.setVisible(true);
	}

	public static void exportToExcel(String jrprintFileName, String excelFileName) throws Exception {
		long start = System.currentTimeMillis();
		File sourceFile = new File(URL + jrprintFileName);
		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);
		File destFile = new File(URL + excelFileName);

		JRXlsExporter exporter = new JRXlsExporter();

		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile.toString());
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);

		exporter.exportReport();

		System.err.println("XLS creation time : " + (System.currentTimeMillis() - start));
		System.out.println("成功创建了一个Excel文档");
	}

	public static void exportToXml(String jrprintFileName, String xmlFileName) throws Exception {
		JasperExportManager.exportReportToXmlFile(URL + jrprintFileName, URL + xmlFileName, true);
		System.out.println("成功创建了一个XML文档");
	}

	public static void viewInFrame(String jrprintFileName) throws Exception {
		// 以指定的*.jsprint文件创建一个JRViewer实例
		JRViewer jr = new JRViewer(URL + jrprintFileName, false);
		// 创建一个主窗口
		JFrame jf = new JFrame("报表预览");
		// 把JRViewer实例加载在窗口中
		jf.add(jr);
		jf.pack();
		// 显示窗口
		jf.setVisible(true);
	}

	public static String getJasperFileName(String jrxmlFileName) {
		int index = jrxmlFileName.lastIndexOf(".");
		if (-1 != index) {
			return jrxmlFileName.substring(0, index + 1) + "jasper";
		}

		return "";
	}

	public static String getJrprintFileName(String jrxmlFileName) {
		int index = jrxmlFileName.lastIndexOf(".");
		if (-1 != index) {
			return jrxmlFileName.substring(0, index + 1) + "jrprint";
		}

		return "";
	}

	public static void main(String[] args) {
		// System.out.println(getJasperFileName("temp.jrxml"));
		// System.out.println(getJrprintFileName("temp.jrxml"));
		try {
			String jrxmlFileName = "simpleQuery.jrxml";
			String tempJasperFileName = getJasperFileName(jrxmlFileName);
			String tempJrprintFileName = getJrprintFileName(jrxmlFileName);

			compileJrxmlToJasper(jrxmlFileName, tempJasperFileName);
			fillJasperToJrprint(tempJasperFileName);
			viewInFrame(tempJrprintFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}