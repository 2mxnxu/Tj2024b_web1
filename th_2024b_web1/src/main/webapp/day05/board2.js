const boardWrite = () => {
	let titleInput = document.querySelector(`.titleInput`)
	let contentInput = document.querySelector(`.contentInput`)
	let writertInput = document.querySelector(`.writertInput`)
	let pwdInput = document.querySelector(`.pwdInput`)
	
	let title = titleInput.value;
	let content = contentInput.value;
	let writer = writertInput.value;
	let pwd = pwdInput.value;
	
	let dataObj = {title : title, content : content, writer : writer, pwd : pwd};
	
	let option = {
		method : 'POST',
		header : {'Content-Type' : 'application/json'},
		body : JSON.stringify(dataObj)
	}
	fetch(`/th_2024b_web1/day05/board`, option)
		.then(r => r.json())
		.then(data => {
			if(data == true) {
							alert('등록성공');
							boardFindAll();
						}else {
							alert('등록실패');
						}
		})
		.catch(e => {console.log(e)})
}
const boardFindAll = () => {
		let tbody = document.querySelector('tbody')
		let html = ''
		const option = {method : 'GET'}
		fetch(`/th_2024b_web1/day05/board`, option)
			.then(r => r.json())
			.then(data => {
				data.forEach( board => {
				     html += `<tr>
				                 <td> ${ board.num } </td> 
				                 <td> 
				                  <a href="view.jsp?num=${ board.num }"> 
				                      ${ board.title } 
				                  </a> 
				                  </td> 
								  <td> ${ board.content } </td>
				                  <td> ${ board.writer } </td> 
				                  <td> ${ board.viewnum } </td>
								  <td> ${ board.ddate } </td>
				                   </tr>`
				                        });
					tbody.innerHTML = html;
			})
			.catch(e => {console.log(e)})
}
boardFindAll();

const boardUpdate = (num) => {
  let newTitle = document.querySelector('.newTitle').value;
  let newContent = document.querySelector('.newContent').value;
  let newWriter = document.querySelector('.newWriter').value;
  let pwdInput = document.querySelector(`.pwdInput`).value;
  
  const option = {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ title: newTitle, content: newContent, writer: newWriter})
  };

  fetch(`/th_2024b_web1/day05/board?num=${num}`, option)  
	    .then(r => r.json())
	    .then(data => {
	      if (data == true) {
	        alert('수정성공');
	        boardFindAll();  
	      } else {
	        alert('수정실패');
	      }
	    })
	    .catch(e => { console.log(e); });
	};

const boardDelete = (num) => {
	let pwd = prompt('비밀번호 입력 : ')
	const option = { method : 'DELETE'}
		fetch(`/th_2024b_web1/day05/board?num=${num}`, option)
			.then(r => r.json())
			.then(data => {
				if(data == true) {
					alert('삭제성공');boardFindAll();
				}else{alert('삭제실패');}
			})
	}
const boardView = () => {
	let num = new URL(location.href).searchParams.get('num');
	const option = {method : `GET`}
	fetch(`/th_2024b_web1/day05/board/view?num=${num}`, option)
		.then(response => response.json())
		.then(data =>{
			document.querySelector('.ddatebox').innerHTML = `${data.ddate}`;
			document.querySelector('.writerbox').innerHTML = `${data.writer}`;
			document.querySelector('.viewbox').innerHTML = `${data.viewnum}`;
			document.querySelector('.titlebox').innerHTML = `${data.title}`;
			document.querySelector('.contentbox').innerHTML = `${data.content}`;
			
		})
		.catch(error => {console.log(error)})
}
boardView();

