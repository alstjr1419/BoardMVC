package kr.itedu.boardmvc.action;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;

public interface Action {
	ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, NamingException;
	//기본형은 퍼블릭이다. 구현을 해야하기 때문이다. abstract로 기본적으로 적혀있다. 추상화이기 떄문.
}
