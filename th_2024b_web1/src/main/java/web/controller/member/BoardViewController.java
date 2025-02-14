package web.controller.member;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.model.dao.BoardDao;
import web.model.dto.BoardDto;

@WebServlet("/board/view")
public class BoardViewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("boardview get ok");
		int bno = Integer.parseInt(req.getParameter("bno"));
		
		BoardDto boardDto = BoardDao.getInstance().findByBno(bno);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(boardDto);
		
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
	
}
