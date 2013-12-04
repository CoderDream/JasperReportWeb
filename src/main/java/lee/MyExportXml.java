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
public class MyExportXml {

	public static void exportToXml(String jrprintFileName, String xmlFileName) throws Exception {
		JasperExportManager.exportReportToXmlFile(jrprintFileName, xmlFileName, true);
		System.out.println("成功创建了一个XML文档");
	}

	public static void main(String[] args) throws Exception {
		String url = MyCompile.class.getClassLoader().getResource("").getPath();
		System.out.println(url);
		JasperExportManager.exportReportToXmlFile(url + "reports/static.jrprint", url + "reports/static.xml", true);
		System.out.println("成功创建了一个XML文档");
	}
}
