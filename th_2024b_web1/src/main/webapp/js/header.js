//[1] 로그인 정보 요청 함수 
const getLoginInfo = ( ) => {
	const option = { method : 'GET' } 
	
	let loginmenu = document.querySelector('.loginmenu'); // (1)로그인 메뉴를 출력할 구역 가져오기 
	
	let html = ``; // (2) html 변수 선언 
	
	fetch( '/th_2024b_web1/member/info' , option )
		.then( r => r.json() )
		.then( data =>{
			console.log( data ); // 코드 변경후 서버가 자동 재실행이 되면 세션 초기화.
			if( data == null ){console.log('비로그인상태');
				// (3) 각 상태에 따라 로그인 메뉴 구성
				html += `<li class="nav-item"> <a class="nav-link" href="/th_2024b_web1/member/login.jsp">로그인</a> </li>
						<li class="nav-item"> <a class="nav-link" href="/th_2024b_web1/member/signup.jsp">회원가입</a> </li>`
			}
			else{ console.log('로그인상태');
				// (3) 각 상태에 따라 로그인 메뉴 구성
				html += `<li class="nav-item dropdown">
				          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
				          <img class="header_profile" src="/th_2024b_web1/upload/${ data.mimg }" /> ${ data.mid } 님/ ${ data.mpoint}POINT 
				          </a>
				           <ul class="dropdown-menu">
				             <li class="nav-item"> <a class="nav-link" href="/th_2024b_web1/member/info.jsp">마이페이지</a> </li>
				             <li class="nav-item"> <a class="nav-link" href="#" onclick="onLogOut()">로그아웃</a> </li>
				              </ul>
				               </li> `
			}
			// (4) 구성한 메뉴들을 innerHTML 한다.
			loginmenu.innerHTML = html;
		})
		.catch( e => {console.log(e);})
}; 
getLoginInfo(); 

// [2] 로그아웃 요청 함수 
const onLogOut = ( ) => {
	const option = { method : 'DELETE' }
	fetch( '/th_2024b_web1/member/login' , option )
		.then( response =>  response.json() )
		.then( data => {
			if( data==true){ 
				alert('로그아웃합니다.'); 
				location.href="/th_2024b_web1/member/login.jsp"; 
			}
		})
		.catch( e => {console.log(e); })
}  

// [3] 알람 소켓
const alarmSocket = new WebSocket('ws://localhost:8080/th_2024b_web1/alarmsocket');

// [4] 클라이언트 웹소켓이 서비스소켓으로 부터 메시지를 받았을 때
alarmSocket.onmessage = (msgEvent) => {
	console.log(msgEvent.data);
	
	const alarmbox = document.querySelector('.alarmbox')
	        
	        let html = `<div class="toast show" role="alert" aria-live="assertive" aria-atomic="true">
	                                  <div class="toast-header">
	                                    <strong class="me-auto">${ msgEvent.data }</strong>
	                                    <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
	                                  </div>
	                                </div>`
	       
	        alarmbox.innerHTML = html
}
