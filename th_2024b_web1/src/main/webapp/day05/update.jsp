<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page = "header.jsp"/>
			<div>
				<h3>게시물 수정 : 수정후 등록버튼을 클릭하세요!</h3>
				제목 : <input class="titleInput"/> <br/>
				내용 : <input class="contentInput"/> <br/>
				
				<button onclick="boardUpdate()" type="button">수정</button>
			</div>
			
			<script src="update.js"></script>
		<jsp:include page = "/day05/footer.jsp"/>
		
</body>
</html>
