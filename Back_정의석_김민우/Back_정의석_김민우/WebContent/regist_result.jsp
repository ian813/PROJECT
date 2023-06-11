<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 등록 결과</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
}

th:nth-child(1) {
	width: 120px;
}
</style>
</head>
<body>
<%@ include file="/include/header.jsp"%>
	<h1>리뷰 등록 결과</h1>
	<h2>등록된 리뷰 정보</h2>
	<%-- 테이블 내에서 User의 내용을 출력하기 위해 expression tag를 사용한다. --%>
	<table>
		<thead>
			<tr>
				<th>항목</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>리뷰 번호</td>
				<td>${review.num}</td>
			</tr>
			<%--
			<tr>
				<td>영상 번호</td>
				<td>${video.title}</td>
			</tr> --%>
			<tr>
				<td>이름</td>
				<td>${review.nickName}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${review.title}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${review.content}</td>
			</tr>
		</tbody>
	</table>
	<!-- 다시 사용자를 등록할 수 있는 링크를 제공한다. -->
	<a href="regist.jsp">추가등록</a>
	<a href="./main?action=list">리뷰 목록</a>
</body>
</html>
