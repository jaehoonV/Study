Compiler VS Interpreter
========================
### 컴파일 방식과 인터프리터 방식
#### 1. 컴파일 방식
* 원래 컴파일러는 고급 언어로 작성된 프로그램을 목적 프로그램으로 번역 후 링킹 작업을 통해 실행 프로그램을 생성한다.
* 자바는 javac로 컴파일 하고 java로 실행 시 중간언어(클래스 파일)을 한줄씩 자바 인터프리터가 번역하기에 컴파일 언어면서 인터프리터 언어이다.
#### 2. 인터프리터 방식
* 원래 인터프리터의 의미는 고급 언어로 작성된 프로그램을 한줄씩 번역해서 OS에서 인식하는 기계어로 변역하는 역할이다.
* 자바 인터프리터는 JAVAC 명령으로 자바 프로그램을 중간 형태인 바이트 코드로 컴파일하고 이를 자바 인터프리터가 한 줄 씩 해석하면서 기계어로 번역을한다.
* 자바 인터프리터와 Run-Time System이 이식된 모든 플랫폼에서 자바 바이트코드를 직접 실행 한다.
* 번역속도는 빠르지만 실행속도는 느리다.
***
### 컴파일러와 인터프리터의 차이
* 컴파일러는 전체 소스코드를 보고 명령어를 수집하고 재구성하지만 인터프리터는 소스코드의 각 행을 연속적으로 분석하며 실행한다.
* 인터프리터는 고레벨 언어를 바로 기계어로 번역하지 않고 중간 형태로 변환시킨 후 실행한다.
* 반면 컴파일러는 고레벨 언어를 바로 기계어로 변환한다.
***
### 장단점 비교
||컴파일러|인터프리터|
|:---:|:---:|:---:|
|개발 편의성|코드를 수정하고 실행하려면 컴파일을 다시 해야 함|코드를 수정하고 즉시 실행할 수 있음|
|실행 속도|빠름|느림|
|보안|프로그램의 코드가 유출되지 않음|프로그램의 코드가 유출될 수 있음|
|파일 용량|프로그램의 실행 파일 전체를 전송해야 하므로 용량이 큼|프로그램의 코드만 전송하면 실행이 되므로 용량이 작음|
|프로그래밍 언어|C, C++처럼 비교적 저수준에 가까운 언어|Python, Ruby처럼 비교적 고수준에 가까운 언어|
***
</br></br></br>

참조 링크: [https://velog.io/@jaeyunn_15/OS-Compiler-vs-Interpreter]