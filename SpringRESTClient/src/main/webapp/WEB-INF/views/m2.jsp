<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>REST API > 주소록 목록보기</h1>
	
	<table id="tbl1" border>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>전화</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	
	<hr>
	
	<input type="button" value="보기" onclick="test();">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		
		function test() {
			$.ajax({
				type: 'GET',
				url: 'http://localhost:8090/spring/address',
				dataType: 'JSON',
				success: function(result) {
					$(result).each(function(index, item) {
						
						$('#tbl1 tbody').append('<tr><td>'+ item.seq + '</td><td>'+ item.name +  '</td><td>'+ item.age + '</td><td>'+ item.tel + '</td><td>'+ item.address + '</td></tr>');
						
					});
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
		}
	
	</script>
	
</body>
</html>















