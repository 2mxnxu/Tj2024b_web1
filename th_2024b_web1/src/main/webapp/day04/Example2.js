/*
fetch(`http url`, {옵션})
	- GET : fetch(`http url`, {method : `GET`}) -> GET method 는 생략 가능
	- POST : fetch(`http url`, {method : `POST`}) 
	- PUT : fetch(`http url`, {method : `PUT`}) 
	- DELETE : fetch(`http url`, {method : `DELETE`}) 
*/
// [1] 람다식 함수 정의
// const 상수명 = () => {}
const func1 = () => {
	console.log('func1 execute')
}
// [2] 람다식 함수 정의 안에서 fetch 함수 활용
const func2 = () => {
	fetch(`http://localhost:8080/th_2024b_web1/day02/example1`)
}
const func3 = () => {
	fetch(`/th_2024b_web1/day02/example1`, {method : `POST`})
}
const func4 = () => {
	fetch(`/th_2024b_web1/day02/example1`, {method : `PUT`})
}
const func5 = () => {
	fetch(`/th_2024b_web1/day02/example1`, {method : `DELETE`})
}
const func6 = () => {
	let name = "유재석";
	let age = 40;
	fetch(`/th_2024b_web1/day02/example2?name=${name}&age=${age}`)
}
const func7 = () => {
	let name = "신동엽";
	let age = 30;
	const option = {method : `POST`}
	fetch(`/th_2024b_web1/day02/example2?name=${name}&age=${age}`, option)
}
const func8 = () => {
	let name = "서장훈";
	let age = 20;
	const option = {method : `PUT`}
	fetch(`/th_2024b_web1/day02/example2?name=${name}&age=${age}`, option)
}
const func9 = () => {
	let name = "김희철";
	let age = 50;
	const option = {method : `DELETE`}
	fetch(`/th_2024b_web1/day02/example2?name=${name}&age=${age}`, option)
}
const func10 = () => {
	let object = {data1 : `유재석`, data2 : 50}
	const option = {
		method : 'POST',
		header : {'Content-type' : 'application/json'},
		body : JSON.stringify(object) // http 통신은 문자열 타입만 가능해서
	}
	fetch(`/th_2024b_web1/day03/example3`, option)
}
const func11 = () => {
	let object = {data1 : `강호동`, data2 : 40}
	const option = {
		method : 'PUT',
		header : {'Content-type' : 'application/json'},
		body : JSON.stringify(object)
	}
	fetch(`/th_2024b_web1/day03/example3`, option)
}
const func12 = () => {
	const option = {method : `GET`}
	fetch(`/th_2024b_web1/day03/example5`, option)
		.then(response => response.json())
		.then(data => {console.log(data);})
}
const func13 = () => {
	const option = {method : `POST`}
	fetch(`/th_2024b_web1/day03/example5`, option)
		.then(response => response.text())
		.then(data => {console.log(data);})
}
const func14 = () => {
	const option = {method : `PUT`}
	fetch(`/th_2024b_web1/day03/example5`, option)
		.then(response => response.json())
		.then(data => {console.log(data);})		// 통신 성공 시
		.catch(error => {console.log(error);})	// 통신 실패 시
}
const func15 = () => {
	const option = {method : `DELETE`}
	fetch(`/th_2024b_web1/day03/example5`, option)
		.then(r => r.json())
		.then(data => {console.log(data);})
		.catch(error => {console.log(error);})
		
}
