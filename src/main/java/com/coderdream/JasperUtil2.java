package com.coderdream;

import java.io.File;

import javax.swing.JFrame;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

public class JasperUtil2 {

	public static String url;

	static {
		url = JasperUtil2.class.getClassLoader().getResource("").getPath() + "reports/";
	}

	/**
	 * 编译static.jrxml报表设计文件，生成一个static.jasper报表文件
	 * 
	 * @param jrxmlFileName
	 * @param jasperFileName
	 * @throws Exception
	 */
	public static void compileJrxmlToJasper(String jrxmlFileName, String jasperFileName) throws Exception {
		JasperCompileManager.compileReportToFile(url + jrxmlFileName, url + jasperFileName);
		System.out.println("成功编译成JasperReport文件(*.jasper)");
	}

	/**
	 * 编译static.jrxml报表设计文件，生成一个static.jasper报表文件
	 * 
	 * @param jrxmlFileName
	 * @param jasperFileName
	 * @throws Exception
	 */
	public static void compileJrxmlToJasper(String fileName) throws Exception {
		JasperCompileManager.compileReportToFile(url + fileName + ".jrxml", url + fileName + ".jasper");
		System.out.println("成功编译成JasperReport文件(*.jasper)");
	}

	public static void fillJasperToPdf(String jasperFileName, String pdfFileName) throws Exception {
		JasperRunManager.runReportToPdfFile(url + jasperFileName, url + pdfFileName, null, new JREmptyDataSource());
		System.out.println("直接从Jasper文件创建一个PDF文档");
	}

	public static void fillJasperToPdf(String fileName) throws Exception {
		JasperRunManager.runReportToPdfFile(url + fileName + ".jrxml", url + fileName + ".pdf", null, new JREmptyDataSource());
		System.out.println("直接从Jasper文件创建一个PDF文档");
	}

	/**
	 * 填充时，即使没有使用数据源，也必须指定一个新建的JREmptyDataSource实例，而不能直接使用null
	 * 
	 * @param jasperFileName
	 * @param jrprintFileName
	 * @throws Exception
	 */
	public static void fillJasperToJrprint(String jasperFileName, String jrprintFileName) throws Exception {
		JasperFillManager.fillReportToFile(url + jasperFileName, url + jrprintFileName, null, new JREmptyDataSource());
		System.out.println("成功填充了一个报表文件(*.jrprint)");
	}

	/**
	 * 填充时，即使没有使用数据源，也必须指定一个新建的JREmptyDataSource实例，而不能直接使用null
	 * 
	 * @param jasperFileName
	 * @param jrprintFileName
	 * @throws Exception
	 */
	public static void fillJasperToJrprint(String fileName) throws Exception {
		JasperFillManager.fillReportToFile(url + fileName + ".jasper", url + fileName + ".jrprint", null, new JREmptyDataSource());
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
		JasperExportManager.exportReportToPdfFile(url + jrprintFileName, url + pdfFileName);
		System.out.println("成功创建了一个PDF文档");
	}

	/**
	 * 使用JasperExportManager将一个JasperPrint导出成PDF文档
	 * 
	 * @param fileName
	 * @throws Exception
	 */
	public static void exportToPdf(String fileName) throws Exception {
		JasperExportManager.exportReportToPdfFile(url + fileName + ".jrprint", url + fileName + ".pdf");
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
		JasperCompileManager.compileReportToFile(url + jrxmlFileName, url + tempJasperFileName);
		// 编译static.jasper报表设计文件，生成一个static.jrprint报表文件
		JasperFillManager.fillReportToFile(url + tempJasperFileName, url + tempJrprintFileName, null, new JREmptyDataSource());

		// 使用JasperExportManager将一个JasperPrint导出成PDF文档
		JasperExportManager.exportReportToPdfFile(url + tempJrprintFileName, url + pdfFileName);
		System.out.println("成功创建了一个PDF文档");
	}

	/**
	 * @param jrxmlFileName
	 * @param pdfFileName
	 * @throws Exception
	 */
	public static void exportJrxmlToPdf(String fileName) throws Exception {
		// 编译static.jrxml报表设计文件，生成一个static.jasper报表文件
		JasperCompileManager.compileReportToFile(url + fileName + ".jrxml", url + fileName + ".jasper");
		// 编译static.jasper报表设计文件，生成一个static.jrprint报表文件
		JasperFillManager.fillReportToFile(url + fileName + ".jasper", url + fileName + ".jrprint", null, new JREmptyDataSource());

		// 使用JasperExportManager将一个JasperPrint导出成PDF文档
		JasperExportManager.exportReportToPdfFile(url + fileName + ".jrprint", url + fileName + ".pdf");
		System.out.println("成功创建了一个PDF文档");
	}

	/**
	 * @param jrxmlFileName
	 * @param pdfFileName
	 * @throws Exception
	 */
	public static void exportJrxmlToExcel(String jrxmlFileName, String excelFileName) throws Exception {
		String tempJrprintFileName = getJrprintFileName(jrxmlFileName);
		String tempXlsFileName = getExcelFileName(jrxmlFileName);

		long start = System.currentTimeMillis();
		File sourceFile = new File(tempJrprintFileName);
		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);
		File destFile = new File(tempXlsFileName);

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
	public static void exportJrxmlToExcel(String fileName) throws Exception {
		long start = System.currentTimeMillis();
		File sourceFile = new File(url + fileName + ".jrprint");
		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);
		File destFile = new File(url + fileName + ".xls");

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
	public static void exportJrxmlToXml(String fileName) throws Exception {
		// 编译static.jrxml报表设计文件，生成一个static.jasper报表文件
		JasperCompileManager.compileReportToFile(url + fileName + ".jrxml", url + fileName + ".jasper");
		// 编译static.jasper报表设计文件，生成一个static.jrprint报表文件
		JasperFillManager.fillReportToFile(url + fileName + ".jasper", url + fileName + ".jrprint", null, new JREmptyDataSource());

		// 使用JasperExportManager将一个JasperPrint导出成XML文档
		JasperExportManager.exportReportToXmlFile(url + fileName + ".jrprint", url + fileName + ".xml", true);
		System.out.println("成功创建了一个XML文档");
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
		JasperCompileManager.compileReportToFile(url + jrxmlFileName, url + tempJasperFileName);
		// 编译static.jasper报表设计文件，生成一个static.jrprint报表文件
		JasperFillManager.fillReportToFile(url + tempJasperFileName, url + tempJrprintFileName, null, new JREmptyDataSource());

		// 使用JasperExportManager将一个JasperPrint导出成XML文档
		JasperExportManager.exportReportToXmlFile(url + tempJrprintFileName, url + xmlFileName, true);
		System.out.println("成功创建了一个XML文档");
	}

	public static void viewInFrameByJrxml(String fileName) throws Exception {
		// 编译static.jrxml报表设计文件，生成一个static.jasper报表文件
		JasperCompileManager.compileReportToFile(url + fileName + ".jrxml", url + fileName + ".jasper");
		// 编译static.jasper报表设计文件，生成一个static.jrprint报表文件
		JasperFillManager.fillReportToFile(url + fileName + ".jasper", url + fileName + ".jrprint", null, new JREmptyDataSource());

		// 以指定的*.jsprint文件创建一个JRViewer实例
		JRViewer jr = new JRViewer(url + fileName + ".jrprint", false);
		// 创建一个主窗口
		JFrame jf = new JFrame("报表预览");
		// 把JRViewer实例加载在窗口中
		jf.add(jr);
		jf.pack();
		// 显示窗口
		jf.setVisible(true);
	}

	public static void exportToExcel(String jrprintFileName, String excelFileName) throws Exception {
		// 使用JRLoader来加载一个*.jrprint文件，生成一个JasperPrint实例
		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObjectFromFile(url + jrprintFileName);
		// //创建一个JRXlsExporter实例(依赖于POI)，用于导出Excel文档
		// JRXlsExporter exporter = new JRXlsExporter();
		// 创建一个JExcelApiExporter实例(依赖于JXL)，用于导出Excel文档
		JExcelApiExporter exporter = new JExcelApiExporter();
		// 设置要导出的JasperPrint实例
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		// 设置要导出的目标文件
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, url + excelFileName);
		// 设置每张报表都写在不同的文件里
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
		exporter.exportReport();
		System.out.println("成功创建了一个Excel文档");
	}

	/**
	 * TODO
	 * 
	 * @param fileName
	 * @throws Exception
	 */
	public static void exportJrprintToExcel(String fileName) throws Exception {
		long start = System.currentTimeMillis();
		File sourceFile = new File(url + fileName + ".jrprint");
		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);
		File destFile = new File(url + fileName + ".xls");

		JRXlsExporter exporter = new JRXlsExporter();

		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile.toString());
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);

		exporter.exportReport();

		System.err.println("XLS creation time : " + (System.currentTimeMillis() - start));
		System.out.println("成功创建了一个Excel文档");
	}

	public static void exportJrprintToXml(String fileName) throws Exception {
		JasperExportManager.exportReportToXmlFile(url + fileName + ".jrprint", url + fileName + ".xml", true);
		System.out.println("成功创建了一个XML文档");
	}

	public static void exportToXml(String jrprintFileName, String xmlFileName) throws Exception {
		JasperExportManager.exportReportToXmlFile(url + jrprintFileName, url + xmlFileName, true);
		System.out.println("成功创建了一个XML文档");
	}

	public static void viewInFrame(String jrprintFileName) throws Exception {
		// 以指定的*.jsprint文件创建一个JRViewer实例
		JRViewer jr = new JRViewer(url + jrprintFileName, false);
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

	public static String getExcelFileName(String jrxmlFileName) {
		int index = jrxmlFileName.lastIndexOf(".");
		if (-1 != index) {
			return jrxmlFileName.substring(0, index + 1) + "xls";
		}

		return "";
	}

	public static void main(String[] args) {
		System.out.println(getJasperFileName("temp.jrxml"));
		System.out.println(getJrprintFileName("temp.jrxml"));
	}
}