package kr.itedu.boardmvc.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.itedu.boardmvc.*;
import kr.itedu.boardmvc.common.*;
import kr.itedu.boardmvc.service.BoardListService;

public class BoardUpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		forward.setPath(Var.TEMPLATE_3);
		
		BoardListService service = new BoardListService();
		int btype = Utils.getParamInt(request.getParameter("btype"));//jsp입력해야한다.
		int bid = Utils.getParamInt(request.getParameter("bid"));
		if(bid != -1) {
			BoardVO data = service.getBoardDetailList(btype,bid);
			request.setAttribute("data", data);
		}else {
			forward.setRedirect(true);
		}
		
		request.setAttribute("content", "boardDetail");
		request.setAttribute("btype", btype);
		
		
		return forward;
	}

}