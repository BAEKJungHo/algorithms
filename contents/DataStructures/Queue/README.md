# Queue

- FIFO(First In First Out, 선입선출)
- Enqueue(추가) : 큐 맨 뒤에 데이터 추가
- Dequeue(삭제) : 큐 맨 앞쪽의 데이터 삭제
- 한 쪽 끝은 프론트(front)로 정하여 삭제 연산만 수행
- 한 쪽 끝은 리어(rear)로 정하여 삽입 연산만 수행
- 그래프의 넓이 우선 탐색(BFS)에서 사용
- 컴퓨터 버퍼에서 주로 사용, 마구 입력이 되었으나 처리하지 못할 때, 버퍼(Queue)를 만들어 대기 시킴

__정리하자면 Queue 의 front 는 Dequeue 연산만 수행하고, rear 는 Enqueue 연산을 수행한다.__

## 사용법

### 선언

```java
import java.util.LinkedList; 
import java.util.Queue; 
Queue<Integer> queue = new LinkedList<>(); 
Queue<String> queue = new LinkedList<>(); 
```

자바에서 큐는 `LinkedList` 를 활용하여 생성해야 한다.

### 값 추가

```java
queue.add(1);
queue.add(2);
queue.offer(3);
```

add 는 삽입에 성공하면 true 를 반환하고, 큐에 공간이 없어서 삽입에 실패하면 IllegalStateException 을 발생시킨다.

### 값 삭제

```java
queue.poll(); // 첫 번째 값을 반환 후 제거, 비어있다면 null 반환
queue.remove(); // 첫 번째 값 제거
queue.clear(); // 초기화
```

### 값 출력

```java
queue.peek(); // 첫 번째 값 출력
queue.element(); // peek 과 동일하지만 원소가 없다면 NoSuchElementException 발생
```

### 정리

- __Enqueue__
  - 예외 발생 메서드 
    - add(e)
  - 값 반환
    - offer(e)
- __Dequeue__
  - 예외 발생 메서드
    - remove()
  - 값 반환
    - poll()
- __Peek__
  - 예외 발생 메서드
    - element()
  - 값 반환
    - peek()
