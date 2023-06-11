package project;

import java.io.IOException;

public class SsafitApplication {
	public static void main(String[] args) throws IOException, VideoNotFoundException {

		// MainUi를 객체로 생성.
		MainUi mainUi = new MainUi();
		
		// 서비스를 구현해보자!
		mainUi.service();
		
		
	}
}
