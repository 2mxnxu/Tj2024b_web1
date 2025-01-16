package day02.task2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day02/waitting")
public class WaitController extends HttpServlet{
	
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String callnum = req.getParameter("callnum");
	 int person = Integer.parseInt(req.getParameter("person"));
	 
	 boolean result = WaitDao.getInstance().write(callnum, person);
		System.out.println(result);
}
 @Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 int num = Integer.parseInt(req.getParameter("num"));
	 boolean result = WaitDao.getInstance().delete(num);
	 	System.out.println(result);
	} 
}