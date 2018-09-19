package kr.itedu.boardmvc.service;
//클래스 스태틱을 통해 메소드로 바로접근이 가능하다.
import java.util.ArrayList;



import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.common.BoardDAO;

public class BoardListService {
	
	public ArrayList<BoardVO> getBoardList(int btype) {
		ArrayList<BoardVO> result = null;
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.getBoardList(btype);
		
		return result;
	}
	
	public BoardVO getBoardDetailList(int btype, int bid) {
		BoardVO result = new BoardVO();
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.getBoardDetail(btype, bid);
		
		
		return result;
	}
}
