
a = 100;

if( a+1 > 100){ // 참 판정
   let a = 10;
    console.log('if 안의 a 값은', a); // 10
}

console.log(a);

// 조건식에서 참 거짓 판정시!

// Falsy 로 평가될때!
// false, 0, '', null, undefined, NaN   <-- 'Falsy 한 값'이라 한다

// Truthy 로 평가될때
// true, 37, 'Mark', {}, []   <-- 'Truthy 한 값' 이라 한다

function print(data){
    if(data){ // 참(Truthy) 거짓(Falsy) 판정
            console.log(data, typeof data, '-- Truthy');
    } else{
        console.log(data, typeof data, '--Falsy');
    }
}

print(true);
print(false);
print(100);
print(0)
print(-1);
print("Hello");
print(""); //f
print([10,20,30]);
print([])
print({'name' : 'John', 'age' : 32});
print({});
print(null);
print(undefined);
print(NaN);

console.log(100/0);
print(100 / 0) // T



print() // 호출시 전달인자 없으면 undefined 값으로 동작함

console.log()
// Falsy 값에 ! 결과 => true (boolean)
console.log(!undefined)
console.log(!null)
console.log(!0)
console.log(!"")
console.log(!NaN)

// Truthy 값에 ! 결과 => false (boolean)
console.log(!3)
console.log(!"Hello")
console.log(!" ")


// 삼항 연산자 사용
let value = {'a' : 100}
let isTrue = value ? true : false;
console.log('isTrue =', isTrue, typeof isTrue);

// !! 사용하면 가능!
isTure = !!value;
console.log('isTrue =', isTrue, typeof isTrue);


console.log();

function printName(person){
    console.log('이름은', person.name)
}

let myBrother = {
    name : "John"
}

printName(myBrother);
// printName() // 에러다 undefined 값이 person 에 넘겨짐

function printName(person){

    // 매개변수 Null check .
    // if(person === undefined || person === null) return;
    if(!person) return;

    console.log('이름은', person.name);


}

printName(myBrother);
printName();

