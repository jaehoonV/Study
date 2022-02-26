<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>환자 진단 처방</title>
<style type="text/css">
	div{
		width: 600px;
		margin-left: auto;
		margin-right: auto;
		border:2px solid;
		padding-bottom: 20px;
		padding-top: 20px;
		text-align: center;
	}
</style>
</head>
<body>
<div>
<form action="write.do" method="post">
<input type="hidden" name="ID" value="${wtReq.patientID}">

<p>
	진단명<br/><input type="text" name="diagnosis" value="${wtReq.diagnosis}">
</p>
<p>
	처방<br/>
	<textarea name="prescription" rows="5" cols="30">${wtReq.prescription}</textarea>
</p>
<input type="submit" value="진단처방">
</form>
</div>
</body>
</html>