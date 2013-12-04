<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="net.sf.jasperreports.engine.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>

<html>
<body>
	<h2>Hello World!</h2>
	<%
		String ctxpath = request.getContextPath();
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "1234";
		Connection conn = DriverManager.getConnection(url, user, password);
		//ireport生成的.jasper文件的存放位置，这里为了方便放置在根目录下面  
		File reportFile = new File(this.getServletContext().getRealPath("report1.jasper"));
		Map parameters = new HashMap();
		try {
			//执行报表程序  
			JasperRunManager.runReportToHtmlFile(reportFile.getPath(), parameters, conn);
			response.sendRedirect(ctxpath + "/index.jsp");
			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}

		}
	%>
</body>
</html>