<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error/error.jsp" %>    
<!DOCTYPE html>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kr.itedu.boardmvc.*" %>

<% 
	BoardVO detail = (BoardVO)request.getAttribute("data");	
%>
<%-- result.clear(); --%>
<html>
<link rel="stylesheet" type="text/css" href="jsp/css/common.css">
<link rel="stylesheet" type="text/css" href="jsp/css/boardList.css">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, tr, th, td{
	border : 1px solid black;
	}
</style>
</head>
<body>
	<h1>게시판</h1>
	<%if(detail == null){ %>
		<p>게시판에 내용이 없습니다.</p>
	<%} else {%>
	
	<div class="container">
		<h1><a href="javascript:history.back()"><%=detail.getBtitle() %></a></h1>
		<table>
			<tr>
				<th>번호</th>
				<th id="title">내용</th>
				<th>등록일시</th>
			</tr>
			
			<tr>
				<td><%=detail.getBid() %></td>
				<td><%=detail.getBcontent() %></td>
				<td><%=detail.getBregdate() %></td>
			</tr>
		</table>
		<form action="update.do">
		<INPUT TYPE="hidden" NAME="bid" value='<%=detail.getBid()%>'>
		<input type="submit" value="수정">
		</form>
		<form action="delete" method="get">
		<INPUT TYPE="hidden" NAME="bid" value='<%=detail.getBid()%>'>
		<input type="submit" value="삭제">
		</form>
	</div>
	<%}%>
</body>
</html>