package day09;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day09/example4")
public class Example4 extends HttpServlet{
	
	// 1. 파일 업로드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 현재 서블렛의 로컬 경로 알기,(즉, 서버 경로 조회)
		// req.getServletContext().getRealPath("경로"); 서버내 경로를 가져오는 함수
		String uploadPath = req.getServletContext().getRealPath("/upload");
		System.out.println(uploadPath);
		
		// 2. 만약에 업로드할 폴더가 존재하지 않으면 생성
		File file = new File(uploadPath);
		if(!file.exists()) {
			file.mkdir();
			System.out.println("경로상 폴더가 없으므로 폴더 생성합니다.");
		}
		// 3. 서블릿의 HTTP 요청중 contentType 이 'multipart/form-data' 일 때 첨부파일을 업로드 하는 방법
			// 1.DiskFileItemFactory 클래스 이용한 1.저장위치 2.업로드용량제한 3.한글인코딩 설정한다.
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(file);	// 1. 저장 위치 설정
		factory.setSizeThreshold(1024 * 1024);	// 2. 업로드 용량 제한 설정, 1바이트 기준, 1024 바이트 -> 1kb, 1024*1024 -> 1mb
		factory.setDefaultCharset("UTF-8");
			// 2. ServletFileUpload 클래스에 위에서 설정한 기준으로 업로드 객체 생성한다.
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
			// 3. 업로드객체에 HTTP 요청 객체를 대입하여 HTTP 요청객체를 업로드 객체로 반환한다. 반환된 자료들을 리스트로 받는다.
		try {
		List<FileItem> formItems = fileUpload.parseRequest(req); 
		// <-- cos.jar / commons.jar 톰켓 10.1 버전을 지원하지 않는다. 톰켓9 이하 버전 설치 or 마이그레이션 이용하여 라이브러리 버전 낮추기
			// 4. 만약에 업로드객체내 반환된 자료들이 존재하면
		if(formItems != null && !formItems.isEmpty()) {
			// 5. 반복문을 이용한 form 자료들을 하나씩 확인한다
			for(int i = 0; i<= formItems.size()-1; i++) {
				// 6. 자료 1개만 추출
				FileItem fileItem = formItems.get(i);
				if(fileItem.isFormField()) {
					System.out.println("첨부파일이 아닌 일단 텍스트 :" + fileItem.getName());
				}else {
					System.out.println("첨부파일 : " + fileItem.getName());
						// * 만일 서로 다른사람이 동일한 파일명을 올릴경우 식별이 불가능 --> 방안 : UUID 내장함수
					String uuid = UUID.randomUUID().toString();
					System.out.println(uuid);
						// - UUID와 업로드 파일명 연결, 만약에 파일명에 '-' 포함되면 uuid 와 파일명 구분이 힘들다.
						// "문자열" .replaceAll("변경할문자", "새로운문자"); 문자열내 변경할 문자가 존재하면 새로운문자로 전환
					// 8. 만일 첨부파일이면 현재 경로에 파일명 붙이기.
					String filename = uuid + "-" + fileItem.getName().replaceAll("-", "_");
					File uploadFile = new File(uploadPath+"/"+filename);
					// 9. 지정한 파일명으로 업로드 처리
					fileItem.write(uploadFile);
				}
			}
			}
		}catch (Exception e) {
			System.out.println(e); 
		}
	}
}
