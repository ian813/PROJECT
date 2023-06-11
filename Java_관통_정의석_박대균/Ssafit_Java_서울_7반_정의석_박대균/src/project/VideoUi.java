package project;

import java.io.IOException;

public class VideoUi{
	
	// 싱글톤 패턴을 구현해보자.
	// 1. 클래스 생성자를 private으로 막아주기
	private VideoUi() {};
	
	// 2. VideoUi 객체를 생성
	private static VideoUi videoUiInstance = new VideoUi();
	
	// 3. VideoUi 객체를 return값으로 하는 메서드 생성
	public static VideoUi getInstance() {
		return videoUiInstance;
	}
	
	// SsafitUtil, VideoDaoImpl, VideoReviewUi, VideoReviewDaoImpl 객체 생성
	SsafitUtil util = new SsafitUtil(); 
	
	VideoDaoImpl videoDaoImpl = VideoDaoImpl.getInstance();
	
	VideoReviewUi videoReviewUi = VideoReviewUi.getInstance();
	
	VideoReviewDaoImpl videoReviewDaoImpl = VideoReviewDaoImpl.getInstance();
	
	
	// 목적 : service 화면 구현
	public void service() throws IOException, VideoNotFoundException {
		// 메뉴 선택 변수 생성
		String msq = "메뉴 선택";
		
		// videoReviewDb 맵을 생성해주자.
		videoReviewDaoImpl.makeMap();
		
		// 화면 구현
		videoDaoImpl.selectVideo();
		// 화면 구현
		util.printLine();
		System.out.println("1.  영 상 상 세");
		System.out.println("0.  이 전 으 로");
		util.printLine();
		System.out.print("메 뉴 를  선 택 하 세 요 : ");
		int selectMenu = util.inputInt(msq);
		// 입력한 값이 1이면 영상 번호 입력줄이 생성..
		if (selectMenu == 1) {
			System.out.print("영 상 번 호 를  선 택 하 세 요 : ");
			// 영상 번호 선택
			int videoNo = util.inputInt(msq);

			// 영상 번호가 1~8이면 영상 상세 화면 생성
			if(videoNo >= 1 && videoNo <= 8) {
				// 일단 화면을 깨끗하게 만들고..
				util.screenClear();
				// 영상 상세 화면
				util.printLine();
				System.out.println("번 호 : " + videoNo);
				System.out.println("제 목 : " + videoDaoImpl.selectVideoByNo(videoNo).getTitle());
				System.out.println("운 동 : " + videoDaoImpl.selectVideoByNo(videoNo).getPart());
				System.out.println("영 상 URL : " + videoDaoImpl.selectVideoByNo(videoNo).getUrl());
				util.printLine();
				util.printLine();
				System.out.println("영 상 리 뷰 : " + "0" + "개");
				util.printLine();
				// 리뷰 리스트 가져오는 건 구현 못했습니다..
				util.printLine();
				System.out.println("1.  리 뷰 등 록");
				System.out.println("0.  이 전 으 로");
				util.printLine();
				System.out.print("메 뉴 를  선 택 하 세 요 : ");
				int selectMenu2 = util.inputInt(msq);
				util.printLine();
				// 만약 1번 메뉴를 선택하면 리뷰 등록 화면으로 이동
				if(selectMenu2 == 1) {
					util.screenClear();
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
						// insertReview 메서드 실행
						videoReviewDaoImpl.insertReview(videoNo);
					} else if(menuNo == 0) {
						// 만약 입력값이 0이면
						// 화면을 지우고
						// videoUi로 이동
						util.screenClear();
						videoUiInstance.service();
					}
				} 
				// 만약 2번 메뉴를 선택하면 화면을 지우고
				// 영상 목록 화면을 다시 띄움.
				else if(selectMenu2 == 0) {
					util.screenClear();
					videoUiInstance.service();
				}
				// 만약 1, 2번이 아닌 잘못된 입력을 하면
				// 화면을 지우고
				// 잘못 입력했다는 문구를 띄우고 영상 목록 화면으로 이동
				else {
					util.screenClear();
					util.printLine();
					System.out.println("잘못 입력했습니다. 영상 목록 화면으로 돌아갑니다.");
					this.service();
				}
			}
			
		} else if(selectMenu == 0) {
			// 입력한 값이 0이면 화면을 지우고
			util.screenClear();
			// mainUi화면으로 전환
			// mainUi화면 전환을 위해 MainUi 객체 생성
			MainUi mainUi = new MainUi();
			mainUi.service();
		} else {
			// 입력한 값이 0, 1이 아니면
			// 화면을 지우고
			// 다시 입력하라는 문구를 만든 뒤 영상 목록 화면을 띄움.
			util.screenClear();
			util.printLine();
			System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
			this.service();
		}
		
	}


}
