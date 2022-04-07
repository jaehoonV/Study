Priority Queue
===============
#### Queue는 FIFO(First In First Out)구조로 먼저들어온 순서대로 데이터가 나가게 됨 
#### Priority Queue는 데이터의 우선순위를 정해 우선순위가 높은 순서대로 나가게 됨
***

### Priority Queue의 특징
* 우선순위 큐는 값을 비교해야하므로 null을 허용하지 않음
* 내부구조는 이진트리 힙으로 구성되어 있음
* 내부구조가 이진트리로 되어있어서 add() 및 poll() 메서드(추가, 삭제 메서드) 0(log(n)) 시간이 걸림
***

### Priority Queue 선언
```
Integer 타입으로 우선순위 큐 선언(낮은 숫자 순으로 우선순위 결정) 
PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>(); 
Integer 타입으로 우선순위 큐 선언(높은 숫자 순으로 우선순위 결정) 
PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(Collections.reverseOrder());
```
* 우선순위 큐를 사용하려면 java.util.PriorityQueue를 import해야 함
* 선언을 하면 기본적으로 낮은 순으로 우선순위가 결정이 됨
* 반대로 선언하고 싶다면 Collections.reverseOrder() 메서드를 사용 함
* Collections 메서드를 사용하려면 java.util.collections를 import해야 함
***

### Priority Queue 값 추가, 출력
```
priorityQueue.add(1);     // priorityQueue 값 1 추가
priorityQueue.add(2);     // priorityQueue 값 2 추가
priorityQueue.offer(3);   // priorityQueue 값 3 추가
priorityQueue.peek();     // priorityQueue에 첫번째 값 참조 = 1
```
* 큐에 값을 추가하고 싶다면 add(value) 또는 offer(value)라는 메서드를 사용
* add(value) 메서드의 경우 만약 삽입에 성공하면 true를 반환하고, 큐에 여유 공간이 없어 삽입에 실패하면 IllegalStateException을 발생시킴
* Priority Queue에서 우선순위가 가장 높은 값을 참조하고 싶다면 peek()라는 메서드를 사용

### Priority Queue 값 삭제
```
priorityQueue.poll();       // priorityQueue에 첫번째 값을 반환하고 제거 비어있다면 null
priorityQueue.remove();     // priorityQueue에 첫번째 값 제거
priorityQueue.clear();      // priorityQueue에 초기화
```
* 큐에서 값을 제거하고 싶다면 poll()이나 remove()라는 메서드를 사용
* 값을 제거할 시 우선순위가 가장 높은 값이 제거됨. 
* poll() 함수는 우선순위 큐가 비어있으면 null을 반환
* 큐의 모든 요소를 제거하려면 clear() 메서드를 사용
