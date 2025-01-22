<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page = "/day05/header.jsp"/>
	<div>
                <h3> 게시물 개별 조회 : 상세페이지로 선택한 특정 게시물을 조회 합니다. </h3>
                <div> 
                        작성일:<span class="ddatebox">  </span>
                        작성자:<span class="writerbox">  </span>
                        조회수:<span class="viewbox">  </span>
                </div>
                <div class="titlebox">  </div>
                <div class="contentbox"> </div>
                
                <div class="etcbtns">
                        <button onclick="boardDelete()">삭제</button>
                        <button onclick="boardUpdate()">수정</button>
                </div>
        </div>
	<jsp:include page = "/day05/footer.jsp"/>
	<script src="board2.js"></script>
</body>
</html>