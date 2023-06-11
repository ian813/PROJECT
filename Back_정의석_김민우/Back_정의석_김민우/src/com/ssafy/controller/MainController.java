 package com.ssafy.controller;

 import java.io.IOException;
 import java.sql.SQLException;

 import javax.servlet.RequestDispatcher;
 import javax.servlet.ServletException;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;

import com.ssafy.dao.MainDao;
import com.ssafy.dao.MainDaoImpl;
 import com.ssafy.dto.Review;

 //이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.
 @WebServlet("/main")
 public class MainController extends HttpServlet {

 	private static final long serialVersionUID = 1L;

 	private static MainDao dao = MainDaoImpl.getInstance();

 	/**
 	 * get 방식의 요청에 대해 응답하는 메서드이다. front controller pattern을 적용하기 위해 내부적으로 process를
 	 * 호출한다.
 	 */
 	protected void doGet(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException {
 		process(request, response);
 	}

 	/**
 	 * post 방식의 요청에 대해 응답하는 메서드이다. front controller pattern을 적용하기 위해 내부적으로 process를
 	 * 호출한다.
 	 */
 	protected void doPost(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException {
 		// post 요청 시 한글 파라미터의 처리를 위해 encoding을 처리한다.
 		request.setCharacterEncoding("utf-8");
 		process(request, response);
 	}

 	/**
 	 * request 객체에서 action 파라미터를 추출해서 실제 비지니스 로직 메서드(ex: doRegist) 호출해준다.
 	 */
 	private void process(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException {
 		String action = request.getParameter("action");
 		switch (action) {
 		case "regist":
 			doRegist(request, response);
 			break;
 		case "list":
 			doList(request, response);
 			break;
 		}
 	}

 	/**
 	 * 클라이언트에서 전달된 request를 분석한 결과를 regist_result.jsp에서 볼 수 있도록 한다.
 	 * RequestDispatcher를 사용해서 regist_result.jsp로 forward한다.
 	 * 
 	 * @param request
 	 * @param response
 	 * @throws ServletException
 	 * @throws IOException
 	 */
 	private void doRegist(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException {
 		// request 객체에서 전달된 parameter를 추출한다.
 		// 문자열로 전달된 num는 숫자로 변환
 		int num = Integer.parseInt(request.getParameter("num"));
// 		String id = request.getParameter("id");
 		String nickName = request.getParameter("nickName");
 		String title = request.getParameter("title");
 		String content = request.getParameter("content");
 		

 		// 전달받은 파라미터로 Review 객체를 생성하고, attribute에 등록한다.
 		Review review = new Review(num, nickName, title, content);
 		request.setAttribute("review", review);

 		// DB에  리뷰 추가
 		try {
 			dao.insertReview(review);
 			// 세션에 지금까지 등록한 리뷰 수를 저장한다.
 			HttpSession session = request.getSession();
 			session.setAttribute("reviewCount", dao.reviewCount());
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
		

 		// JSP 화면 호출을 위해 RequestDispatcher의 forward를 사용한다.
 		// 이때 연결할 jsp의 이름을 넘겨준다. forward에서 /는 context root를 나타낸다.
 		RequestDispatcher disp = request.getRequestDispatcher("/regist_result.jsp");
 		disp.forward(request, response);

 	}

 	/**
 	 * 현재까지 등록한 리뷰 정보를 list.jsp로 forward를 통해 전달
 	 * 
 	 * @param request
 	 * @param response
 	 * @throws ServletException
 	 * @throws IOException
 	 */
 	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

 		request.setAttribute("reviews", dao.selectAllReviews());

 		// forward를 통해 list.jsp 호출
 		RequestDispatcher disp = request.getRequestDispatcher("./list.jsp");
 		disp.forward(request, response);
 	}
 }
