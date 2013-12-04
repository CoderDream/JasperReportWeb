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
public class MyFill {

	public static void fillJasperToJrprint(String jasperFileName, String jrprintFileName) throws Exception {
		// 填充时，即使没有使用数据源
		// 也必须指定一个新建的JREmptyDataSource实例，而不能直接使用null
		JasperFillManager.fillReportToFile(jasperFileName, jrprintFileName, null, new JREmptyDataSource());
		System.out.println("成功填充了一个报表文件(*.jrprint)");
	}

	public static void main(String[] args) throws Exception {
		String url = MyCompile.class.getClassLoader().getResource("").getPath();
		System.out.println(url);
		// 填充时，即使没有使用数据源
		// 也必须指定一个新建的JREmptyDataSource实例，而不能直接使用null
		JasperFillManager.fillReportToFile(url + "reports/static.jasper", url + "reports/static.jrprint", null, new JREmptyDataSource());
		System.out.println("成功填充了一个报表文件(*.jrprint)");
	}
}