<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- add.jsp -->
<style>
	.table th { width: 150px; }
	textarea[name=content] { height: 200px; resize: none; }
</style>
<section>

	<form method="POST" action="/spring/addok">
	
		<table class="table table-bordered">
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" class="form-control" required></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><textarea name="content" class="form-control" required></textarea></td>
			</tr>
		</table>	
		
		<div>
			<input type="button" value="돌아가기" class="btn btn-secondary"
				onClick="location.href='/spring/list';">
			<input type="submit" value="쓰기" class="btn btn-primary">
		</div>
	
	</form>
	
</section>