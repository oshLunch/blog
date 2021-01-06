<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="http://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
</head>
<body>
<button onclick="getajax()">클릭</button>

<script>
// 1. view 화면에서 KEY=VALUE 데이터 (GET) - 쿼리스트링

	function getajax(){
		// GET으로 key=value 데이터를 전송하고 응답을 text/plain을 받을 예정	
		$.ajax({
			type : "GET",
			url : "http://localhost:8000/ajax/ajax1?username=ssar&password=1234",
			//data : get은 전송할때 http의 body가 없음. 그래서 data 필드가 필요없음
			//contentType : 전송한 데이터가 없으니깐 그 data를 설명할 필드가 필요없음
			dataType : "text"
		})
		.done(function(result){

		})	//ajax 통신 완료후에 정상이면 done이 가지고 있는 함수 호출
		.fail(function(error){

		}); //ajax 통신 완료후에 비정상이면 fail이 가지고 있는 함수 호출
	}
</script>
</body>
</html>