package kr.itedu.boardmvc.common;

import static kr.itedu.boardmvc.common.DBConnector.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import kr.itedu.boardmvc.BoardVO;

public class BoardDAO {
	private static BoardDAO dao;
	
	private BoardDAO() {}; //private 생성자
	
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO(); //다오의 값이 없으면 다오를 생성한다. 하나의주소값만을 가진다.
									//널이 아니면 기존의 주소값만을 이용하기 때문이다.
									//이것이 싱글톤이다.
		}
		return dao;
	}
	
	public ArrayList<BoardVO> getBoardList(int btype, int countPage, int page) {
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		BoardPaging bp = new BoardPaging(btype, countPage, page);
		int startCount = bp.startCount;
		int endCount = bp.endCount;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println("btype");
		System.out.println("startCount : " + startCount);
		System.out.println("endCount : " + endCount);
		
		 try {
			con = getConn();
			String sql = String.format( " select * from "
					+ " (select rownum as rnum, z.*from " 
					+ " (select * from t_board1 " 
					+ " order by bid desc) z where rownum <= %d )"
					+ " where rnum >=%d ",endCount, startCount);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bregdate = rs.getString("bregdate");
				BoardVO bo = new BoardVO();
				bo.setBid(bid);
				bo.setBtitle(btitle);
				bo.setBcontent(bcontent);
				bo.setBregdate(bregdate);
				result.add(bo);
				System.out.println("boarddao > get board list" + btype);
			}
		} catch (SQLException e) {
			//TODO: 예외처리
		}catch (Exception e) {
			//TODO: 예외처리
		} finally {
			close(con, ps, rs);
		}
		 
		
		return result;
	}
	
	public BoardVO getBoardDetail(int btype ,int bid) {
		BoardVO result = new BoardVO();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 try {
			con = getConn();
			String sql = String.format( " select "
					+ " bid, btitle, bcontent, " 
					+ " to_char(bregdate, 'YYYY-MM-DD hh24:mi') as bregdate " 
					+ " from t_board%d where bid = %d "
					 ,btype, bid);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int dataBid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bregdate = rs.getString("bregdate");
				
				result.setBid(dataBid);
				result.setBtitle(btitle);
				result.setBcontent(bcontent);
				result.setBregdate(bregdate);
				
				
			}
		} catch (SQLException e) {
			//TODO: 예외처리
		}catch (Exception e) {
			//TODO: 예외처리
		} finally {
			close(con, ps, rs);
		}
		 
		
		return result;
	}

	public int getBoardTotalCount(int btype) {
		int totalCount=0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 try {
			con = getConn();
			String sql = String.format( " select "
					+ " count(*) as totalCount " 
					+ " from t_board%d ",btype);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				totalCount = rs.getInt("totalCount");
				
				System.out.println("카운트 완료" + totalCount);
			}
		} catch (SQLException e) {
			//TODO: 예외처리
		}catch (Exception e) {
			//TODO: 예외처리
		} finally {
			close(con, ps, rs);
		}
		return totalCount;
	}
}
