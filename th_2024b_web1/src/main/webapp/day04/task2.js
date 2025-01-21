const waitWrite = () => {
	let callnumInput = document.querySelector(`.callnumInput`);
	let personInput = document.querySelector(`.personInput`);
	
	let callnum = callnumInput.value;
	let person = personInput.value;

	let dataObj = {callnum : callnum, person : person};
	
	let option = {
		method : 'POST',
		header : {'Content-Type' : 'application/json'},
		body : JSON.stringify(dataObj)
	}
	fetch(`/th_2024b_web1/day03/wait2`, option)
		.then(r => r.json())
		.then(data => {
			if(data == true) {
				alert('등록성공');
				waitFindAll();
			}else {
				alert('등록실패');
			}
		})
		.catch(e => {console.log(e)})
}
const waitFindAll = () => {
	let tbody = document.querySelector('tbody')
	let html = ''
		const option = {method : 'GET'}
		fetch(`/th_2024b_web1/day03/wait2`, option)
		.then(r => r.json())
		.then(data => {
			data.forEach(obj => {
				html += `<tr>
							<td> ${obj.num}</td>
							<td>${obj.callnum}</td>
							<td>${obj.person}</td>
							<td><button onclick="waitUpdate(${obj.num})">수정</button></td>
							<td><button onclick="waitDelete(${obj.num})">삭제</button></td>
						</tr>`
			})
			tbody.innerHTML = html;
		})
		.catch(e => {console.log(e)})
}
waitFindAll();

const waitUpdate = (num) => {
	let newCallnum = prompt('new Content : ');
	let newPerson = prompt('new Person : ');
	const option = {
		method : 'PUT',
		headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify({num : num, callnum : newCallnum, person : newPerson})	
	}
	fetch(`/th_2024b_web1/day03/wait2?num=${num}`, option)
		.then(r => r.json())
		.then(data => {
			if(data == true) {
				alert('수정성공');waitFindAll();
			}else{alert('수정실패');}
		})
}
const waitDelete = (num) => {
	const option = { method : 'DELETE'}
		fetch(`/th_2024b_web1/day03/wait2?num=${num}`, option)
			.then(r => r.json())
			.then(data => {
				if(data == true) {
					alert('삭제성공');waitFindAll();
				}else{alert('삭제실패');}
			})
	}
