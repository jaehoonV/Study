<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>의사 등록</title>
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
<form action="join.do" method="post">
<div>
<h2>의사 등록</h2>
<p>
	의사 아이디<br/><input type="text" name="docID" maxlength="20" value="${param.docID}">
	
	<c:if test="${errors.docID}"><br>아이디를 입력하세요.</c:if>
	<c:if test="${errors.duplicateId}"><br>이미 사용중인 아이디입니다.</c:if>
</p>

<p>
	암호<br/><input type="text" name="docPW" maxlength="20">
	<c:if test="${errors.docPW}"><br>암호를 입력하세요.</c:if>
</p>

<p>
	암호 확인<br/><input type="password" name="confirmPassword" maxlength="20">
	<c:if test="${errors.confirmPassword}"><br>암호 확인을 입력하세요.</c:if>
	<c:if test="${errors.notMatch}"><br>암호와 암호 확인이 일치하지 않습니다.</c:if>
</p>

<p>
	의사 이름<br/><input type="text" name="docName" maxlength="20" value="${param.docName}">
	<c:if test="${errors.docName}"><br>의사 이름을 입력하세요.</c:if>
</p>

<p>
	진료과<br/><input type="text" name="medicalDepartment" maxlength="20" value="${param.medicalDepartment}">
	<c:if test="${errors.medicalDepartment}"><br>진료과를 입력하세요.</c:if>
</p>

<p>
	전화번호<br/><input type="text" name="phoneNum" maxlength="20">
</p>
<input type="submit" value="가입">

</div>
</form>
</body>
</html>