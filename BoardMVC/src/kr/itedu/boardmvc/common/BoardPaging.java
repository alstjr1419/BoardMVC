package kr.itedu.boardmvc.common;

public class BoardPaging {
	int totalCount;
	int countPage;
	int page;
	int startCount;
	int endCount;
	public static double maxPage;
	BoardPaging(int btype, int countPage, int page){
		BoardDAO dao = BoardDAO.getInstance();
		int totalCount = dao.getBoardTotalCount(btype);
		int startCount = (page - 1) * countPage + 1;
		int endCount = page * countPage;
		double maxPage = Math.ceil((double)totalCount/(double)page);
		this.totalCount = totalCount;
		this.startCount = startCount;
		this.endCount = endCount;
		this.countPage = countPage;
		this.page = page;
		BoardPaging.maxPage = maxPage; 
	}
	
	
}
