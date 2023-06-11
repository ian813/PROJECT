package project;

// 찾으려는 비디오가 없을 때
// 예외 만들기
public class VideoNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 예외가 생겼을 때 띄워줄 메시지를 구현..
	public VideoNotFoundException(String message) {
		// Exception 클래스로 message 보내기
		super(message);
	}
}
