<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>의사-환자 시스템</title>
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
	fieldset {
		width: 300px;
		height: 70px;
		margin-left: auto;
		margin-right: auto;
		text-align: center;
		padding-top: 20px; 
		padding-bottom: 20px; 
	}
</style>
</head>
<body>
	<div><h1 style="text-align: center;">의사 환자 등록 시스템</h1>
	
	<c:if test="${! empty authUser}">
	${authUser.docName}님, 안녕하세요
	<br>
	<fieldset>
	<legend>의사</legend>
	<button type="button" onclick="logout()">로그아웃</button>	
	&emsp;
	<button type="button" onClick="location.href='<%=request.getContextPath()%>/changePwd.do'">암호변경</button>
	&emsp;
	<button type="button" onClick="location.href='<%=request.getContextPath()%>/deleteDoctor.do'">탈퇴</button>
	</fieldset>
	
	<fieldset>
	<legend>환자</legend>
	<button type="button" onClick="location.href='<%=request.getContextPath()%>/list.do'">환자 목록</button>
	</fieldset>
	</c:if>
	
	<c:if test="${empty authUser}">
	<fieldset>
	<legend>의사</legend>
	<button type="button" onClick="location.href='<%=request.getContextPath()%>/join.do'">의사 등록</button>	
	&emsp;
	<button type="button" onClick="location.href='<%=request.getContextPath()%>/login.do'">로그인</button>
	&emsp;
	</fieldset>
	
	<fieldset>
	<legend>환자</legend>
	<button type="button" onClick="location.href='<%=request.getContextPath()%>/register.do'">환자 등록</button>
	</fieldset>
	</c:if>
	</div>

	<script type="text/javascript">
	function logout() {
		var answer = confirm("정말 로그아웃 하시겠습니까?");
		if(answer){
			location.href = "<%=request.getContextPath()%>/logout.do";
			} else {
				return;
			}
		}
	</script>
	
</body>
</html>