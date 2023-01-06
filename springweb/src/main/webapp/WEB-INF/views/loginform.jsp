<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <!-- 스프링 태그 라이브러리 설정 -->
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginform(message result page)</title>
</head>
<body>
		<form:form modelAttribute="member">
			<p>
			<label for="email">
				<spring:message code = "email"/>
			</label>
			<form:input path="email"/>
			<form:errors path="email"/>
			</p>
			<p>
			<label for="password">
				<spring:message code = "password"/>
			</label>
			 <form:input path="pw"/>
			 <form:errors path="pw"/>
			</p>
			
			<p>
				<form:select path="loginType" items="${loginTypes}" />
			</p>
			
			<input type="submit" value="로그인"/>
		</form:form>

	<%-- <form action="loginform" method="post">
		<p>
		<label for="email">
			<spring:message code = "email"/>
		</label>
		이메일: <input type="text" name="email" id="email"/>
		</p>
		<p>
		<label for="password">
			<spring:message code = "password"/>
		</label>
		비밀번호: <input type="text" name="password" id="password"/>
		</p>
		<input type="submit" value="로그인"/>
	</form> --%>
</body>
</html>