package kr.itedu.boardmvc.service;
//클래스 스태틱을 통해 메소드로 바로접근이 가능하다.
import java.util.ArrayList;



import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.common.BoardDAO;
import kr.itedu.boardmvc.common.BoardPaging;

public class BoardListService {
	
	public ArrayList<BoardVO> getBoardList(int btype, int countPage, int page) {
		ArrayList<BoardVO> result = null;
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.getBoardList(btype, countPage, page);
		System.out.println("complete board list action service");
		//System.out.println("board1 bid : "+result.get(1).getBid());
		return result;
	}
	
	public BoardVO getBoardDetailList(int btype, int bid) {
		BoardVO result = new BoardVO();
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.getBoardDetail(btype, bid);
		//pull test
		//commit test
		return result;
	}
}
