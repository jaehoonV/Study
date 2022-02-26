<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<style type="text/css">
	div{
		width: 600px;
		margin-left: auto;
		margin-right: auto;
		border:2px solid;
		padding-bottom: 20px;
		text-align: center;
	}
</style>
</head>
<body>
<div>
<form action="login.do" method="post">
<p>
	아이디<br/><input type="text" name="docID" value="${param.docID}">
	<c:if test="${errors.docID}"><br>의사 ID를 입력하세요.</c:if>
</p>
<p>
	암호<br/><input type="password" name="docPW">
	<c:if test="${errors.docPW}"><br>암호를 입력하세요.</c:if>
</p>
<input type="submit" value="로그인">
&emsp;
<button type="button" onClick="location.href='<%=request.getContextPath()%>/join.do'">의사 등록</button>
</form>
</div>
</body>
</html>