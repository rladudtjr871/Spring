<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- view.jsp -->
<style>
	.table th { width: 150px; }
	textarea[name=content] { height: 200px; resize: none; }
</style>
<section>

	<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<td>${dto.seq}</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${dto.id}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.subject}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${dto.content}</td>
		</tr>
		<tr>
			<th>날짜</th>
			<td>${dto.regdate}</td>
		</tr>
	</table>	
	
	<div>
		<input type="button" value="돌아가기" class="btn btn-secondary"
			onClick="location.href='/spring/list';">
	</div>
			
</section>