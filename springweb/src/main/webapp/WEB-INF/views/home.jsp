<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
</head>
<body>
	<a href = "Hello">안녕하세요</a></br>
	<a href = "message/detail/11">URL에 포함된 매개변수</a></br></br>
	
	<!-- action 은 생략하면 현재 요청, method는 기본값이 GET, enctype 은 file 이 있는 경우 multipart/form-data로 설정하고 그 이외에는 생략 -->
	<form action="param1" method="get" enctype="" id="">
		이름: <input type="text" name="name"/></br>
		비번: <input type="password" name="password"/></br>
		<input type="submit" value="전송"/>
	</form>
	
	<form action="param2" method="post" enctype="" id="">
		이름: <input type="text" name="name"/></br>
		비번: <input type="password" name="password"/></br>
		<input type="submit" value="전송"/>
	</form>
	
	<form action="param3" method="post" enctype="" id="">
		이름: <input type="text" name="name"/></br>
		비번: <input type="password" name="password"/></br>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>