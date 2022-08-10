<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- webapp > ex02.jsp -->
	
	<h1>정규 표현식</h1>
	
	<form method="POST" action="addok.jsp" id="form1">
	
		이름: <input type="text" id="name">
		<br><br>
		
		아이디: <input type="text" id="id">
		<br><br>
		
		<input type="button" value="등록하기" onclick="send();">
		
	</form>
	
	<hr>
	
	<form method="POST" action="addok.jsp">
	
		이름: <input type="text" required pattern="^[가-힣]{2,5}$">
		<br><br>
		
		아이디: <input type="text" required pattern="^[A-Za-z_][A-Za-z0-9_]{3,11}$">
		<br><br>
		
		<input type="submit" value="등록하기">
		
	</form>
	
	
	<script src="js/cookie.js"></script>
	<script>
	
		console.log(getCookie('name'));
		console.log(getCookie('age'));
	
		const name = document.getElementById("name");
		const id = document.getElementById("id");
		const form1 = document.getElementById('form1'); 
	
		function send() {
			
			let regex = /^[가-힣]{2,5}$/;
			
			//alert(regex.test(name.value));
			if (!regex.test(name.value)) {
				alert('올바른 이름을 입력하세요.');
				return;
			}
			
			
			regex = /^[A-Za-z_][A-Za-z0-9_]{3,11}$/;
			
			if (!regex.test(id.value)) {
				alert('올바른 아이디를 입력하세요.');
				return;
			}
			
			
			form1.submit(); //전송
			
		}
	
	</script>
	
</body>
</html>









































