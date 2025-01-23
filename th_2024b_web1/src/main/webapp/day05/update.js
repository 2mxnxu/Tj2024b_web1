const boardView = ( ) => {
        let num = new URL( location.href ).searchParams.get('num');
        const option = { method : 'GET' }
        fetch( `/th_2024b_web1/day05/board/view?num=${ num }` , option )
                .then( response => response.json() )
                .then( data => {
                        document.querySelector('.titleInput').value = `${ data.title }`
                        document.querySelector('.contentInput').value = `${ data.content }`
                })
                .catch( error => { console.log(error) })
} 
boardView() ; 

const boardUpdate = ( ) => {
	let num = new URL(location.href).searchParams.get('num');       
	let titleInput = document.querySelector('.titleInput')
	let contentInput = document.querySelector('.contentInput')
	let title = titleInput.value;
	let content = contentInput.value;
	
	let dataObj = {num : num, title : title, content : content}
	const option = {
		method : 'PUT',
		headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify(dataObj)
	}
	fetch(`/th_2024b_web1/day05/board`,option )
		.then( response => response.json())
		.then(data => {
			if(data == true) {
				alert('수정성공')
				location.href=`view.jsp?num=${num}`;
				
				}else{
					alert('수정실패')
				}
			})
			.catch(e => {console.log(e)})
	
}