package project;

import java.io.IOException;

// MainUi 구현
public class MainUi {
	
	SsafitUtil util = new SsafitUtil(); 
	
	VideoUi videoUi = VideoUi.getInstance();
	
	// 사용자가 원할 때(1을 입력했을 때) service 실행
	public void service() throws IOException, VideoNotFoundException {
		// 메뉴 선택 변수 생성
		String msq = "메뉴 선택";
		// 화면 구현
		util.printLine();
		System.out.println("자바로 구현하는 SSAFIT");
		util.printLine();
		System.out.println("1. 영 상 정 보");
		System.out.println("0. 종 료");
		util.printLine();
		System.out.print("메 뉴 를  선 택 하 세 요 : ");
		// 메뉴 선택 값
		int menuNo = util.inputInt(msq);
		
		if(menuNo == 1) {
			// 들어온 값이 1이면
			// 화면을 지우고
			util.screenClear();
			// videoUi 화면을 불러준다.
			videoUi.service();
		} else if(menuNo == 0) {
			// 들어온 값이 0이면
			// 종료한다.
			exit();
			
		} else {
			// 입력한 값이 0, 1이 아니면
			// 다시 입력하라는 문구를 띄우고
			// 메인 화면을 다시 띄움.
			util.screenClear();
			util.printLine();
			System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
			this.service();
		}
	}
	
	// 사용자가 원하지 않으면(0을 입력했을 때) 중단
	// 화면을 지우면서 중단시키고 싶었지만...
	// 구현이 힘들어 80줄 개행으로 대체...
	public void exit() {
		for(int i = 0; i < 80; i++) {
			System.out.println("");
		}
	}

}
