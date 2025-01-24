package day07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day07/example5")
public class Example5 extends HttpServlet {
       
       private ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
       
       @Override
       protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
               System.out.println("/day07/example5 POST OK ");
               ObjectMapper mapper = new ObjectMapper();
               HashMap<String, String> map = mapper.readValue(req.getReader(), HashMap.class);
               System.out.println(map);
               list.add(map);
               resp.setContentType("application/json");
               resp.getWriter().print(true);
       }
       @Override
       protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
               System.out.println("/day07/example5 GET OK ");
               // 1. 요청 매개변수가 없다.
               // 2. DB처리
               // 3. HTTP 응답처리 
               ObjectMapper mapper = new ObjectMapper();
               String jsonResult = mapper.writeValueAsString( list ); // List Map 를 JSON 문자열 변환 
               resp.setContentType("application/json");
               resp.getWriter().print( jsonResult );
       } 
           
   }// c end
       