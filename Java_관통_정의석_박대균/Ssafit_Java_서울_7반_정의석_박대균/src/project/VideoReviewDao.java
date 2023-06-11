package project;

import java.io.IOException;
import java.util.ArrayList;

public interface VideoReviewDao {
	
	//비디오 넘버를 입력받아 해당 비디오에 리뷰를 달아주는 코드
	void insertReview(int videoNo) throws IOException, VideoNotFoundException;
	//비디오 넘버를 입력받아 해당하는 비디오의 리뷰를 모두 보여주는 코드
	ArrayList<VideoReview> selectReview(int videoNo) throws VideoNotFoundException;
}
