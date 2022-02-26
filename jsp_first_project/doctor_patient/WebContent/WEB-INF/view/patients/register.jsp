<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>환자 등록</title>
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
<form action="register.do" method="post">
<p>
	환자 아이디<br/><input type="text" name="patientID" maxlength="20">
	<c:if test="${errors.patientID}"><br>환자 아이디를 입력하세요.</c:if>
	<c:if test="${errors.duplicateId}"><br>이미 사용중인 환자 아이디입니다.</c:if>
</p>
<p>
	환자 이름<br/><input type="text" name="patientName" maxlength="20" value="${param.patientName}">
	<c:if test="${errors.patientName}"><br>환자 이름을 입력하세요.</c:if>
</p>
<input type="submit" value="등록">
</form>
</div>
</body>
</html>