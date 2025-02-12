
// [*] 조회할 bno(게시물번호)
// - view.jsp?bno=1
// - view.jsp?bno=3
// - view.jsp?bno=2

// [1] 게시물 1개 조회 
const findByBno = ( ) => {
	// 1. URL 주소상의 bno(조회할번호)를 가져오기
	const bno = new URL( location.href ).searchParams.get( 'bno' );
	// 2. fetch 
	const option = { method : 'GET' }
	fetch( `/th_2024b_web1/board/view?bno=${ bno }` , option ) 
		.then( r => r.json() )
		.then( data => {
			console.log( data );
			document.querySelector('.titlebox').innerHTML = data.btitle
			document.querySelector('.contentbox').innerHTML = data.bcontent
			document.querySelector('.midbox').innerHTML = data.mid;
			document.querySelector('.viewbox').innerHTML = data.bview;
			document.querySelector('.datebox').innerHTML = data.bdate;
		})
		.catch( e => { console.log(e); } )
}; 
findByBno(); // JS 열렸을때 함수 실행 

const onReplyWrite = () => {
	
	// 1. 입력받은 값 가져오기
	const rcontentinput = document.querySelector(`.rcontentinput`);
	const rcontent = rcontentinput.value;
	// 2. 현재 게시물의 번호 구하기
	const bno = new URL(location.href).searchParams.get("bno");
	// 3. 보낼 자료를 객체로 만들기
	const obj = {rcontent : rcontent, bno : bno}
	// 4. fetch 이용한 servelt 통신 (주고 = request 받기 = response)
	const option = {
		method : 'POST',
		headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify(obj)
	}
	fetch('/th_2024b_web1/board/reply', option)
	.then( r => r.json())
	.then(data => {
		if(data == true) {
			alert('댓글쓰기 성공');
			replyFindAll();
		}else {
			alert('댓글쓰기 실패 : 로그인 후 가능합니다.')
		}
	})
	.catch(e => {console.log(e);})
}

// [3] 현재 게시물의 댓글 전체 조회
const replyFindAll = () => {
	const bno = new URL(location.href).searchParams.get("bno");
	// fetch queryString
	fetch(`/th_2024b_web1/board/reply?bno=${bno}`)
		.then( r => r.json())
		.then(data => {
			console.log(data);
			
			const replyBox = document.querySelector('.replyBox')
			let html = ``;
			data.forEach (reply => {
				html += `				<div class="card mt-3">
											<div class = "card-header">
											<img src = "/th_2024b_web1/upload/${reply.mming} style = "width : 30px;"/>
											</div>
				                          <div class="card-header">
				                            ${reply.mid}
				                          </div>
				                          <div class="card-body">
				                            ${reply.rcontent}
				                          </div>
				                        </div>`
			})
			replyBox.innerHTML = html;
		})
		.catch(e => {console.log(e);})
}
replyFindAll();