// var, let, const

var a = 100;
console.log('a=', a)
a = 200
console.log('a=', a)

var a = 500; // 중복 선언 가능!
console.log('a=', a)


// ES6  부터 let, const 로 변수 상수 지정.
let value = 177;
console.log('value=', value)

value = 555;
console.log('value=', value)

// let 은 동일 변수 이름으로 중복 선언 불가!

// 상수 선언
const b = 1;
console.log('b=',b);
// b = 2 ; // 오류

//--------------------------
// var 는 오늘날 JS 환경에서는 그닥 권장하진 않음.

// var 와 let
// IE9, IE10  와 같은 구형 브라우저에서는
//  let, const 를 사용 못함.

// 개발 단계에서는 '바벨' 등을 사용하여
// 우리가 개발한 코드가 구형 브라우저 에서동 동작케 함.

let c; // 초기화를 따로 해도 가능.
c = 100;

// ' : back tick
console.log(`c = ${c}`); // Template Literal (ES6 <= )

//데이터 타입들
let value2 = 100; // number 타입

console.log(value2, typeof value2); // typeof 연산자 : 변수의 타입을 확인


// JS 는 대입되는 값에 따라 '타입' 바뀜.
value2 = 'hello'; // string 타입
console.log(value2, typeof value2);
value2 = "Hello"; // ' ~ ' , " ~ " 둘다 가능.