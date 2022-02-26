<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>가입 완료</title>
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
<p> ${param.patientName} 환자의 등록을 성공했습니다.</p>
<button type="button" onClick="location.href='<%=request.getContextPath()%>/index.jsp'">처음으로</button>
</div>
</body>
</html>