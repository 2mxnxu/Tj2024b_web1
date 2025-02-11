const onAdd = () => {
	const signupform = document.querySelector("#signupform");
	console.log(signupform);
	const signformData = new FormData(signupform);
	
	const option = {
			method : 'POST',
			body : signformData
		}	
		fetch('/bookservice/book/write', option)
			.then(r => r.json())
			.then(data => {
				if(data == true) {
					alert('등록성공'); location.href="book.jsp";
				}else{alert('등록실패');}
			})
			.catch(error => {console.log(error);})
}
