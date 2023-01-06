<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<!-- css 디렉토리의 style.css 등록 -->
<link rel="stylesheet" href="./css/style.css"/>
</head>
<body>
<div align = 'center' class='body'>
<h2>
	상세보기
</h2>
<table>
	<tr>
		<td><img src="../img/${item.pictureurl}"></td>
		<td align = 'center'>
			<table>
					<tr height="50">
					<td width = "80"> 상품명 </td>
					<td width = "320">${item.itemid}</td>
				</tr>
					<tr height="50">
					<td width = "80"> 가격 </td>
					<td width = "320">${item.price}</td>
				</tr>
					<tr height="50">
					<td width = "80"> 상품명 </td>
					<td width = "320">${item.description}</td>
				</tr>
				
				<tr>
					<td colspan='2' align='center' width='230'>
					<a href="../">목록으로</a>
					</td>
				</tr>
			</table>
		</td>	
	</tr>
</table>

</div>
<!-- 이러한 방식의 출력을 EL 방식이라고 한다.  -->
	
</body>
</html>