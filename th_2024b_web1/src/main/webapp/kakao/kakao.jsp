<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Kakao 지도 시작하기</title>
</head>
<body>
	<div id="map" style="width:100%;height:1000px;"></div>

	
	<!-- jQuery 로딩 (필요한 경우에만) -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- Kakao 지도 API 로딩 (클러스터러 포함) -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3dd96e03bde8e56313afc5612a3d2238&libraries=clusterer"></script>

	
	<script src="kakao.js"></script>
</body>
</html>