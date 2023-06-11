package com.ssafy.dto;

public class Review {
	
	private int num; // 리뷰 번호
	private String id; // 제목
	private String nickName; // 닉네임
	private String title; // 리뷰제목
	private String content; // 리뷰내용
	
	public Review() {}
	
	public Review(int num, String nickName, String title, String content) {
		this.num = num;
		this.nickName = nickName;
		this.title = title;
		this.content = content;
	};
	
	public Review(int num, String id, String nickName, String title, String content) {
		this.num = num;
		this.id = id;
		this.nickName = nickName;
		this.title = title;
		this.content = content;
	}



	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Review [num=" + num + ", id=" + id + ", nickName=" + nickName + ", title=" + title + ", content="
				+ content + "]";
	}


	
}
