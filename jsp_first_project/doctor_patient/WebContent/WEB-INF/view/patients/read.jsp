<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>환자</title>
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
	button{
		font-size: 17px;
	}
	table{
		border:2px; 
		width: 80%;
		text-align: center;
		margin-left: auto;
		margin-right: auto;
	}
	tr:nth-child(even){background-color: #f2f2f2;}

	tr:hover {background-color: #ddd;}

	td{
  	border: 1px solid #ddd;
  	padding: 8px;
  	width: 50%;
	}
</style>
</head>
<body>

<div>
<table>
<tr>
	<td>환자 ID</td>
	<td>${patientData.patients.patientID}</td>
</tr>
<tr>
	<td>환자 이름</td>
	<td>${patientData.patients.patientName}</td>
</tr>
</table>
<br>
<br>
<table>
<tr>
	<td>진단명</td>
</tr>
<tr>
	<td><c:out value='${patientData.diagnosis}' /></td>
</tr>
<tr>
	<td>처방</td>
</tr>
<tr>
	<td><c:out value='${patientData.prescription}'/></td>
</tr>

</table>
<br>
		<c:set var="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" />
		<button type="button" onClick="location.href='<%=request.getContextPath()%>/list.do?pageNo=${pageNo}'">뒤로가기</button>
		&emsp;
		<button type="button" onClick="location.href='<%=request.getContextPath()%>/write.do?ID=${patientData.patients.patientID}'">환자 진단 처방</button>
</div>
</body>
</html>