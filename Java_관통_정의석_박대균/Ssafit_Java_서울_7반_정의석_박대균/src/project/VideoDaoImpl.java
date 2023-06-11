package project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class VideoDaoImpl implements VideoDao {
	// Video를 넣을 수 있는 ArrayList
	ArrayList<Video> videoList = new ArrayList<>();
	
	// 싱글톤 패턴 구현하기
	private VideoDaoImpl() {}
	
	private static VideoDaoImpl instance = new VideoDaoImpl();
	
	public static VideoDaoImpl getInstance() {
		return instance;
	}
	
	SsafitUtil util = new SsafitUtil();
	
	
	// 목적 : 모든 비디오목록 가져오기
	@Override
	public ArrayList<Video> selectVideo() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/video.json")));
		String str = null; 
		StringBuilder sb = new StringBuilder();
		while((str = br.readLine())!= null) {
			sb.append(str).append("\n");
		}
		// While 끝나면 지슨파일 문자열로 저장 됨
		Gson gson = new Gson();
		
		// 지슨파일 데이터를 받아서 배열에 넣어주기
		Video[] arr = gson.fromJson(sb.toString(), Video[].class);
		
		// 배열에 있는 데이터를 videoList에 넣어주기
		for (int i = 0; i <8; i++) {
			videoList.add(arr[i]);
		
		}
		// 화면 구현
		util.printLine();
		System.out.println("전체 8개");
		util.printLine();
		
		// 번호와 비디오 타이틀 받기
		for(int i = 0; i<8;i++) {
			int num = i+1;
			System.out.println(num +"  "+videoList.get(i).getTitle());
			
		}
		util.printLine();
		
		
		return videoList;
	}
	// 목적 : 비디오 no로 알맞은 비디오 찾기
	@Override
	public Video selectVideoByNo(int no) throws VideoNotFoundException {
		
		// videoList 안에 있는 video들을 탐색
		for(Video video : this.videoList) {
			// video의 no가 입력된 no와 같으면
			// video를 return!
			if(video.getNo() == no) {
				return video;
			}
		}
		// 만약 적절한 video를 찾지 못했다면
		// null 반환
		throw new VideoNotFoundException("비디오를 찾을 수 없습니다.");
	}
	
	
	
	
}
