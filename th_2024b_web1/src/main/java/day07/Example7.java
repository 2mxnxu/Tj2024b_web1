package day07;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/day07/example7")
public class Example7 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// [1] 톰캣 안에 있는 객체 호출 및 생성
		HttpSession httpSession = req.getSession();
		System.out.println(httpSession); // HTTP 요청한 클라이언트 브라우저의 세션 객체 주소 // org.apache.catalina.session.StandardSessionFacade@5792c623
		// [2] 세션 객체의 주요 메소드
		System.out.println(httpSession.getAttributeNames()); 	// 세션 객체내 모든 속성 반환 함수 	// java.util.Collections$3@595532a1
		System.out.println(httpSession.getCreationTime());	 	// 세션 객체가 만들어진 시간 		// 1737705680045
		System.out.println(httpSession.getId());			 	// 세션 객체의 아이디/식별자 		// 749A7A800C08B39AB8136C02B1C77947
		System.out.println(httpSession.getLastAccessedTime());	// 마지막으로 세션 객체 사용한 시간 	// 1737705680045
		System.out.println(httpSession.isNew());				// 새로 만들어진 세션 인지 여부 반환	// true
		
		// [3] 세션 객체의 속성명과 속성값
		httpSession.setAttribute("세션속성1", "유재석");
		
		// [4] 세션 객체의 지정한 속성명의 값 호출
		Object object = httpSession.getAttribute("세션속성1");
		System.out.println((String)object);
		
		// [5] 세션 객체의 지정한 속성 제거
		httpSession.removeAttribute("세션속성1");
	}
}
