package day03.task2;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import day03.task2.WaitDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/wait")
public class WaitController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		WaitDto waitDto = mapper.readValue(req.getReader(), WaitDto.class);
		System.out.println(waitDto);
		boolean result = WaitDao.getInstance().write(waitDto);
		System.out.println(result);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 int num = Integer.parseInt(req.getParameter("num"));
	 boolean result = WaitDao.getInstance().delete(num);
	 	System.out.println(result);
	} 
}
