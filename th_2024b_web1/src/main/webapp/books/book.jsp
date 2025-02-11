<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container"> <!-- container 부트스트랩 클래스  -->
		
		
		
		<table class="table boardlist"> <!--  table 부트스트랩 클래스 -->
			<thead>
				<tr>
					<th> 책번호 </th>
					<th> 도서명 </th>
					<th> 저자 </th>
					<th> 출판사 </th>
					<th>  </th>
				</tr>
			</thead>
			<tbody>
		
			</tbody>
		</table>
		<hr/>
		<button onclick="location.href='write.jsp' " > 도서생성하기 </button>
	</div>

<script src="/bookservice/js/books/book.js" type="text/javascript" ></script>

</body>
</html>