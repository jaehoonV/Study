<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>암호 변경</title>
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
<form action="changePwd.do" method="post">
<p>
	현재 암호<br/><input type="password" name="curPwd">
	<c:if test="${errors.curPwd}"><br>현재 암호를 입력하세요.</c:if>
	<c:if test="${errors.badCurPwd}"><br>현재 암호가 일치하지 않습니다.</c:if>
</p>
<p>
	새 암호<br/><input type="password" name="newPwd">
	<c:if test="${errors.newPwd}"><br>새 암호를 입력하세요.</c:if>
	<c:if test="${errors.samePassword}"><br>같은 암호로 변경할 수 없습니다.</c:if>
</p>
<input type="submit" value="암호 변경">
</form>
</div>

</body>
</html>