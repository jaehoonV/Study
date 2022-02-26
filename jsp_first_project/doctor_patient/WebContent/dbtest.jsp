<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Context initContext = new InitialContext();
	Context envContext = (Context) initContext.lookup("java:/comp/env");
	DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
	Connection conn = ds.getConnection();
	%>
	
	<%
	PreparedStatement pstmt = conn.prepareStatement("select sysdate from dual");
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()){
		String time = rs.getString(1);
		log("DB연결 성공 : 날짜 >>>>>>>>>>>" + time);
	}
	%>
	
</body>
</html>