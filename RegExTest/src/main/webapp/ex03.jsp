<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ex03.jsp -->
	
	
	
	<script src="js/cookie.js"></script>
	<script>
	
		/*
	
			쿠키, Cookie
			- 개인 정보를 저장하는 저장소
			- 브라우저가 특정 사이트를 방문했을 때, 사이트에서 개인에 대한 정보를 지속적으로 보관하기 위해서 브라우저가 관리하는 저장 공간에 개인 정보를 저장할 수 있다. > 쿠키
			- 세션 vs 쿠키 차이점
				1. 세션
					- 서버 메모리에 저장
					- 모든 데이터 저장 가능(Object)
					- 크기 제한 없음 > 크키 제한 있음 > 서버 메모리 제한 + 모든 유저 사용
					
				2. 쿠키
					- 클라이언트 메모리 or HDD에 저장
					- 텍스트 데이터만 저장 가능(쿠키는 실제로 텍스트 파일이다.) > 자료형 존재X
					- 4KB 제한
					- 자바스크립트 or 자바 통제 
		
		*/
		
		//document.cookie = "key=value&key=value&key=value";
		//console.log(document.cookie);
		
		
		setCookie('name', '홍길동');
		setCookie('age', 20);
		
		console.log(getCookie('name'));
		console.log(getCookie('age'));
		
	</script>
	
</body>
</html>




























