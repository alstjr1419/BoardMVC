<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error/error.jsp" %>    
<!DOCTYPE html>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kr.itedu.boardmvc.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% 
	ArrayList<BoardVO> result = (ArrayList<BoardVO>)request.getAttribute("data");
%>
<%-- result.clear(); --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<%String btype = request.getParameter("btype"); %>
<%int maxPage = Integer.parseInt(request.getParameter("maxPage")); %>
</head>
<body>

	<%if(result.isEmpty()){ %>
		<p>게시판에 내용이 없습니다.</p>
	<%}else{ %>
	
	<div class="container">
		<table>
			<tr>
				<th>번호</th>
				<th id="title">제목</th>
				<th>등록일시</th>
			</tr>
			
<%

for(BoardVO vo : result){%>
			<tr>
				<td><a href="boardDetail.bo?bid=<%=vo.getBid() %>&btype=<%=btype%>"><%=vo.getBid() %></a></td>
				<td><%=vo.getBtitle() %></td>
				<td><%=vo.getBregdate() %></td>
			</tr>
<%} %>
<%} %>
		</table>

		<form action="write" method="get">
		<INPUT TYPE="hidden" NAME="bid" value='0'>
		<input type="submit" value="글쓰기">
		</form>
	</div>
	<%for(int i =0; i<maxPage; i++){ %>
<a href="boardList.bo?btype=<%=btype%>&page=<%=i%>"><%=i%></a>
	<%} %>
</body>
</html>