<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
    <form action="login" method="post">
    <table>
      <tr>
        <td><input type="text" name="uId" placeholder="아이디"></td>
      </tr>
      <tr>
        <td><input type="password" name="uPw" placeholder="비밀번호"></td> 
      </tr>
      <tr>
        <td></td>
      </tr>
    </table>
    <input type="submit" value="로그인">
    </form>
  </body>
</html>