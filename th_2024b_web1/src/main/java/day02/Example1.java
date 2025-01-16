package day02;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 자바의 클래스를 서블릿 클래스로 만들기
// 1. 클래스명 extends HttpServlet

@WebServlet("/day02/example1")
public class Example1 extends HttpServlet{ 
	// Restful 구축 : 1.POST 2.GET 3.PUT 4.DELETE
	// 1. POST : dopost
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("1] HTTP 프로토콜 통신이 POST 방법으로 요청이 왔습니다.");
	}
	// 2. GET : doGet 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("2] HTTP 프로토콜 통신이 GET 방법으로 요청이 왔습니다.");
		
	
	}
	// 3. PUT
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("3] HTTP 프로토콜 통신이 PUT 방법으로 요청이 왔습니다.");
	}
	// 4. DELETE
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("4] HTTP 프로토콜 통신이 DELETE 방법으로 요청이 왔습니다.");
	}
}
