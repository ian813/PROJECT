<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 정보 사이트</title>
<style>
	label {
		display: inline-block;
		width: 80px;
	}
</style>
</head>
<body>
<%@ include file="/include/header.jsp"%>
	<h1>리뷰 등록</h1>
	<form method="post" action="main">
		<fieldset>
		<legend>리뷰 입력</legend>
		<!-- front-controller pattern에서 요청을 구분하기 위한 parameter -->
		<input type="hidden" name="action" value="regist">
		<label for="num">리뷰 번호</label>
		<input type="number" id="num" name="num"><br>
<%--		<label for="id">영상 번호</label>
		<input type="text" id="id" name="id"><br>  --%>
		<label for="nickName">이름</label>
		<input type="text" id="nickName" name="nickName"><br>
		<label for="title">제목</label>
		<input type="text" id="title" name="title"><br>
		<label for="content">내용</label>
		<input type="text" id="content" name="content"><br>
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
		</fieldset>
	</form>
	<a href="./index.jsp">영상 목록</a>
	<a href="./main?action=list">리뷰 목록</a>
</body>
</html>
