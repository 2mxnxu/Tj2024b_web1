package web.controller.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.BoardDao;

@WebServlet("/board/reply")
public class ReplyController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("board reply post ok");
		
		// 1.[HTTP 요청의 header body 자료(JSON)를 자바(DTO)로 받는다.]
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = mapper.readValue(req.getReader(), HashMap.class);
		
		// 댓글쓰기는 회원제 이므로 현재 로그인된 정보 찾기
			// 세션에 저장된 로그인된 회원번호 조회
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginMno");
		
		boolean result = false;
		if(object == null) {

		}else { // 로그인 상태
			// 2. 로그인된 회원번호를 정수로 타입변환
			int loginMno = (Integer)object;
			// 3. 데이터에 담기
			map.put("mno", loginMno+"");
			
			result = BoardDao.getInstance().replyWrite(map);
		}
		// 2.[ 데이터 유효성검사 ]
		// 3.[ DAO 에게 데이터 전달 하고 응답 받기 ]
		// 4.[ 자료(DTO/자바)타입을 JS(JSON)타입으로 변환한다.]
		// 5.[ HTTP 응답의 header body 로 application/json 으로 응답/반환하기]
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("board reply get ok");
		int bno = Integer.parseInt(req.getParameter("bno"));
		List< Map<String, String> > result = BoardDao.getInstance().replyFindAll( bno );
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
	}
}
