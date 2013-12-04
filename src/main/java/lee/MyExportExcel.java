package lee;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

//import net.sf.jasperreports.engine.export.JExcelApiExporter

/**
 * Description: <br/>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a> <br/>
 * Copyright (C), 2001-2010, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class MyExportExcel {

	public static void exportToExcel(String jrprintFileName, String excelFileName) throws Exception {
		// 使用JRLoader来加载一个*.jrprint文件，生成一个JasperPrint实例
		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(jrprintFileName);
		// //创建一个JRXlsExporter实例(依赖于POI)，用于导出Excel文档
		// JRXlsExporter exporter = new JRXlsExporter();
		// 创建一个JExcelApiExporter实例(依赖于JXL)，用于导出Excel文档
		JExcelApiExporter exporter = new JExcelApiExporter();
		// 设置要导出的JasperPrint实例
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		// 设置要导出的目标文件
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, excelFileName);
		// 设置每张报表都写在不同的文件里
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
		exporter.exportReport();
		System.out.println("成功创建了一个Excel文档");
	}

	public static void main(String[] args) throws Exception {
		String url = MyCompile.class.getClassLoader().getResource("").getPath();
		System.out.println(url);
		// 使用JRLoader来加载一个*.jrprint文件，生成一个JasperPrint实例
		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(url + "reports/static.jrprint");
		// //创建一个JRXlsExporter实例(依赖于POI)，用于导出Excel文档
		// JRXlsExporter exporter = new JRXlsExporter();
		// 创建一个JExcelApiExporter实例(依赖于JXL)，用于导出Excel文档
		JExcelApiExporter exporter = new JExcelApiExporter();
		// 设置要导出的JasperPrint实例
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		// 设置要导出的目标文件
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, url + "reports/static.xls");
		// 设置每张报表都写在不同的文件里
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
		exporter.exportReport();
		System.out.println("成功创建了一个Excel文档");
	}
}
