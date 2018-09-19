package kr.itedu.boardmvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.action.Action;
import kr.itedu.boardmvc.action.BoardDetailAction;
import kr.itedu.boardmvc.action.BoardListAction;
import kr.itedu.boardmvc.action.BoardUpdateAction;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	//주석도 되나..?
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String reqURI = request.getRequestURI(); //전체주소 (뒤)
		String ctxPath = request.getContextPath(); //루트 주소 값 (앞)
		String comd = reqURI.substring(ctxPath.length());//~부터 시작해서 ~ 길이만큼 자르겟다
		ActionForward forward = null; //주소값과 다이렉트 디스패쳐의 구분값을 담는다.
		Action action = null;	//인터페이스 액션 생성
		
		if(comd.equals("/boardList.bo")) {//주소에 boardList.bo가 입력되었을때
			action = new BoardListAction(); //인터페이스 자식 객체 생성
			try {
				forward = action.execute(request, response); //request, response받기 , param값 세팅, 보낼곳 적기
			} catch (Exception e) {
				//TODO++: 예외처리
				e.printStackTrace();
			}
			
		}else if(comd.equals("/boardDetail.bo")){
			action = new BoardDetailAction(); //인터페이스 자식 객체 생성
			try {
				forward = action.execute(request, response); //request, response받기 , param값 세팅, 보낼곳 적기
			} catch (Exception e) {
				//TODO++: 예외처리
				e.printStackTrace();
			}
		}else if(comd.equals("/update.bo")){
			action = new BoardUpdateAction(); //인터페이스 자식 객체 생성
			try {
				forward = action.execute(request, response); //request, response받기 , param값 세팅, 보낼곳 적기
			} catch (Exception e) {
				//TODO++: 예외처리
				e.printStackTrace();
			}
		}
		
		if(forward != null){//forward에 값이 담겼을때 
			if(forward.isRedirect()) {	//redirect일때
				response.sendRedirect(forward.getPath());	//받은 path값으로 이동
			}else { //redirect가 아닐때 (dispatcher일때)
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath()); 
				rd.forward(request, response); //디스패쳐 및 포워드 실행
			}
		}else {
			//TODO 없는 주소값 에러페이지 디스플레이 처리
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}

}
