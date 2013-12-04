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
public class Jasper2Pdf {
	

	
	public static void main(String[] args) throws Exception {
		JasperRunManager.runReportToPdfFile("static.jasper", "static.pdf", null, new JREmptyDataSource());
		System.out.println("直接从Jasper文件创建一个PDF文档");
	}
}