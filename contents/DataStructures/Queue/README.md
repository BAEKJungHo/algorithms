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

### 값이 존재하는 지 확인

```java
queue.contains(x) // 값 이 있으면 true 없으면 false
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

## PriorityQueue

- 우선순위 큐(Priority Queue)는 우선순위가 가장 높은 데이터를 가장 먼저 삭제한다. 즉, `데이터를 우선순위에 따라 처리하고 싶을 때 사용`한다.
- 우선순위가 높다는 기준이 필요하기 때문에 정렬 기준이 객체라면 Comparable 을 구현한다.
  - Ex. 여러개의 물건을 자료구조에 넣고, 가치가 가장 높은 물건부터 꺼내야 하는 경우
- 우선순위 큐를 구현할 때는 내부적으로 `최소 힙(Min Heap)` 또는 `최대 힙(Max Heap)`을 이용한다. 최소 힙을 이용하는 경우 값이 가장 낮은 데이터가 먼저 삭제되며, 최대 힙은 값이 큰 데이터가 가장 먼저 삭제된다.

```java
class Node implements Comparable<Node> {

    private int vertex; // 정점
    private int cost; // 비용

    public Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    public int getVertex() {
        return vertex;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost; // 비용이 낮을 수록 높은 우선순위를 갖도록한다. : 오름차순
    }
}
```

```java
//int형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

//int형 priorityQueue 선언 (우선순위가 높은 숫자 순)
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

//String형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
PriorityQueue<String> priorityQueue = new PriorityQueue<>(); 

//String형 priorityQueue 선언 (우선순위가 높은 숫자 순)
PriorityQueue<String> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
```


## 🔑 기본 문제

### [공주 구하기](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/queue/saveprincess/Main.java)

```java
public int solution(int n, int k){
    int answer = 0;
    Queue<Integer> Q = new LinkedList<>();
    for(int i=1; i<=n; i++) {
        Q.offer(i);
    }

    while(!Q.isEmpty()) {
        for(int i=1; i<k; i++) { // 제거 대상 전 까지
            Q.offer(Q.poll()); // k 가 3이면 1, 2를 뽑아서 없앤 후, 다시 끝에 붙여 넣는다. -> 34567812
        }
        Q.poll(); // 맨 앞하나를 꺼낸다. (i == k) 34567812 -> 4567812
        if(Q.size()==1) answer = Q.poll();
    }

    return answer;
}
```

### [교육과정 설계](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/queue/teach/Main.java)

```java
// 핵심 Point : 필수과목 Queue 와 수업설계 Queue 를 만들어서 같으면 YES 다르면 NO
    // Queue 의 contains 함수 사용
// 수업이 필수과목 Queue 에 들어있으면 수업설계 Queue 에 넣기
public String solution(String mustLectures, String lectures) {
    Queue<Character> mustLecturesQueue = new LinkedList<>();
    for(int i=0; i<mustLectures.length(); i++) {
        mustLecturesQueue.offer(mustLectures.charAt(i));
    }

    Queue<Character> lecturesQueue = new LinkedList<>();
    for(int i=0; i<lectures.length(); i++) {
        Character lecture = lectures.charAt(i);
        if(mustLecturesQueue.contains(lecture)) {
            lecturesQueue.offer(lecture);
        }
    }

    return mustLecturesQueue.equals(lecturesQueue) ? "YES" : "NO";
}
```

### [응급실](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/queue/emergencyroom/Main.java)

링크 참고
