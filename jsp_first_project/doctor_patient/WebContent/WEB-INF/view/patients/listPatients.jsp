<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>환자 목록</title>
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
		<td colspan="5">환자 목록</td>
	</tr>
	<tr>
		<td>환자 ID</td>
		<td>환자 이름</td>
	</tr>
<c:if test="${listPage.hasNoPatients()}">
	<tr>
		<td colspan="5">등록된 환자가 없습니다.</td>
	</tr>
</c:if>
<c:forEach var="Patients" items="${listPage.content}">
	<tr>
		<td>${Patients.patientID}</td>
		<td>
		<a href="read.do?ID=${Patients.patientID}&pageNo=${listPage.currentPage}">
		<c:out value="${Patients.patientName}"/>
		</a>
		</td>
	</tr>
</c:forEach>
<c:if test="${listPage.hasPatients()}">
	<tr>
		<td colspan="5">
			<c:if test="${listPage.startPage > 5}">
			<a href="list.do?pageNo=${listPage.startPage - 5}">[이전]</a>
			</c:if>
			<c:forEach var="pNo" 
					   begin="${listPage.startPage}" 
					   end="${listPage.endPage}">
			<a href="list.do?pageNo=${pNo}">[${pNo}]</a>
			</c:forEach>
			<c:if test="${listPage.endPage < listPage.totalPages}">
			<a href="list.do?pageNo=${listPage.startPage + 5}">[다음]</a>
			</c:if>
		</td>
	</tr>
</c:if>
</table>
<br>
<button type="button" onClick="location.href='<%=request.getContextPath()%>/index.jsp'">뒤로가기</button>

</div>

</body>
</html>