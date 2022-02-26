<%@ page contentType="text/html; charset=utf-8"%>
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
	button{
		font-size: 17px;
	}
</style>
</head>
<body>
<div>
<p> 환자의 진단과 처방이 입력되었습니다.</p>

<button type="button" onClick="location.href='<%=request.getContextPath()%>/list.do'">환자 목록</button>
</div>
</body>
</html>