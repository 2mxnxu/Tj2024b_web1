package day02;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day02/example2")
public class Example2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 쿼리스트링의 매개변수 가져오기
			// .getParameter("URL경로상의 매개변수명"); // 매개변수명 값(String타입) 반환함수, 없으면 NULL
		System.out.println("1] URL ? 뒤에 'name'이라는 매개변수명을 가진 변수의 값 가져오기");
		System.out.println(req.getParameter("name"));
		
		System.out.println("1] URL ? 뒤에 'age'이라는 매개변수명을 가진 변수의 값 가져오기");
		System.out.println(req.getParameter("age"));
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("2] 사용자가 서버로부터 post 메소드로 요청 했습니다.");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.printf("name : %s, age : %s", name, age);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("3] 사용자가 서버로부터 put 메소드로 요청 했습니다.");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.printf("name : %s, age : %s", name, age);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("4] 사용자가 서버로부터 delete 메소드로 요청 했습니다.");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.printf("name : %s, age : %s", name, age);
	}
}
