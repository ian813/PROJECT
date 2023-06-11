package project;

import java.io.IOException;
import java.util.ArrayList;

// Video를 관리할 인터페이스 구현
public interface VideoDao {
	
	// 비디오를 선택할 메서드...
	ArrayList<Video> selectVideo() throws IOException;
	
	// Video 클래스에 있는 no를 변수로 받아서 비디오 선택하는 메서드
	Video selectVideoByNo(int no) throws VideoNotFoundException;
	
}
