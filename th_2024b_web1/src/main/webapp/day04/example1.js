console.log(`example1.js 실행`);

console.log(3);
console.log(3.14);
console.log(true);
console.log(null);
console.log(undefined);
console.log("안녕");
console.log('안녕');
console.log(`안녕`);
console.log([3,3.14,true,`안녕`]);
console.log(function 함수명(){})
console.log({"속성명1" : 3, "속성명2" : `안녕`});

// 2. JS 함수
// (1) 선언적 함수 : function 함수명(매개변수명, 매개변수명) {실행문;}
// 정의/만들기
function func1(a,b){
	console.log(`func1 execute`);
	let c = a+b;
	return c;
}
let result = func1(3 , 4);	// (함수호출/사용)
console.log(result);
// (2) 익명 함수 : function(매개변수명, 매개변수명) {실행문;}
const func2 = function (a,b) {
	console.log(`func2 execute`);
	let c = a + b;
	return c;
}
let result2 = func2(6,4);
console.log(result2);
// (3) 람다식(화살표) 함수 : (매개변수명, 매개변수명) => {실행문;}
const func3 = (a,b) => {console.log(`func3 execute`); c = a + b; return c;}

let result3 = func3(3,4);
console.log(result3);

// 3. 람다식 함수의 활용처
const words = ["사과","수박","딸기","오렌지"]
for(let index = 0; index <= words.length-1; index++) {
	console.log(words[index]);
}
// forEach 함수 = 배열변수명.forEach((반복변수명) => {실행문}) 함수
words.forEach((word) => {console.log(word)});

// (3) 배열변수명.map((반복변수명) => {실행문}) 함수, 배열내 요소를 하나씩 반복변수명에 대입 반복실행
words.map((word) => {console.log(word)});

// (*) forEach 와 map 함수의 차이점 : forEach 함수는 return이 없고, map 함수는 return 지원한다.
let newWords1 = words.forEach((i) => {return i;})
console.log(newWords1);	// undefined

let newWords2 = words.map((j) => {return j;})
console.log(newWords2); // ['사과', '수박', '딸기', '오렌지']
