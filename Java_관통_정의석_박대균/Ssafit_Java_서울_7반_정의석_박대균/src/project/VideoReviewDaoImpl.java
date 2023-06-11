package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class VideoReviewDaoImpl implements VideoReviewDao {
	
	//input함수를 쓰기위해 생성
	SsafitUtil util = new SsafitUtil(); 
	
	//리뷰 리스트를 담아둘 맵 생성
	HashMap<Integer, ArrayList<VideoReview>> videoReviewDb = new HashMap<Integer, ArrayList<VideoReview>> ();
	
	
	//싱글톤 패턴
	//1. 같은 클라스이니까 자기자신 생성
	private static VideoReviewDaoImpl instance = new VideoReviewDaoImpl(); 
	//프라이빗으로 생성자 막기
	private VideoReviewDaoImpl() { }
	//생성한 인스턴스를 가져다 쓸수 있도록 getinstance함수 생성
	public static VideoReviewDaoImpl getInstance() {
		return instance;
	}
	
	//  MainUi, VideoDaoImpl 객체 생성
	MainUi mainUi = new MainUi();
	
	VideoDaoImpl videoDaoImpl = VideoDaoImpl.getInstance();
	
	//비디오리뷰리스트 맵의 키값을 미리 모두 생성하는 메서드
	//1~8까지 키값 생성
	public HashMap<Integer, ArrayList<VideoReview>> makeMap() {
		videoReviewDb.put(1,new ArrayList<>());
		videoReviewDb.put(2,new ArrayList<>());
		videoReviewDb.put(3,new ArrayList<>());
		videoReviewDb.put(4,new ArrayList<>());
		videoReviewDb.put(5,new ArrayList<>());
		videoReviewDb.put(6,new ArrayList<>());
		videoReviewDb.put(7,new ArrayList<>());
		videoReviewDb.put(8,new ArrayList<>());
		return videoReviewDb;
	}
	
	
	//비디오리뷰리스트 맵의 특정 비디오의 리뷰를 추가하는 메서드
	@Override
	public void insertReview(int videoNo) throws IOException, VideoNotFoundException {
		if(videoReviewDb.containsKey(videoNo)) { //입력받은 비디오 넘버가 있다면

			int videoNo1 = videoNo; //입력받은 비디오 넘버 저장
			int reviewNo1 = videoReviewDb.get(videoNo).size()+1; //현제 리뷰리스트 사이즈+1을 해서 리뷰 넘버링 생성
			
			System.out.print("닉네임을 선택하세요 : ");
			String nickName1 = util.input("msq");//닉네임 입력 받기
			System.out.print("내용을 입력하세요 : ");
			String content1 = util.input("msq");//내용 입력 받기
			
			//입력받은 내용으로 비디오 리뷰 생성
			VideoReview vr1 = new VideoReview (videoNo1, reviewNo1, nickName1,content1); 
			//생성한 리뷰를 Map에 저장
			videoReviewDb.get(videoNo).add(vr1);
		}
		
		// 리뷰 생성이 끝나면
		// 화면을 지워준다.
		util.screenClear();
		// selectReview를 써서 방금 등록된 리뷰의 정보를 띄워준다.
		selectReview(videoNo);
//		mainUi.service();
	}
	
	
	//비디오리뷰리스트 맵에서 입력받은 비디로 넘버의 리뷰를 출력해주는 메서드
	@Override
	public ArrayList<VideoReview> selectReview(int videoNo) throws VideoNotFoundException {
		if(videoReviewDb.containsKey(videoNo)) {//입력받은 비디오 넘버가 있다면
			util.printLine();
			System.out.println("번 호 : " + videoNo);
			System.out.println("제 목 : " + videoDaoImpl.selectVideoByNo(videoNo).getTitle());
			System.out.println("운 동 : " + videoDaoImpl.selectVideoByNo(videoNo).getPart());
			System.out.println("영 상 URL : " + videoDaoImpl.selectVideoByNo(videoNo).getUrl());
			util.printLine();
			System.out.println("영 상 리 뷰  : "+videoReviewDb.get(videoNo).size());//해당 비디오의 리뷰 갯수 출력
			util.printLine();
			for (int i = 0; i<videoReviewDb.get(videoNo).size() ; i++){
				util.printLine();
				System.out.println("닉 네 임 : " + videoReviewDb.get(videoNo).get(i).getNickName());
				util.printLine();
				System.out.println("리 뷰 내 용 : " + videoReviewDb.get(videoNo).get(i).getContent());//해당 비디오의 리뷰 모두 출력
			}
			
			util.printLine();
			
		}
		return videoReviewDb.get(videoNo);
	}
	

}
	
