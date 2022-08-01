<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>2단 구조</h1>
	
	<table>
		<tr>
			<td><tiles:insertAttribute name="mainmenu"></tiles:insertAttribute></td>
			<td><tiles:insertAttribute name="content"></tiles:insertAttribute></td>
		</tr>		
	</table>
</body>
</html>