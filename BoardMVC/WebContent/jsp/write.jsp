<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8"); %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kr.itedu.boardmvc.*" %>
<% 
	BoardVO detail = (BoardVO)request.getAttribute("detailList");	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 페이지</title>
</head>
<body>
	<div>
		<form action="write" method="post">
			<%if(detail!=null){ %>
			<INPUT TYPE="hidden" NAME="insertOrUpdate" value='<%=detail.getBid()%>'>
			<%}else{ %>
			<INPUT TYPE="hidden" NAME="insertOrUpdate" value='0'>
			<%} %>
			<table>
				<tr>
					<th>글쓰기</th>
				</tr>
				<tr>
					<%if(detail!=null){ %>
					<td>제목<input type="text" name="btitle" value="<%=detail.getBtitle() %>">
					</td>
					<%}else{ %>
					<td>제목<input type="text" name="btitle">
					</td>
					<%} %>
				</tr>
				<tr>
				<%if(detail!=null){ %>
					<td>내용<textarea rows="4" cols="30" name="bcontent" >
							<%=detail.getBcontent() %>
						</textarea>
					</td>
				<%}else{ %>
					<td>내용<textarea rows="4" cols="30" name="bcontent"></textarea></td>
				<%} %>
					
				</tr>
			</table>
			<input type="submit" value="완료"><input type="button" value="취소">
		</form>
	</div>
</body>
</html>