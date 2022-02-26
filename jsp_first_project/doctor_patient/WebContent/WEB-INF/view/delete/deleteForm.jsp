<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>탈퇴</title>
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
<form action="deleteDoctor.do" method="post"> 
<p>회원 탈퇴를 위해 아이디와 비밀번호를 재입력 해주세요.</p>
<p>
	아이디<br/><input type="text" name="docID" value="${param.docID}">
	<c:if test="${errors.docID}"><br>ID를 입력하세요.</c:if>
</p>
<p>
	비밀번호<br/><input type="password" name="docPW">
	<c:if test="${errors.docPW}"><br>비밀번호를 입력하세요.</c:if>
	<c:if test="${errors.no}"><br>비밀번호를 다시 입력하세요.</c:if>
</p>
<input type="submit" value="탈퇴하기">
</form>
</div>
</body>
</html>