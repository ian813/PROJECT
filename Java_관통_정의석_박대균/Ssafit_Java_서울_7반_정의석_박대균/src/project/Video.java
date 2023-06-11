package project;

public class Video {
	// Video에 필요한 멤버 변수 만들기
	private int no;
	private String title;
	private String part;
	private String url;
	
	// 클래스를 사용하기 위해 생성자 만들기
	
	public Video() {};
	
	public Video(int no, String title, String part, String url) {
		super();
		this.no = no;
		this.title = title;
		this.part = part;
		this.url = url;
	}
	
	// 게터, 세터
	// 멤버 변수가 private이므로 멤버 변수에 접근하기 위해 필요.
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	// 주소값이 아닌 내용들을 출력하는게 필요하므로...
	@Override
	public String toString() {
		return "Video [no=" + no + ", title=" + title + ", part=" + part + ", url=" + url + "]";
	}
	
	
}
