package project;

import java.io.IOException;

public class VideoReviewUi {
	
	// 싱글톤 패턴을 구현해보자.
	// 1. 클래스 생성자를 private으로 막아주기
	private VideoReviewUi() {};
	
	// 2. VideoUi 객체를 생성
	private static VideoReviewUi reviewUiInstance = new VideoReviewUi();
	
	// 3. VideoUi 객체를 return값으로 하는 메서드 생성
	public static VideoReviewUi getInstance() {
		return reviewUiInstance;
	}
	
	// VideoUi, SsafiUtil 객체 생성
	VideoUi videoUi = VideoUi.getInstance();
	SsafitUtil util = new SsafitUtil();
	VideoReviewDaoImpl videoReviewDaoImpl = VideoReviewDaoImpl.getInstance();
	
	// VideoUi 화면을 구현해보자..
	public void service() throws IOException, VideoNotFoundException {
		// 메뉴 선택 문자열 변수 생성
		String msq = "선택";
		
		// 화면 구현
		util.printLine();
		System.out.println("1.  리 뷰 등 록");
		System.out.println("0.  이 전 으 로");
		util.printLine();
		System.out.print("메 뉴 를  선 택 하 세 요 : ");
		
		// 메뉴 선택 입력할 변수 생성
		int menuNo = util.inputInt(msq);
		if(menuNo == 1) {
			// 만약 입력값이 1이면
			
		} else if(menuNo == 0) {
			// 만약 입력값이 0이면
			// 화면을 지우고
			// videoUi로 이동
			util.screenClear();
			videoUi.service();
		}
	}
	
	
}
