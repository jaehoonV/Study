TreeMap [ java.util.TreeMap ]
=============================
#### 컬렉션 프레임워크 Map 계열의 TreeMap 자료구조를 구현한 클래스
#### 입력 순서에 상관없이 자료를 트리 구조로 만들어 저장 및 검색
***

### TreeMap의 특징
* 이진트리를 기반으로 한 Map 컬렉션
* TreeMap에 객체를 저장하면 자동 정렬
* 키는 저장과 동시에 자동 오름차순으로 정렬되고 타입이 숫자일 경우 값으로, 문자열일 경우 유니코드로 정렬함
* TreeMap은 일반적으로 Map으로써 성능이 HashMap보다 떨어짐
* TreeMap은 데이터를 저장할 때 즉시 정렬하기에 추가나 삭제가 HashMap보다 오래 걸림
***

### TreeMap 선언
```
TreeMap<Integer,String> map1 = new TreeMap<Integer,String>();   // TreeMap생성 
TreeMap<Integer,String> map2 = new TreeMap<>();                 // new에서 타입 파라미터 생략가능 
TreeMap<Integer,String> map3 = new TreeMap<>(map1);             // map1의 모든 값을 가진 TreeMap생성 
TreeMap<Integer,String> map6 = new TreeMap<Integer,String>(){{  // 초기값 설정
    put(1,"a");
}};
```
* 생성하는 명령어는 HashMap과 크게 다르지 않으나 선언시 크기를 지정할 수 없음
***

### TreeMap 값 추가, 삭제, 출력
```
TreeMap<Integer,String> map = new TreeMap<Integer,String>(); // TreeMap생성
map.put(1, "java"); // 값 추가
map.put(2, "html"); // 값 추가
map.put(3, "css"); // 값 추가

map.remove(1); // key값 1 제거
map.clear(); // 모든 값 제거

// 단일값 출력
System.out.println(map);              // 전체 출력 : {2=html, 3=css}
System.out.println(map.get(2));       // key값 2의 value : html
System.out.println(map.firstEntry()); // 최소 Entry 출력 : 2=java
System.out.println(map.firstKey());   // 최소 Key 출력 : 2
System.out.println(map.lastEntry());  // 최대 Entry 출력: 3=css
System.out.println(map.lastKey());    // 최대 Key 출력 : 3

// 전체값 출력
// entrySet() 활용
for (Entry<Integer, String> entry : map.entrySet()) {    
    System.out.println("[Key]:" + entry.getKey() + " [Value]:" + entry.getValue());
}
// [Key]:2 [Value]:html
// [Key]:3 [Value]:css 

// KeySet() 활용
for(Integer i : map.keySet()){ // 저장된 key값 확인    
    System.out.println("[Key]:" + i + " [Value]:" + map.get(i));
}
// [Key]:2 [Value]:html
// [Key]:3 [Value]:css
```
* 특정 key값의 value를 가져오고 싶다면 get(key)를 사용하면 되고, 전체 출력을 하려면 entrySet()이나 keySet() 메소드를 활용하여 Map 객체를 반환받은 후 출력
***

### [ ceilingEntry() / ceilingKey() / floorEntry() / floorKey() ]
* ceilingEntry() : 제공된 키 값보다 크거나 같은 값 중 가장 작은 키의 Entry를 반환
* ceilingKey() : 제공된 키 값보다 크거나 같은 값 중 가장 작은 키의 키값을 반환
* floorEntry() : 제공된 키 값보다 같거나 작은 값 중 가장 큰 키의 Entry를 반환
* floorKey() : 제공된 키 값보다 같거나 작은 값 중 가장 큰 키의 키값을 반환
* Entry란 키와 값을 저장하고 있는 Map의 내부 클래스 (C언어 구조체의 역할과 유사함)
```
TreeMap<Integer,String> map = new TreeMap<>();
map.put(1, "java");
map.put(2, "html");
map.put(3, "css");
map.put(4, "xml");
map.put(5, "json");

System.out.println(map.ceilingEntry(1)); // "1=java"
System.out.println(map.ceilingKey(1));   // "1"		
System.out.println(map.floorEntry(6));   // "5=json"
System.out.println(map.floorKey(6));     // "5"
```
***

### [ higherEntry() / higherKey() / lowerEntry() / lowerKey() ]
* 위의 메소드와 비슷하지만, "같거나"가 빠짐
* 더 큰 값 중에서 가장 작은 값, 더 작은 값 중에서 가장 큰 값을 Entry 또는 key 타입으로 반환함
```
TreeMap<Integer,String> map = new TreeMap<>();
map.put(1, "java");
map.put(2, "html");
map.put(3, "css");
map.put(4, "xml");
map.put(5, "json");

System.out.println(map.higherEntry(1));  // "2=html"
System.out.println(map.higherKey(1));    // "2"
System.out.println(map.lowerEntry(5));   // "4=xml"
System.out.println(map.lowerKey(5));     // "4"
```
***

### [ pollFirstEntry() / pollLastEntry() ]
* 현재 맵에서 가장 작은 키 값(First) / 큰 키 값(Last)의 Entry를 반환 후 삭제
```
TreeMap<Integer,String> map = new TreeMap<>();
map.put(1, "java");
map.put(2, "html");
map.put(3, "css");
map.put(4, "xml");
map.put(5, "json");

System.out.println(map.pollLastEntry());   // "5=json" 반환 후 삭제
System.out.println(map.pollFirstEntry());  // "1=java" 반환 후 삭제
```
***
</br>
참조 링크: [https://dev-coco.tistory.com/39], [https://codevang.tistory.com/134]
