<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String img1 = (String)request.getAttribute("img1");
	String img2 = (String)request.getAttribute("img2");
	String img3 = (String)request.getAttribute("img3");
	String img4 = (String)request.getAttribute("img4");
	String img5 = (String)request.getAttribute("img5");
	String img6 = (String)request.getAttribute("img6");
%>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 보기</title>
<style type="text/css">
	img {
	width: 400px;
	}
</style>
</head>
<body>
	<img alt="img1" src="<%=img1 %>">
	<br>
	<img alt="img2" src="<%=img2 %>">
	<br>
	<img alt="img2" src="<%=img3 %>">
	<br>
	<img alt="img2" src="<%=img4 %>">
	<br>
	<img alt="img2" src="<%=img5 %>">
	<br>
	<img alt="img2" src="<%=img6 %>">
	<%--jsp주석 --%>
	<!-- html주석 -->
	<%//자바 주석 %>
</body>
</html>