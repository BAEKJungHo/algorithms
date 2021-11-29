# Two Pointers

- 정의
  - Two Pointers 는 1차원 배열에서 두 개의 포인터를 조작하여 원하는 결과를 얻는 알고리즘을 의미한다.
  - 정렬된 배열에서 쌍을 검색하는 데 일반적으로 사용되는 정말 쉽고 효과적인 기술이다.
- 시간 복잡도
  - O(n)
- Point
  - 두 포인터를 증가하는 것

## 🔑 기본 문제

### [두 배열 합치기](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/twopointers/sumarray/Main.java)

```
* 출력
* 오름차순으로 정렬된 배열을 출력합니다.
*
* 예시 입력 1
* 3
* 1 3 5
* 5
* 2 3 6 7 9
*
* 예시 출력 1
* 1 2 3 3 5 6 7 9
```

```java
// Two pointer 는 인터뷰에서도 물어볼 수 있는데, 배열을 합쳐서 그냥 정렬한다라고 대답하면 인상적이지 못하다.
// Two pointer 의 핵심은 말 그대로 포인터 2개를 두어 사용하며, 시간 복잡도가 O(n) 이 나와야한다.
// 퀵 정렬도 O(nlogn) 이기 때문에 속도 차이가 심하다.
// a : 1 3 5   pointer1 -> 0번째 인덱스를 가르킨다.
// b : 2 3 5 7 9 pointer2 -> 0번째 인덱스를 가르킨다.
public List<Integer> solution(int n, int m, int[] a, int[] b){
    List<Integer> answer = new ArrayList<>();
    // 포인터 2개 생성
    int p1 = 0, p2 = 0;
    while(p1 < n && p2 < m) {
        if(a[p1] < b[p2]) {
            answer.add(a[p1++]);
        } else {
            answer.add(b[p2++]);
        }
    }
    while(p1<n) answer.add(a[p1++]);
    while(p2<m) answer.add(b[p2++]);

    return answer;
}
```

### [공통 원소 구하기](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/twopointers/commonelements/Main.java)

```
* 출력
* 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
*
* 예시 입력 1
* 5
* 1 3 9 5 2
* 5
* 3 2 5 7 8
*
* 예시 출력 1
* 2 3 5
```

```java
// 오름차순으로 정렬을 먼저 시켜줘야 한다.
// Two pointer 문제니까 O(n)
public List<Integer> solution(int n, int m, int[] a, int[] b) {
    List<Integer> answer = new ArrayList<>();
    Arrays.sort(a);
    Arrays.sort(b);
    int p1 = 0, p2 = 0;
    int cnt = 0;
    while(p1 < n && p2 < m) {
        if(a[p1] == b[p2]) {
            answer.add(a[p1++]);
            p2++;
        } else if(a[p1] < b[p2]) { // 핵심 Point. 작으면 작은쪽의 Pointer 를 증가
            p1++;
        } else { // 핵심 Point. 작으면 작은쪽의 Pointer 를 증가
            p2++;
        }
    }
    return answer;
}
```

### [연속 부분 수열](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/twopointers/continuoussequence/Main.java)

__아래 코드는 암기하는게 좋음__

```java
  public int solution(int n, int m, int[] arr) {
      int answer=0, sum=0, lt=0;
      for(int rt=0; rt<n; rt++){
          sum+=arr[rt];
          if(sum==m) answer++;
          while(sum>=m){
              sum-=arr[lt++];
              if(sum==m) answer++;
          }
      }
      return answer;
  }
```

### [연속된 자연수의 합](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/twopointers/continuoussum/Main.java)

```java
// 1. 배열을 만든다 15 기준으로 연속된 자연수의 합이 15가 되려면 7,8 이 끝임 즉, 배열의 원소는 15/2+1만큼만 있으면 됌
// 2. Two pointers 와 Sliding window 를 이용
public int solution(int n) {
    int size = n/2 + 1;
    int[] arr = new int[size];
    for(int i=0; i<size; i++) {
        arr[i] = i+1;
    }

    // Two pointers 와 Sliding window 를 이용 : 암기
    int answer = 0, sum = 0, lt = 0;
    for(int rt=0; rt<size; rt++) {
        sum += arr[rt];
        if(sum == n) {
            answer++;
        }
        while(sum >= n) {
            sum -= arr[lt++];
            if(sum == n) {
                answer++;
            }
        }
    }

    return answer;
}
```

# Sliding Window

- 정의
  - 슬라이딩 윈도우(Sliding Window) 알고리즘은 배열이나 리스트의 요소의 일정 범위의 값을 비교할때 사용하면 유용한 알고리즘이다.
  - 마치 창문을 한 쪽으로 밀면서 문제를 푸는 것과 모양이 유사해서 붙여진 이름이다.
  - 투 포인터처럼 구간을 훑으면서 지나간다는 공통점이 있으나, 슬라이딩 윈도우는 어느 순간에도 그 구간의 넓이가 동일하다는 차이점이 있다.
- 시간 복잡도
  - O(n)

예를 들어 원소 `12 15 11 20 25 10 20 19 13 15` 를 갖는 배열이 있고 연속된 3개의 값의 합을 비교해야한다고 할 때, `i=0 ~ i=연속된 n개-1` 만큼을 자르면 12, 15, 11 이다. 자른 모양이 창문과 같고, 오른쪽으로 쭉 밀고가면되기때문에 `슬라이딩 윈도우(Sliding Window)`라는 이름이 붙여졌다.


> Two Pointers, Sliding Window 알고리즘은 O(n^2) 을 O(n) 으로 해결하는 알고리즘이다. 문제에서 입력 값이 몇 십만 처럼 상당히 큰 경우에는 Two Pointers, Sliding Window 알고리즘을 사용하는 건 아닌지 확인해봐야 한다.

## 🔑 기본 문제

### [최대 매출](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/twopointers/slidingwindow/maxsales/Main.java)

```java
public int solution(int n, int m, int[] arr) {
    int answer = 0, sum = 0;

    // sum 초기화 : 연속된 m 개의 합
    for(int i=0; i<m; i++) {
        sum += arr[i];
    }

    // answer 초기화
    answer = sum;

    // m 부터 n 까지 반복문
    // 기존 sum 을 더하는 이유는 공통요소가 들어있기 때문이다. (sum = 공통요소의 합 + 맨 뒷자리의 값)
    // 즉, m 이후의 반복문에서는 공통요소의합 + m 이후의 값 - 기존 sum 의 맨 뒷자리의 값(i-m) 이된다.
    for(int i=m; i<n; i++) {
        sum += (arr[i] - arr[i-m]); // Point. 공통요소는 냅두고, 맨 뒷 자리 값만 뺀다.
        answer = Math.max(answer, sum);
    }
    return answer;
}
```
