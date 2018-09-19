<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">    
<link rel="stylesheet" type="text/css" href="jsp/css/manu.css">
<title></title>
</head>
<body>
	<div>
      <ul>
        <li><a href="boardList">홈</a></li>
        <li><a href="#">게시판</a>
          <ul>
            <li><a href='?btype=1'>게시판1</a></li>
            <li><a href='?btype=2'>게시판2</a></li>
            <li><a href='?btype=3'>게시판3</a></li>
             
          </ul>
        </li>
      </ul>
    </div>
</body>
</html>