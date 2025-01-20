package day03;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example3")
public class Example3 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// JSON자료의 문자열 타입을 DTO로 변환해보기 (JSON은 JS언어에서 사용하는 타입, java는 DTO 사용)
		System.out.println("HTTP * POST 방식으로 요청이 왔어요");
		//System.out.println(req.getReader().readLine());
		ObjectMapper mapper = new ObjectMapper();
		// req.getReader() 객체의 자료(JSON)들을 DTO 객체로 변환 함수
		// .readValue(JSON데이터객체 자료, 변환할객체타입.class)
		DataDto dataDto =  mapper.readValue(req.getReader(), DataDto.class);
		System.out.println(dataDto);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HTTP * PUT 방식으로 요청이 왔어요");
		ObjectMapper mapper = new ObjectMapper();
		DataDto dataDto =  mapper.readValue(req.getReader(), DataDto.class);
		System.out.println(dataDto);
	}
}
