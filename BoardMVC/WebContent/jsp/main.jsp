<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String pageName = (String)request.getAttribute("page"); %>
<% String title  = (String)request.getAttribute("title"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="jsp/css/common.css">
<link rel="stylesheet" type="text/css" href="jsp/css/${content}.css">
<title></title>

</head>
<body>
<h1>board${btype} 게시판</h1>
<jsp:include page="manu.jsp"></jsp:include>
<jsp:include page="${content}.jsp"></jsp:include>
<jsp:include page="bottom.jsp"></jsp:include>
css/${content}.css
</body>
</html>