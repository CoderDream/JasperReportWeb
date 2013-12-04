package lee;

import net.sf.jasperreports.engine.JasperCompileManager;

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
public class MyCompile {

	public static void compileJrxmlToJasper(String jrxmlFileName, String jasperFileName) throws Exception {
		// 编译static.jrxml报表设计文件，生成一个static.jasper报表文件
		JasperCompileManager.compileReportToFile(jrxmlFileName, jasperFileName);
		System.out.println("成功编译成JasperReport文件(*.jasper)");
	}

	public static void main(String[] args) throws Exception {
		String url = MyCompile.class.getClassLoader().getResource("").getPath();
		System.out.println(url);
		// 编译static.jrxml报表设计文件，生成一个static.jasper报表文件
		JasperCompileManager.compileReportToFile(url + "reports/static.jrxml", url + "reports/static.jasper");
		System.out.println("成功编译成JasperReport文件(*.jasper)");
	}
}