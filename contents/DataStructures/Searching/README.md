# 순차 탐색(Sequential Search)

순차 탐색이란 __리스트 안에 있는 특정한 데이터를 찾기 위해 앞에서부터 데이터를 하나씩 차례대로 확인하는 방법__ 이다. 보통 정렬되지 않은 리스트에서 데이터를 찾아야할 때 사용하며, 리스트 내에 데이터가 아무리 많아도 시간만 충분하면 결과를 찾을 수 있다.

## 구현

```java
/**
 * @param n 입력 데이터 개수
 * @param target 찾고자 하는 문자열
 * @param arr 배열
 */
public static int sequantialSearch(int n, String target, String[] arr) {
    // 각 원소를 하나씩 확인하며
    for (int i = 0; i < n; i++) {
        // 현재의 원소가 찾고자 하는 원소와 동일한 경우
        if (arr[i].equals(target)) {
            return i + 1; // 현재의 위치 반환 (인덱스는 0부터 시작하므로 1 더하기)
        }
    }
    return -1; // 원소를 찾지 못한 경우 -1 반환
}
```

- __시간 복잡도__
  - `O(N)`
  - 최악의 경우에는 데이터 개수가 N 개일 때 N 번의 비교 연산이 필요하기 때문이다.
 
# 이분 검색(이진 탐색, Binary Search)

이분 검색은 __말 그대로 반으로 쪼개서 찾고자 하는 값이 해당되지 않는 범위는 날리고, 다시 쪼개진 반에서 이분 검색을 실시한다. 이분 검색을 실시하기전에 오름차순 정렬이 되어있어야 한다.__

- __특징__
  - 탐색 범위를 반으로 좁혀가면서 탐색 
  - 이진 탐색을 하기 위한 전제 조건(precondition) : 탐색을 실시하기전에 `오름차순 정렬`이 되어있어야 한다.
  - 입력 데이터 개수의 범위가 1,000 만을 넘어가면 이진 탐색 혹은 `O(logN)` 의 속도를 내야 하는 알고리즘을 떠올려야 한다.
  - 위치를 나타내는 변수 3개 사용 : `시작점(startPoint = 0), 끝점(endPoint = n-1), 중간점(middlePoint)`
    - 각 Point 들은 값이 아닌 배열의 `Index` 를 나타낸다.
  - 이진 탐색은 데이터를 절 반씩 줄여가면서 탐색하기 때문에 시간 복잡도는 `O(logN)` 이다.
  
- __구현 절차__
   1. 배열을 오름차순으로 정렬 (정렬이 안되어있다 가정) : `Arrays.sort(arr);`
   2. 시작점, 끝점 초기화
   3. 중간점 계산식 : `middlePoint = (startPoint + endPoint) / 2;`
      - 중간점(middlePoint)이 실수일 경우에는 소수점을 버린다. (Ex. (0 + 3) / 2  -> middlePoint = 1)
   4. 중간점과 찾고자 하는 값(target)을 비교한다.
   5. 찾고자 하는 데이터가 더 작은 쪽에 속하면 끝점 index 를 감소 : `endPoint = middlePoint - 1;`
   6. 찾고자 하는 데이터가 더 큰 쪽에 속하면 시작점 index 를 증가 : `startPoint = middlePoint + 1;`
   7. 2번 또는 3번을 수행하고나서 1번(중간점 계산식)을 수행. 즉, 중간점을 다시 계산
 - `찾으려는 데이터와 중간점(Middle) 위치에 있는 데이터를 반복적으로 비교` 해서 원하는 데이터를 찾는 과정

"이진 탐색에 대한 구현은 `손 코딩`으로도 나올만한 문제라고 합니다. 따라서 `절차`를 잘 기억하고 있어야 합니다."

## 구현

### 반복문으로 구현하기

```java
private static int n; // 입력 데이터 개수
private static int[] arr; // 탐색 대상인 배열
private static int target; // 찾고자 하는 값

public static int solution() {
  // 찾고자 하는 값의 위치
  int targetIndex = 0;

  // 시작점, 끝점 초기화
  int startPoint = 0;
  int endPoint = n - 1;
  
  // 배열 오름차순 정렬
  Arrays.sort(arr);
  
  // endPoint 의 index 가 더 크거나 같을 때 까지 반복
  while(startPoint <= endPoint) {
        // 중간점 계산
        // while 문 안에 선언하는 이유는 아래에서 startPoint 와 endPoint 의 인덱스 변화가 있을때 다시 계산하기 위함이다.
        int middlePoint = (startPoint + endPoint) / 2;

        // 중간점이 target 값과 동일한 경우    
        if(arr[middlePoint] == target) { 
           targetIndex = middlePoint; // 문제에 따라서 위치 번호를 출력하라고 하면 middlePoint + 1 이 될 수도 있음.
           break;
        }

        // 찾고자 하는 데이터가 더 작은 쪽에 속하면 끝점 index 를 감소
        if(arr[middlePoint] > target) {  
           endPoint = middlePoint - 1;
        } 
        // 찾고자 하는 데이터가 더 큰 쪽에 속하면 시작점 index 를 증가
        else {
           startPoint = middlePoint + 1;
        }
  }
  
  return targetIndex;
}
```

### 재귀로 구현하기

재귀는 사실 별로 추천하지 않는다. 현업에서도 재귀를 쓸일이 많이 없으며, 쓴다하더라도 `재귀의 늪`에 빠질 수 있기 때문에 가급적 추천하지 않는다.
또한, 재귀를 쓴다고하면 재귀를 쓴 이유부터해서 트집잡을게 많아진다고 생각한다.

```java
// 이진 탐색 소스코드 구현(재귀 함수)
public static int binarySearch(int[] arr, int target, int start, int end) {
    if (start > end) return -1;
    int mid = (start + end) / 2;
    // 찾은 경우 중간점 인덱스 반환
    if (arr[mid] == target) return mid;
    // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
    else if (arr[mid] > target) return binarySearch(arr, target, start, mid - 1);
    // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
    else return binarySearch(arr, target, mid + 1, end);
}
```

## 이진 탐색 트리(Binary Search Tree)

트리 자료구조는 그래프 자료구조의 일종으로 데이터베이스 시스템이나 파일 시스템과 같은 곳에서 많은 양의 데이터를 관리하기 위한 목적으로 사용한다.

- __트리 자료구조 특징__
    - 트리는 부모 노드와 자식 노드의 관계로 표현된다.
    - 트리의 최상단 노드를 루트 노드(root node)라고 한다.
    - 트리의 최하단 노드를 단말 노드(leaf node)라고 한다.
    - 트리에서 일부를 떼어내도 트리 구조이며, 이를 서브 트리(sub tree)라고 한다.
    - 트리는 파일 시스템과 같이 계층적이고 정렬된 데이터를 다루기에 효과적이다.

큰 데이터를 처리하는 소프트웨어는 대부분 데이터를 트리 자료구조로 저장해서 이진 탐색과 같은 탐색 기법을 사용하여 빠르게 탐색이 가능하다.

이진 탐색 트리는 트리 자료구조 중에서 가장 간단한 트리이다.

- __이진 탐색 트리의 특징__
    - 부모 노드보다 왼쪽 자식 노드가 작다.
    - 부모 노드보다 오른쪽 자식 노드가 크다.
    - 이진 탐색 트리 자료구조를 구현하라고하는 문제는 출제 빈도가 낮다.

![IMAGES](../images/binarysearchtree.JPG)

찾고자 하는 값이 `37`이면 30 기준으로 이진 탐색을 실시하면 된다. 일단 루트 노드보다 찾고자하는 값이 크므로 왼쪽을 날리고, 오른쪽 그래프에서 다시 이진 탐색을 실시한다.

# 결정 알고리즘과 파라메트릭 서치

파라메트릭 서치(Parametric Search)는 Parametirc 이라는 단어를 보면 알 수 있듯이 `매개 변수를 이용한 탐색 기법`이라는 것을 알 수 있다. 파라메트릭 서치(Parametric Search) 는 `최적화 문제` 를 `결정 문제` 로 바꾸어 해결하는 기법이다. 즉, 결정 알고리즘(Decision Algorithm)을 사용한다. 결정 알고리즘은 `이분 검색(Binary Search)`을 사용하는데 구하고자하는 답이, 원소의 나열 안(배열)에(`<-startPoint---------------endPoint->`) 존재하는 경우에 사용한다. 문제의 풀이 아이디어는 `구하고자하는 답(answer)을 반복해서 조정`한다.

자, 이해하기 쉽게 정리하자면 __"파라메트릭 서치(Parametric Search)는 `매개변수를 이용한 탐색 기법`이며 최적화된 답을 구하기 위해 `결정 알고리즘`을 사용한다."__ 라고 할 수 있다.

> 대부분의 블로그 글을 보더라도 파라메트릭 서치(Parametric Search)는 최적화된 문제를 결정문제로 바꾸어서 푼다라고만 설명되어있다. 매개변수라는 포인트를 짚어서 설명한 글을 찾기가 힘들다. 심지어 인프런 인강에서 조차 명쾌하게 설명해주질 않는다. 
> 책을 포함한 결정 알고리즘 문제 3개를 분석하면서 왜 `Parametric` 이라는 단어를 썼을까 분석해보았다. 개인적인 의견이 들어간 부분일 수 있어서 필터링 해서 받아들이면 될 것 같다.

- __파라메트릭 서치(Parametric Search)__
    - 매개 변수를 이용한 탐색 기법
    - 최적화 문제를 결정 알고리즘을 사용하여 해결
        - 결정 알고리즘은 이진 탐색을 사용
        - 결정 알고리즘은 원소의 나열 안에 구하고자 하는 답이 존재하는 경우 사용
    - 문제 풀이 아이디어 : 구하고자하는 답(answer)을 반복해서 조정
        - 즉, 구하고자 하는 답(answer)는 반복문 안에서 계속해서 변경된다.
        - 구하고자하는 답(answer)은 반복문안에서 계속해서 변경되는 중간점(middlePoint)을 의미한다.
        - 즉, 결정 알고리즘에서는 최종적으로 middlePoint 가 answer 가 된다.
    - 단순 이진 탐색 구현과의 차이점
        - 함수를 사용한다.
        - 결정 알고리즘에서 시작점(startPoint) : 입력 값 n 의 시작 범위 (1 <= n <= 1000000 이므로 1)
        - 결정 알고리즘에서 끝점(endPoint) : 배열의 마지막 원소 값(`arr[n-1]`)
        - 반복문이 끝난 middlePoint 가 answer 가 된다.
- __문제를 읽고 파라메트릭 서치(Parametric Search)를 사용해야하는지 안하는지에 대한 판단 기준__
    - 최적화된 값을 요구한다.
    - 구하고자 하는 값의 범위가 상당히 큰 경우
    - 이분 검색을 사용해야 하는 경우
    - Hint. 위 세개와 비슷한 느낌을 받으며, 문제에서 다음과 같은 문구가 주어진다. `최댓값 혹은 최솟값 을 구하세요. 출력하세요.` 이러면 거의 결정 알고리즘(Decision Algorithm) 문제일 가능성이 높다.
        - Ex. 첫 줄에 ~ 최대 거리를 출력하세요.
        - Ex. 첫 줄에 ~ 최솟값을 출력하세요.

다시, Parametric 이라는 단어가 왜 사용되었을지 분석해보자. "매개변수를 이용한다라는 의미가 무엇일까 ?" 매개변수는 함수(메서드) 시그니처에 존재하는 변수이다. 즉, `함수를 사용`한다는 것이다.
함수를 사용하는데 그러면 어떤 함수를 만들라는 것인지 궁금할 수 있다. 핵심은 `구하고자하는 답(answer)을 반복해서 조정하기 위한 판단을 내려주는 함수` 를 만드는 것이다. 즉, `최적화된 값을 구하기 위해 판단을 내려주는 함수`라고 생각하면 된다. 문제 마다 조건이 다르기 때문에 함수의 내부 구현 방식이 당연히 달라진다.

최적화된 값을 구하기 위해 판단을 내려주는 함수(`decisionToFindTheOptimizedValue`)를 사용한다라는 것까진 이해가 됐을것이다. 그러면 해당 함수에 어떤 파라미터(Parameter)를 넘겨주는지가 두 번째 핵심인데, 입력 값을 가지고 있는 배열과 구하고자하는 답(answer)을 파라미터로 넘겨준다. (만약, 배열을 static 으로 선언했다면 answer 만 넘겨주면 될 것이다. 어쨋든 함수 내부에서는 배열과 answer 둘 다 필요하다라는 의미이다.)

decisionToFindTheOptimizedValue 함수의 결과랑 조건(M)의 값과 비교하여 조건이 함수의 결과보다 작거나 같으면 시작점(startPoint)을 증가시키면서 answer 의 값을 중간점(middlePoint)으로 갱신해주면 된다. 함수의 결과보다 크다면 끝점(endPoint) 를 감소시킨다. 근데 이 부분은 문제에서 최댓값을 구하는 경우에 그렇다.

- __최댓값을 구하는 경우__

```java
if(decisionToFindTheOptimizedValue(arr, middlePoint) >= m) {
    answer = middlePoint;
    startPoint = middlePoint + 1;
} else {
    endPoint = middlePoint - 1;
}
```

반면 최솟값을 구하는 경우에는 조금 달라질 수도 있다.

- __최솟값을 구하는 경우__

```java
if(decisionToFindTheOptimizedValue(arr, middlePoint) <= m) {
    answer = middlePoint;
    endPoint = middlePoint - 1;
} else {
    startPoint = middlePoint + 1;
}
```

- __최종 구현 Sample : 최댓값을 구하는 경우__
    - 문제 : 이것이코딩테스트다 떡볶이 떡 만들기

```java
public class Main {

    private static int n; // 입력 데이터 개수 
    private static int m; // 조건(condition) : 손님이 얻고자 하는 떡의 길이
    private static int[] arr; // 배열

    public static void main(String[] args) {
        initializeInputData();
        System.out.println(decisionAlgorithm());
    }

    private static void initializeInputData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    // 결정 알고리즘(Decision Algorithm)
    private static int decisionAlgorithm() {
        ascendingSort(riceCakes); // precondition

        int answer = 0; // 구하고자하는 답
        int startPoint = 1; // 입력 값 n 의 시작 범위 (1 <= n <= 1000000 이므로 1)
        int endPoint = arr[n - 1]; // 배열의 마지막 원소 값

        while(startPoint <= endPoint) {
            int middlePoint = (startPoint + endPoint) / 2;
            if(decisionToFindTheOptimizedValue(middlePoint) >= m) {
                answer = middlePoint; // 구하고자하는 답(answer)을 반복해서 조정
                startPoint = middlePoint + 1;
            } else {
                endPoint = middlePoint - 1;
            }
        }

        return answer;
    }

    private static void ascendingSort(int[] arr) {
        Arrays.sort(arr);
    }

    // 최적화된 값을 구하기 위해 판단을 내려주는 함수
    private static int decisionToFindTheOptimizedValue(int middlePoint) {
        int sum = 0;
        for(int element : arr) {
            if(element > middlePoint) {
                sum += element - middlePoint;
            }
        }
        return sum;
    }
}
```

즉, 다음과 같이 정리할 수 있다. 결정 알고리즘을 구현하는 메서드 안은 이진 탐색 코드가 적용되어 있으며, 이진 탐색 코드에서는 최적화된 값을 구하기 위해 판단을 내려주는 함수를 만들어서 사용한다. 
실제로 이와 비슷하거나 조금 어려운 수준의 결정 알고리즘을 사용하는 문제들의 풀이 형식을 보면 달라지는 곳은 딱 정해져있다. 최댓값을 구하는지 최솟값을 구하는지에 따라 while 문 내부가 달라지며,
문제의 조건에 맞는 최적화된 값을 구하기 위해 decisionToFindTheOptimizedValue() 함수의 내부 구현이 달라진다.

```
func decisionAlgorithm() {
   Binary Search Algorithm code {
        func decisionToFindTheOptimizedValue();
   }
}
```

> 단, 결정 알고리즘을 사용하는 모든 문제가 이렇다라는것은 아니다.(맞을 수도 있고 아닐 수도 있고), 하지만 몇몇 문제를 분석해본 결과 떡볶이 문제랑 비슷하거나 조금 더 어려운 수준의 문제는 위와 같은 스타일로 해결할 수 있는 것 같다.

## [뮤직비디오(결정알고리즘)](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/searching/musicvideo/Main.java)

```
 * 설명
 * 지니레코드에서는 불세출의 가수 조영필의 라이브 동영상을 DVD로 만들어 판매하려 한다.
 * DVD에는 총 N개의 곡이 들어가는데, DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지되어야 한다.
 * 순서가 바뀌는 것을 우리의 가수 조영필씨가 매우 싫어한다. 즉, 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는
 * 1번과 5번 사이의 모든 노래도 같은 DVD에 녹화해야 한다. 또한 한 노래를 쪼개서 두 개의 DVD에 녹화하면 안된다.
 * 지니레코드 입장에서는 이 DVD가 팔릴 것인지 확신할 수 없기 때문에 이 사업에 낭비되는 DVD를 가급적 줄이려고 한다.
 * 고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 하였다. 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.
 * 그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 꼭 같은 크기로 해야 한다.
```

- 입력
  - 첫째 줄에 자연수 N(1≤N≤1,000), M(1≤M≤N)이 주어진다.
  - 다음 줄에는 조영필이 라이브에서 부른 순서대로 부른 곡의 길이가 분 단위로(자연수) 주어진다.
  - 부른 곡의 길이는 10,000분을 넘지 않는다고 가정하자.
  - Ex. 1 2 3 4 5 6 7 8 9
- 출력 : 첫 번째 줄 부터 DVD 의 최소 용량 크기를 출력하세요.

결정(Decision) 알고리즘은 `이분 검색(Binary Search)`을 사용하는데, `<-startPoint---------------endPoint->` 범위 안에 정답이 있는 경우에 사용한다. 위 문제에서 요구하는 정답은 `DVD 의 최소 용량 크기`이다.

lt 가 1 이고 rt 가 10000 이라고 할 때 이분검색을 하면 중앙은 5000 이 된다. 5000 이라는 값안에 DVD 의 최소 용량 크기가 무조건 포함된다. 물론 5000 은 답에 비해 너무 큰 값이지만 어쨋든 포함이 된다는 것이 중요하다.

위 문제 입력 예시 `1 2 3 4 5 6 7 8 9` 기준으로 lt, rt 값을 정하면 lt 는 9가 되며, rt 는 45가된다.

```java
public int count(int[] arr, int capacity){
    int cnt = 1, sum = 0; // cnt dvd 장 수 -> 첫 번째 장에 담는 다는 의미
    for(int x : arr) {
        if(sum + x > capacity) {
            cnt++;
            sum = x;
        }
        else {
            sum += x;
        }
    }

    return cnt;
}

/**
 * @param n 배열 사이즈
 * @param m DVD 갯수
 * @param arr 부른 곡의 길이 배열
 */
public int solution(int n, int m, int[] arr) {
    int answer = 0;
    int lt = Arrays.stream(arr).max().getAsInt();
    int rt = Arrays.stream(arr).sum();

    // 이분 검색으로 쪼갠 중간 값(mid)이 DVD 의 용량(capacity)을 나타낸다.
   while(lt <= rt) {
        int mid = (lt + rt) / 2; // DVD Capacity
        if(count(arr, mid) <= m) {
            answer = mid;
            rt = mid - 1;
        } else {
            lt = mid + 1;
        }
    }

    return answer;
}
```

## [마구간 정하기](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/searching/decisionstable/Main.java)

```java
// 두 말의 최대 거리(dist)를 기준으로 배치할 수 있는 말의 마리 수
public int count(int[] arr, int dist){
    int cnt=1;
    int endPosition=arr[0];
    for(int i=1; i<arr.length; i++){
        if(arr[i]-endPosition>=dist){
            cnt++;
            endPosition=arr[i];
        }
    }
    return cnt; // 배치한 말의 마리 수
}

/**
 * @param n 배열 크기
 * @param c 배치하고싶은 말의 마리 수
 * @param arr 마구간 좌표
 */
public int solution(int n, int c, int[] arr){
    int answer=0;
    Arrays.sort(arr); // 마구간 좌표 오름차순 정렬
    int lt=1;
    int rt=arr[n-1]; // 마지막 인덱스 값
    while(lt<=rt){
        int mid=(lt+rt)/2; // 두 말의 최대 거리
        if(count(arr, mid)>=c){ // 배치한 말의 마리수 >= 배치 하고 싶은 말의 마리 수
            answer=mid;
            lt=mid+1;
        }
        else rt=mid-1;
    }
    return answer;
}
```
