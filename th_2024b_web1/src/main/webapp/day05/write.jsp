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
				<h3>게시물 작성 : 작성후 등록버튼을 클릭하세요!</h3>
				제목 : <input class="titleInput"/> <br/>
				내용 : <input class="contentInput"/> <br/>
				작성자 : <input class="writertInput"/> <br/>
				비밀번호 : <input class="pwdInput"/> <br/>
				<button onclick="boardWrite()" type="button" >등록</button>
			</div>
		<jsp:include page = "/day05/footer.jsp"/>
		<script src="board2.js"></script>
</body>
</html>