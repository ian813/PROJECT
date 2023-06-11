package project;

import java.util.Scanner;

public class SsafitUtil {
	// 입력값을 받기 위한 scanner 생성
	Scanner sc = new Scanner(System.in);
	
	// 기본 생성자 생성
	public SsafitUtil() {}
	
	// 문자열을 입력받을 수 있는 메서드 생성
	public String input(String msq) {
		String output = sc.nextLine();
		return output;
	}
	
	
	// 정수값을 입력받을 수 있는 메서드 생성
	public int inputInt(String msq) {
		int output = sc.nextInt();
		return output;
	}
	
	// 경계선을 출력해줄 메서드 생성
	public void printLine() {
		System.out.println("--------------------------------------------------------");
	}
	

	// 화면을 지우기 위한 메서드 생성...
	// 구현이 어려워서...
	// 80줄을 개행하는 것으로 대체..
	public void screenClear() {
		for(int i = 0; i < 80; i++) {
			System.out.println("");
		}
	}
	
	
}