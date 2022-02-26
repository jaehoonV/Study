<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    session.invalidate();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>탈퇴 성공</title>
<style type="text/css">
	div{
		width: 600px;
		margin-left: auto;
		margin-right: auto;
		border:2px solid;
		padding-bottom: 20px;
		text-align: center;
	}
	button{
		font-size: 17px;
	}
</style>
</head>
<body>
<div>
<p>회원 탈퇴 성공</p>
<button type="button" onClick="location.href='<%=request.getContextPath()%>/index.jsp'">처음으로</button>
</div>
</body>
</html>