package day03.task4;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import day03.task3.VisitDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/wait2")
public class WaitController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		WaitDto waitDto = mapper.readValue(req.getReader(), WaitDto.class);
		boolean result = WaitDao.getInstance().write(waitDto);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<WaitDto> result = WaitDao.getInstance().findAll();
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");			
		resp.getWriter().print(jsonResult);	
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		WaitDto waitDto = mapper.readValue(req.getReader(), WaitDto.class);
		boolean result = WaitDao.getInstance().update(waitDto);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		boolean result = WaitDao.getInstance().delete(num);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
}
