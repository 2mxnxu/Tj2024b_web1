package web.controller.chatting;

import java.util.List;
import java.util.Vector;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

// 서블릿 클래스가 아닌 웹소켓 클래스로 사용할 예정
@ServerEndpoint("/chatsocket")
public class ServerSocket {
	
	// [*] 접속된 세션(접속성공한 클라이언트 소켓정보)
	// * 세션이란? 네트워크 상의 정보를 저장하는 공간, HTTP 세션 vs WS 세션
	// * static  이란? 프로젝트내 하나의 변수를 만들때 사용되는 키워드 , 전역변수
	private static List<Session> 접속명단 = new Vector<>();
	
	// [1] 클라이언트 소켓이 서버소켓에 접속을 했을 때, onOpen
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("클라이언트가 서버에 접속 성공");
		System.out.println(session);
		// * onOpen(클라이언트가 정상적으로 서버와 접속 성공했을 때)
		접속명단.add(session); // list 컬렉션에 접속 성공한 session 정보를 저장한다
		System.out.println(접속명단);
	}
	// [2] 클라이언스 소켓이 서버소켓으로 부터 메시지를 보냈을 때, onMessage
	@OnMessage
	public void opMessage(Session session, String message) {
		System.out.println("클라이언트 소켓으로 부터 메시지 왔다.");
		System.out.println(message);
		
		// * 서버가 클라이언트 에게 메시지 전송
		// try {
		// session.getBasicRemote().sendText("클라이언트 소캣 안녕!");
		// }catch (Exception e) {
		// 	System.out.println(e);
		// }
		
		// 반복문 이용한 접속 명단 순화
		for(int index = 0; index <= 접속명단.size()-1; index++) {
			// 접속된 명단의 index 번째 세션(접속정보) 가져오기
			Session clientSocket = 접속명단.get(index);
			
			try {
				clientSocket.getBasicRemote().sendText(message);
			}catch (Exception e) {
				System.out.println(e);
			}
		}
		
		}
	// [3] 클라이언트 소켓이 나갔을 때(클라이언트 소켓(객체)의 포함된 JS 가 새로고침이 실행되는 함수
			@OnClose
			public void onClose(Session session) {
				접속명단.remove(session);
			}
}
