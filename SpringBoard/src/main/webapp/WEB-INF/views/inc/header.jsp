<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- header.jsp -->
<header>
	<c:if test="${empty auth}">
		Spring Board
	</c:if>
	
	<c:if test="${not empty auth}">
		<span style="color: cornflowerblue;">Spring Board</span>
	</c:if>
	
</header>