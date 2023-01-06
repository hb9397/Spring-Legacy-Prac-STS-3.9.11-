	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	    
	<!--jstl 사용을 위한 태그 라이브러리 설정 : JSP 에서 만 사용한다.  -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Spring MVC</title>
	
	<!-- link는 파일의 위치 기준이 아니고 URL이 기준이된다.  -->
	<link rel="stylesheet" href="./css/style.css"/>
	
	</head>
	<body>
		<a href="item.xls">엑셀 다운로드</a></br>
		<a href="item.pdf">PDF 다운로드</a></br>
		<a href="itemlist.json">json 다운로드</a></br>
		<a href="itemlist.csv">텍스트 출력</a></br>
		<a href="itemlistrest.json">json 다운로드</a></br></br>
		
		<a href="exception">예외 발생</a></br></br>
		
		<a href="message">메시지 출력</a></br>
		
		<div align = "center" class = "body">
			<h2>상품목록</h2>
			<table border="1">
				<tr class = "header">
					<th align = "center" width="80">아이디</th>
					<th align = "center" width="320">이름</th>
					<th align = "center" width="100">가격</th>
				</tr>
				<c:forEach var="item" items="${list}">
					<tr class="record">
						<td align = "center" width="80">${item.itemid}</td>
						<!-- 상세보기로 넘어갈 링크 생성 -->
						<td align = "center" width="320">
							<%-- <a href="detail?itemid=${item.itemid}">${item.itemname}</a> --%>
							<a href="detail/${item.itemid}">${item.itemname}</a>
						</td>
						<td align = "center" width="100">${item.price}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<a href = "Hello">안녕하세요</a></br>
		<a href = "message/detail/11">URL에 포함된 매개변수</a></br>
		<a href = "redirect">Redirect</a>
		
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