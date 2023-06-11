<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 관리</title>
<style>
#user-list {
	border-collapse: collapse;
	width: 100%;
}

#user-list td, #user-list th {
	border: 1px solid black;
	text-align: center;
}
</style>
</head>
<body>
<%@ include file="/include/header.jsp"%>
	<h1>등록된 리뷰 목록</h1>
	<c:if test="${!empty reviewCount }">
		<h2>지금까지 등록한 리뷰 수 : ${reviewCount}</h2>
	</c:if>
	<table id="review-list">
		<thead>
			<tr>
				<th>리뷰 번호</th>
				<th>이름</th>
				<th>제목</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody>
			<%-- request 영역에 user로 등록된 자료를 반복문을 이용해 출력한다. --%>
			<c:forEach items="${reviews }" var="review">
				<tr>
					<td>${review.num }</td>
					<td>${review.nickName }</td>
					<td>${review.title }</td>
					<td>${review.content }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="regist.jsp">추가등록</a>
</body>
</html>