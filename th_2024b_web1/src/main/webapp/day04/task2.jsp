<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3>DAY03 Wait2 화면 구현</h3>
			<div>
				<h4>방문록 작성</h4>
				전화번호 : <input class="callnumInput"/> <br/>
				인원수 : <input class="personInput"/> <br/>
				<button onclick="waitWrite()" type="button" >등록</button>
			</div>
	<div> 
		<div>방문목록</div>
			<table border="1">
				<thead>
					<tr>
						<th>num</th>
						<th>callnum</th>
						<th>person</th>
						<th>etc</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
	</div>
	<script src="task2.js"></script>
</body>
</html>