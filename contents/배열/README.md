# 배열

## 🔑 피보나치 수열

- 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
- Ex. 1 1 2 3 5 8 13 21 34 55

### [피보나치 수열](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/array/fibonaccisequence/Main.java)

```
* 예시 입력 1
* 10
*
* 예시 출력 1
* 1 1 2 3 5 8 13 21 34 55
```

```java
public int[] solution(int count) {
    int start = 1;
    int[] answer = new int[count];
    answer[0] = 1;
    answer[1] = 1;
    for(int i=2; i<count; i++) {
        answer[i] = answer[i-2] + answer[i-1];
    }
    return answer;
}

// 손 코딩 문제 
public void solution2(int n) {
    int a=1, b=1, c;
    System.out.println(a+" "+b+" ");
    for(int i=2; i<n; i++) {
        c=a+b;
        System.out.println(c+ " ");
        a = b;
        b = c;
    }
}
```

## 🔑 소수(에라토스테네스 체)

- 소수란 1과 자기 자신만으로 나누어 떨어지는 1보다 큰 양의 정수를 의미한다.
- Ex. 2, 3, 5, 7, 11, 13, 17, 19

### [소수](https://github.com/BAEKJungHo/algorithms/blob/master/src/src/main/java/inflearn/array/eratosthenes/Main.java)

```
자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
```

- Point
  - N+1 만큼의 0으로 초기화된 배열 생성
  - 이중 포문 BUT if 문으로 제어 필요 -> 무작정 이중 포문 돌릴 시 시간 초과에 걸릴 수 있음.
  - 자기 배수에 해당하는 배열 부분들을 1 로 업데이트(즉, 소수가 아닌 부분은 1로 업데이트)

```java
public int solution(int number) {
    int cnt = 0;
    int[] ch = new int[number+1];
    for(int i=2; i<=number; i++) {
        if(ch[i] == 0) {
            cnt++;
            for(int k=i; k<=number; k=k+i) { // 자기 배수에 해당하는 배열 부분들을 1 로 업데이트(즉, 소수가 아닌 부분은 1로 업데이트)
                ch[k] = 1;
            }
        }
    }
    return cnt;
}
```
