// 1. 등록 통신 함수
const visitWrite = () => {
	// 1. HTML 으로 부터 input dom 객체 가져오기
	let contentInput = document.querySelector(`.contentInput`)
	let ageInput = document.querySelector(`.ageInput`)
	
	// 2. 입력받은 값 가져오기
	let content = contentInput.value;
	let age = ageInput.value;
	// 3. 객체화
	let dataObj = {content : content, age : age};
	// 4. fetch 통신
	let option = {
		method : 'POST', 
		hearder : {'Content-Type' : 'application/json'}, // HTTP 요청 HEADER CONTENT-TYPE
		body : JSON.stringify(dataObj) // 본문에 보낼 자료를 문자열타입으로 반환		
	}
	// 5. 결과에 따른 화면 구현
	fetch(`/th_2024b_web1/day03/visit2`, option)
		.then(r => r.json())
		.then(data => {
			if(data == true) {
				alert('등록성공');
				visitFindAll();
			}else {
				alert('등록실패');
			}
		})	
		.catch(e => {console.log(e)})
}

// 2. 전체 조회 함수
const visitFindAll = () => {
	// 1. 어디에 
	let tbody = document.querySelector('tbody')
	// 2. 무엇을
	let html = ''
		// 2-1 fetch 이용한 서블릿에게 자료를 HTTP GET METHOD에게 요청
		const option = {method : 'GET'}
		// 2-2 fetch
		fetch('/th_2024b_web1/day03/visit2' , option)
			.then(r => r.json())
			.then(data => {
				console.log(data)
				data.forEach(obj => {
					html += `<tr>
								<td> ${obj.num}</td>
								<td>${obj.content}</td>
								<td>${obj.age}</td>
								<td><button onclick="visitUpdate(${obj.num})">수정</button></td>
								<td><button onclick="visitDelete(${obj.num})">삭제</button></td>
							  </tr>`
				})
				// 3. 출력
					tbody.innerHTML = html;
				})
				.catch(e => {console.log(e)})
	
}
visitFindAll();

// 3. 수정 함수
const visitUpdate = (num) => {
	let newContent = prompt('new Content : ');
	let newAge = prompt('new Age : ');
	const option = {
		method : 'PUT',
		headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify({num : num, content : newContent, age : newAge })
	}
	fetch(`/th_2024b_web1/day03/visit2?num=${num}` , option)
		.then(r => r.json())
		.then(data => {
			if(data == true){
				alert('수정성공');visitFindAll();
			}else{alert('수정실패')}
		})
		}
// 4. 삭제 함수
const visitDelete = (num) => {
	// 1. 삭제할 식별자(num)
	// 2. fetch 이용한 서블릿에게 자료를 HTTP delete METHOD 처리 요청
	const option = { method : 'DELETE'}
	fetch(`/th_2024b_web1/day03/visit2?num=${num}` , option)
		.then(r => r.json())
		.then(data => {
			if(data == true) {alert('삭제성공');visitFindAll();}
			else{alert('삭제실패')}
		})
}