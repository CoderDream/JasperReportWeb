package lee;

import net.sf.jasperreports.engine.*;

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
public class MyExportPdf {

	public static void exportToPdf(String jrprintFileName, String pdfFileName) throws Exception {
		// 使用JasperExportManager将一个JasperPrint导出成PDF文档
		JasperExportManager.exportReportToPdfFile(jrprintFileName, pdfFileName);
		System.out.println("成功创建了一个PDF文档");
	}

	public static void main(String[] args) throws Exception {
		String url = MyCompile.class.getClassLoader().getResource("").getPath();
		System.out.println(url);
		// 使用JasperExportManager将一个JasperPrint导出成PDF文档
		JasperExportManager.exportReportToPdfFile(url + "reports/static.jrprint", url + "reports/static.pdf");
		System.out.println("成功创建了一个PDF文档");
	}
}