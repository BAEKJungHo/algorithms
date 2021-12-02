# 정렬(Sorting)

![IMAGES](../images/sort.JPG)

# 선택 정렬(Selection Sort)

Point. 최솟값을 찾아 정렬되지 않은 가장 앞에 존재하는 원소와 교체(swap)하는 알고리즘 : `1회전마다 최솟값을 앞으로 보내는 알고리즘`

- __제자리 정렬(in-place sorting) 알고리즘의 하나__
  - 입력 배열(정렬되지 않은 값들) 이외에 다른 추가 메모리를 요구하지 않는 정렬 방법
- __해당 순서에 원소를 넣을 위치는 이미 정해져 있고, 어떤 원소를 넣을지 선택하는 알고리즘__
  - 첫 번째 순서에는 첫 번째 위치에 가장 최솟값을 넣는다.
  - 두 번째 순서에는 두 번째 위치에 남은 값중에서의 최솟값을 넣는다.
- __과정 설명__
  1. 주어진 배열 중에서 최솟값을 찾는다.
  2. 그 값을 맨 앞에 위치한 값과 교체한다(패스(pass))
  3. 맨 처음 위치를 뺀 나머지 리스트를 같은 방법으로 교체한다.
  4. 하나의 원소만 남을 때까지 위의 과정을 반복한다.
- __구체적인 개념__
  - 선택 정렬은 첫 번째 자료를 두 번째 자료부터 마지막 자료까지 차례대로 비교하여 `가장 작은 값(최솟값)`을 찾아 첫 번째에 놓고, 두 번째 자료를 세 번째 자료부터 마지막 자료까지와 차례대로 비교하여 그 중 가장 작은 값을 찾아 두 번째 위치에 놓는 과정을 반복하며 정렬을 수행한다.

## 구현

```java
// 정렬 코드의 가장 큰 특징 중 하나가 교체(swap) 코드를 잘 기억해야 함
// 선택정렬 : 최솟값을 찾아서 정렬 되지 않은 가장 앞의 인덱스랑 교체
public int[] solution(int[] arr) {
    for(int i=0; i<arr.length-1; i++) {
        int tmp = arr[i];
        for(int k=i+1; k<arr.length; k++) {
            if(tmp > arr[k]) {
                tmp = arr[k];
                arr[k] = arr[i];
                arr[i] = tmp;
            }
        }
    }
    return arr;
}
```

# 버블 정렬(Bubble Sort)

Point. 서로 인접한 두 원소를 검사하여 정렬하는 알고리즘 : `1회전 마다 최댓값을 맨 뒤로 보내는 알고리즘`

- __서로 인접한(adjacent) 두 원소를 검사하여 정렬하는 알고리즘__
   - 인접한 2개의 레코드를 비교하여 크기가 순서대로 되어 있지 않으면 교환한다.
   - 선택 정렬과 기본 개념이 유사하다.
- __구체적인 개념__
  - 버블 정렬은 첫 번째 자료와 두 번째 자료를, 두 번째 자료와 세 번째 자료를, 세 번째와 네 번째를, … 이런 식으로 (마지막-1)번째 자료와 마지막 자료를 비교하여 교환하면서 자료를 정렬한다.
  - `1회전을 수행하고 나면 가장 큰 자료가 맨 뒤로 이동`하므로 2회전에서는 맨 끝에 있는 자료는 정렬에서 제외되고, 2회전을 수행하고 나면 끝에서 두 번째 자료까지는 정렬에서 제외된다. 이렇게 정렬을 1회전 수행할 때마다 정렬에서 제외되는 데이터가 하나씩 늘어난다.

## 구현

```java
public int[] solution(int[] arr) {
    // arr.length = n
    for(int i=0; i<arr.length-1; i++) { // 바깥 반복문은 n-1 회 만큼 반복
        for(int k=0; k<arr.length-i-1; k++) { // 1회전하면 마지막 원소는 정렬이 되었으므로 n-i-1
            if(arr[k] > arr[k+1]) {
                int tmp = arr[k];
                arr[k] = arr[k+1];
                arr[k+1] = tmp;
            }
        }
    }
    return arr;
}
```

# 삽입 정렬(Insertion Sort)

Point. 첫 인덱스 값은 이미 정렬된 것으로 보고, 2 번째 자료 부터 정렬을 시작한다. : `1회전 마다 자기 앞에 있는 자료들과 비교하는 알고리즘`

- 자료 배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교 하여, 자신의 위치를 찾아 삽입함으로써 정렬을 완성하는 알고리즘
- 매 순서마다 해당 원소를 삽입할 수 있는 위치를 찾아 해당 위치에 넣는다.
- __구체적인 개념__
  - 삽입 정렬은 두 번째 자료부터 시작하여 그 앞(왼쪽)의 자료들과 비교하여 삽입할 위치를 지정한 후 자료를 뒤로 옮기고 지정한 자리에 자료를 삽입하여 정렬하는 알고리즘이다.
  - 즉, 두 번째 자료는 첫 번째 자료, 세 번째 자료는 두 번째와 첫 번째 자료, 네 번째 자료는 세 번째, 두 번째, 첫 번째 자료와 비교한 후 자료가 삽입될 위치를 찾는다. 자료가 삽입될 위치를 찾았다면 그 위치에 자료를 삽입하기 위해 자료를 한 칸씩 뒤로 이동시킨다.
  - `처음 Key 값은 두 번재 자료부터 시작한다.`

## 특징

- __장점__
  - 안정적인 정렬 방법
  - 레코드의 수가 적을 수록 알고리즘 자체가 매우 간단하므로 다른 복잡한 정렬 방법보다 유리할 수 있다.
  - 레코드가 이미 정렬되어 있는 경우에 매우 효율적일 수 있다.
- __단점__
  - 비교적 많은 레코드들의 이동을 포함한다.
  - 레코드 수가 많고 레코드 크기가 클 경우에 적합하지 않다.

## 구현

```java
public int[] solution(int[] arr) {
  int key;

  // 인덱스 0은 이미 정렬된 것으로 볼 수 있다.
  for(int i=1; i<arr.length; i++) { // 바깥 반복문은 삽입될 숫자들에 대한 반복문 (즉, 첫 인덱스를 제외한 n-1 만큼 반복)
      key = arr[i]; // 현재 삽입될 숫자인 i번째 정수를 key 변수로 복사

      // 현재 정렬된 배열은 i-1까지이므로 i-1번째부터 역순으로 조사한다.
      // k 값은 음수가 아니어야 되고
      // key 값보다 정렬된 배열에 있는 값이 크면 k 번째를 k+1 번째로 이동
      for(int k=i-1; k>=0; k--) { // 내부 반복문은 자기 바로 앞에 존재하는 자료들과 비교
          if(arr[k] > key) {
              key = arr[k+1];
              arr[k+1] = arr[k];
              arr[k] = key;
          }
      }
  }
  return arr;
}
```

### [LRU(Least Recently Used)](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/sorting/lru/Main.java)

```java
// 삽입정렬 응용 문제 -> list.set(2, 5) 이런식으로 할 순있지만 직접 구현하는게 더 좋음
// 손 코딩으로도 나올 수 있는 문제
public int[] solution(int cacheSize, int[] arr) {
    int[] cache = new int[cacheSize];
    for(int x : arr) { // 작업 번호 반복
        int position = -1;
        for(int i=0; i<cacheSize; i++) {
            if (x == cache[i]) { // 작업 번호가 cache 안에 있는 경우
                position = i; // 해당 인덱스를 설정
            }
        }
        if(isCacheMiss(position)) { // cache miss -> 새로들어갈원소의 맨 앞 인덱스 0 을 제외하고 값을 한 칸씩 뒤로 이동
            for(int i=cacheSize-1; i>=1; i--) {
                cache[i] = cache[i-1];
            }
        } else { // cache hit
            for(int i=position; i>=1; i--) { // 설정된 인덱스 부터 맨 앞 인덱스 0 을 제외하고 값을 한 칸씩 뒤로 이동
                cache[i] = cache[i-1];
            }
        }
        cache[0] = x; // 현재 작업 번호는 항상 맨 앞에 삽입
    }
    return cache;
}
```

# 퀵 정렬(Quick Sort)

- 퀵 정렬은 `불안정 정렬`에 속하며, 다른 원소와의 비교만으로 정렬을 수행하는 `비교 정렬`에 속한다.
- 분할 정복 알고리즘의 하나로, 평균적으로 매우 빠른 수행 속도를 자랑한다.
  - 합병 정렬(merge sort)과 달리 퀵 정렬은 리스트를 비균등하게 분할한다.
- 리스트 안에 있는 한 요소를 선택한다. 이렇게 고른 원소를 `피벗(pivot`) 이라고 한다.
  - 큰 숫자와 작은 숫자를 교환할 때, 교환하기 위한 기준을 바로 '피벗'이라고 한다.
- 퀵 정렬을 수행하기 전에는 피벗을 어떻게 설정할 것인지 미리 명시해야 한다. 피벗을 설정하고 리스트를 분할하는 방법에 따라 여러 가지 방식으로 퀵 정렬을 구분한다.
- 가장 대표적인 분할 방식이 `호어 분할(Hoare Partition)` 방식이다.
   - 찰스 앤터니 리처드 호어(Charles Antony Richard Hoare) 가 개발한 정렬 알고리즘이라 이름이 붙여졌다.
- __분할 정복(divide and conquer) 방법__
  - 문제를 작은 2개의 문제로 분리하고 각각을 해결한 다음, 결과를 모아서 원래의 문제를 해결하는 전략이다.
  - 분할 정복 방법은 대개 순환 호출을 이용하여 구현한다.
- __과정 설명 : 호어 분할(Hoare Partition)__
  - 리스트에서 첫 번째 데이터를 피벗으로 정한다.
    - 왼쪽에서부터 피벗보다 큰 데이터를 찾고, 오른쪽에서부터 피벗보다 작은 데이터를 찾는다. 그다음 큰 데이터와 작은 데이터를 교환한다.
    - Ex. 5 7 9 0 3 1 6 2 4 8 
      - Pivot : 5 
      - 왼쪽에서 피벗보다 큰 데이터 7, 오른쪽에서 피벗보다 작은 데이터 4 -> 교환
      - (반복)
      - 왼쪽에서 피벗보다 큰 데이터 6, 오른쪽에서 피벗보다 작은 데이터 1 -> 이때 위치가 엇갈린 것을 알 수 있다. 이렇게 엇갈린 경우에는 작은 데이터와 피벗의 위치를 변경한다.
      - 현재상태(분할완료) : 1 4 2 0 3 5(pivot) 6 9 7 8
        - `피벗의 왼쪽에는 작은 데이터들이 위치하도록하고, 오른쪽에는 큰 데이터들이 위치하도록 하는 작업을 분할(Divide) 혹은 파티션(Partition)이라고 한다.`
      - 이 상태에서 왼쪽 리스트와 오른쪽 리스트를 개별적으로 정렬시킨다.
        - 부분 리스트에서도 다시 피벗을 정하고 피벗을 기준으로 2개의 부분 리스트로 나누는 과정을 반복한다.
        - 부분 리스트들이 더 이상 분할이 불가능할 때까지 반복한다.
        - 리스트의 크기가 0이나 1이 될 때까지 반복한다.
- __퀵 정렬의 단계__
  - `분할(Divide)` : 입력 배열을 피벗을 기준으로 비균등하게 2개의 부분 배열(피벗을 중심으로 왼쪽: 피벗보다 작은 요소들, 오른쪽: 피벗보다 큰 요소들)로 분할한다.
  - `정복(Conquer)` : 부분 배열을 정렬한다. 부분 배열의 크기가 충분히 작지 않으면 순환 호출 을 이용하여 다시 분할 정복 방법을 적용한다.
  - `결합(Combine)` : 정렬된 부분 배열들을 하나의 배열에 합병한다.
  - 순환 호출이 한번 진행될 때마다 최소한 하나의 원소(피벗)는 최종적으로 위치가 정해지므로, 이 알고리즘은 반드시 끝난다는 것을 보장할 수 있다.

## 삽입 정렬과 퀵 정렬 

삽입 정렬은 현재 리스트의 데이터가 거의 정렬 되어 있는 상태라면 최선의 경우 O(N) 의 시간 복잡도를 가진다. 보통은 삽입 정렬이 비효율적이나, 정렬이 거의 되어 있는 상황에서는 퀵 정렬 보다
더 강력하다. 따라서 거의 정렬되어 있는 상태로 문제가 주어진다면 퀵 정렬 등 다른 정렬 알고리즘 보다 삽입 정렬을 이용하는 것이 더 좋다.

## 🔑 기본 문제

### [중복 확인](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/sorting/checkduplicate/Main.java)

```java
public String solution(int[] arr) {
    Queue<Integer> Q = new LinkedList<>();
    for(int i=0; i<arr.length; i++) {
        if(Q.contains(arr[i])) {
            return "D";
        }
        Q.offer(arr[i]);
    }
    return "U";
}

// 정렬 후 인접한 두 원소 끼리 비교
public String solution(int n, int[] arr){
    String answer="U";
    Arrays.sort(arr);
    for(int i=0; i<n-1; i++){
        if(arr[i] == arr[i+1]){
            answer="D";
            break;
        }
    }
    return answer;
}
```

### [장난꾸러기](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/sorting/mischievous/Main.java)

```java
public ArrayList<Integer> solution(int[] arr) {
    ArrayList<Integer> answer=new ArrayList<>();
    int[] tmp = arr.clone();
    Arrays.sort(tmp);
    for(int i=0; i<arr.length; i++){
        if(arr[i] != tmp[i]) {
            answer.add(i+1);
        }
    }
    return answer;
}
```

### [좌표 정렬](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/sorting/coordinatesort/Main.java)

- Point
  - Comparable 을 사용한 객체 정렬

```java
class Coordinate implements Comparable<Coordinate> {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return this.x + " " + this.y;
    }

    @Override
    public int compareTo(Coordinate o) {
        if(this.x == o.x) {
            return this.y-o.getY();
        } else {
            return this.x- o.getX();
        }
    }
}

public class Main {

    public List<Coordinate> solution(List<Coordinate> coordinates) {
        coordinates.sort(Coordinate::compareTo);
        return coordinates;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Coordinate> coordinates = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            coordinates.add(new Coordinate(x, y));
        }
        for(Coordinate coordinate : T.solution(coordinates)) {
            System.out.println(coordinate.toString());
        }
    }

}
```

## Reference

> https://gmlwjd9405.github.io
