package kr.itedu.boardmvc;

public class ActionForward {
	private String path;
	private boolean isRedirect;
	
	public String getPath() {
		return path;
	}//주소
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}//다이렉트 구분
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}
