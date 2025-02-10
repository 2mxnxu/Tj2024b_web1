const findall = ( ) => {
	const option = { method : 'GET' }
	fetch('/th_2024b_web1/books/book' , option)
	.then(r => r.json())
	.then(data => {
		const booklist = document.querySelector('.booklist > tbody')
		let html = ``;
		data.forEach( (book)=>{
			html += `<tr>
						<td> ${book.bno} </td>
						<td> ${book.bname} </td>
						<td> ${book.bwriter} </td>
						<td> ${book.bpublisher} </td>
						<button>삭제</button>`
			})
			booklist.innerHTML = html;
	})
	.catch(e => {console.log(e)})
}
findall();