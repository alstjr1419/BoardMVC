package kr.itedu.boardmvc.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.beans.editors.IntegerEditor;

import kr.itedu.boardmvc.*;
import java.util.*;
import kr.itedu.boardmvc.common.*;
import kr.itedu.boardmvc.service.BoardListService;

public class BoardListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		forward.setPath(Var.TEMPLATE_1);
		
		BoardListService service = new BoardListService();
		int btype = Utils.getParamInt(request.getParameter("btype"));//jsp입력해야한다.
		if(btype == -1) {
			btype = 1;
		}
		int countPage = 10;
		int page = Utils.getParamInt(request.getParameter("page"));
		if(page == -1){
			page = 1;
		}
		
		ArrayList<BoardVO> data = service.getBoardList(btype, countPage, page);
		int maxPage = (int) BoardPaging.maxPage;
		System.out.println(maxPage);
		request.setAttribute("title", Var.TITLES[btype]);
		request.setAttribute("content", "boardList");
		request.setAttribute("btype", btype);
		request.setAttribute("data", data);
		request.setAttribute("maxPage", maxPage);
		return forward;
	}

}