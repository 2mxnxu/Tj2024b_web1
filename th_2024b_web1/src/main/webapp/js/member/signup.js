console.log('signup.js open');

const onSignUp = () => {
	// 1. form을 한번에 가져오기. application/json ---> multipart/form-data(첨부파일)
		// * form-data로 전송할 경우에는 속성명들을 'name'속성으로 사용된다.
	const signupform = document.querySelector("#signupform");	
		console.log(signupform);
	// 2. Fetch 함수 이용한 'multipart/form-data' 타입으로 전송하는 방법
		// (1) 전송 할 폼을 바이트(바이너리) 데이터로 변환, FormData 클래스, new FormData(폼 DOM);
	const signformData = new FormData(signupform);
		// (2) fetch 옵션, content-type 생략하면 자동으로 'multipart/form-data' 적용된다.
	const option = {
		method : 'POST',
		body : signformData
	}	
	// (3) fetch 요청 과 응답
	fetch('/th_2024b_web1/member/signup', option)
		.then(response => response.json())
		.then(data => {
			if(data == true) {
				alert('회원가입 성공'); location.href="login.jsp";
			}else {alert('회원가입 실패');}
		})
		.catch(error => {console.log(error);})
}