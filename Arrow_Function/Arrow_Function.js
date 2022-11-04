//arrow function 과 일반 함수의 차이점
// 1. 화살표 함수는 인스턴스를 생성할 수 없는 non-constructor
// 2. 중복된 매개변수 이름을 선언할 수 없다.
// 3. 화살표 함수는 함수 자체의 this, arguments, super, new.target 바인딩을 갖지 않음
// 4. 가장큰 차이점은 arrow function은 함수 자체의 this 바인딩을 갖지 않으며 
//	  함수내부에서 this를 참조하면 상위 스코프의 this를 참조. 
//    따라서 arrow function은 콜백 함수의 this와 외부 함수의 this간 불일치 문제를 해결할 수 있음

const size_map = new Map([['01', '0~1000'] ,
						['02', '1001~3000'],
						['03', '3001~5000'],
						['04', '5001~10000'],
						['05', '10001~15000'],
						['06', '15001~30000'],
						['07', '30001~99999999999']]);
	
function max_size_func(code){
	return size_map.get(code).split('~')[1];
}
function min_size_func(code){
	return size_map.get(code).split('~')[0];
}

console.log(max_size_func('02'));
console.log(min_size_func('02'));

let maxSF = (code) => size_map.get(code).split('~')[1];
let minSF = (code) => size_map.get(code).split('~')[0];

console.log(maxSF('02'));
console.log(minSF('02'));

// 동적
let num = 13
let test1 = (num > 10) ? 
	(num) => "10보다 큰 수 입니다." : 
	(num) => "10보다 작거나 같은 수 입니다.";
console.log(test1());
