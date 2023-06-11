package project;

public class VideoReview {
	//변수 생성
	private int videoNo;
	private int reviewNo;
	private String nickName;
	private String content;
	
	
	//생성자 생성
	public VideoReview() {}
	public VideoReview(int videoNo, int reviewNo, String nickName, String content) {
		this.videoNo = videoNo;
		this.reviewNo = reviewNo;
		this.nickName = nickName;
		this.content = content;
	}
	
	//getter, setter 설정
	public int getVideoNo() {
		return videoNo;
	}
	public void setVideoNo(int videoNo) {
		this.videoNo = videoNo;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	//toString() 오버라이딩
	@Override
	public String toString() {
		return "VideoReview [videoNo=" + videoNo + ", reviewNo=" + reviewNo + ", nickName=" + nickName + ", content="
				+ content + "]";
	}
	
	
	

	
	
	
	
	
	

}
