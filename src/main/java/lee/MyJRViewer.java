package lee;

import javax.swing.JFrame;
import net.sf.jasperreports.view.JRViewer;

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
public class MyJRViewer {

	public static void viewInFram(String jrprintFileName) throws Exception {
		// 以指定的*.jsprint文件创建一个JRViewer实例
		JRViewer jr = new JRViewer(jrprintFileName, false);
		// 创建一个主窗口
		JFrame jf = new JFrame("报表预览");
		// 把JRViewer实例加载在窗口中
		jf.add(jr);
		jf.pack();
		// 显示窗口
		jf.setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		String url = MyCompile.class.getClassLoader().getResource("").getPath();
		System.out.println(url);
		// 以指定的*.jsprint文件创建一个JRViewer实例
		JRViewer jr = new JRViewer(url + "reports/static.jrprint", false);
		// 创建一个主窗口
		JFrame jf = new JFrame("报表预览");
		// 把JRViewer实例加载在窗口中
		jf.add(jr);
		jf.pack();
		// 显示窗口
		jf.setVisible(true);
	}
}
