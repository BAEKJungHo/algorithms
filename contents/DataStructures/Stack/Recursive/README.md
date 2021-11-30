# 재귀 함수(Recursive Function)

재귀 함수(Recursive Function)란 자기 자신을 다시 호출하는 함수를 의미한다.

```java
public class Main {

    public static void recursiveFunction() {
        System.out.println("재귀 함수를 호출합니다.");
        recursiveFunction();
    }

    public static void main(String[] args) {
        recursiveFunction();
    }
}
```

재귀 함수는 종료 조건이 무조건 있어야 한다. 그렇지 않으면 무한 루프에 빠질 수 있다.

```java
public class Main {

    public static void recursiveFunction(int i) {
        // 100번째 호출을 했을 때 종료되도록 종료 조건 명시
        if (i == 100) return;
        System.out.println(i + "번째 재귀 함수에서 " + (i + 1) + "번째 재귀함수를 호출합니다.");
        recursiveFunction(i + 1);
        System.out.println(i + "번째 재귀 함수를 종료합니다.");
    }

    public static void main(String[] args) {
        recursiveFunction(1);
    }
}
```

재귀 함수는 내부적으로 [스택(Stack)](https://github.com/BAEKJungHo/algorithms/tree/master/contents/DataStructures/Stack)을 이용한다. 함수를 계속 호출했을 때 가장 마지막에 호출한
함수가 먼저 수행을 끝내야 그 앞의 함수 호출이 종료되기 때문이다.

컴퓨터 구조 측면에서 보자면 연속해서 호출되는 함수는 메인 메모리의 [스택 공간](https://webdevtechblog.com/jvm-java-virtual-machine-architecture-94b914e93d86)에 적재되므로, 재귀 함수는 스택 자료구조와 같다는 말은 틀린 말이 아니다.

> 메서드를 호출할 때마다 스택이 개별적으로 생성된다.

재귀 함수를 이용하는 대표적인 예제로는 `팩토리얼(Factorial)` 문제가 있다.

> 팩토리얼(Factorial) : n! > 1 x 2 x 3 x ... x (n-1) x n

수학적으로 `0!` 과 `1!`은 1로 같다는 성질을 이용하여 n 이 1 이하가 되었을 때 함수를 종료하는 재귀 함수의 형태로 구현할 수 있다.

## 팩토리얼(Factorial)

```java
public class Main {

    // 반복적으로 구현한 n!
    public static int factorialIterative(int n) {
        int result = 1;
        // 1부터 n까지의 수를 차례대로 곱하기
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // 재귀적으로 구현한 n!
    public static int factorialRecursive(int n) {
        // n이 1 이하인 경우 1을 반환
        if (n <= 1) return 1;
        // n! = n * (n - 1)!를 그대로 코드로 작성하기
        return n * factorialRecursive(n - 1);
    }

    public static void main(String[] args) {
        // 각각의 방식으로 구현한 n! 출력(n = 5)
        System.out.println("반복적으로 구현:" + factorialIterative(5));
        System.out.println("재귀적으로 구현:" + factorialRecursive(5));
    }
}
```

재귀 함수를 사용했을 때의 장점은 `코드가 더 간결`해진다는 것이다. 이렇게 간결해진 이유는 재귀 함수가 수학의 `점화식(재귀식)`을 그대로 소스코드로 옮겼기 때문이다. 수학에서 점화식은
특정한 함수를 자신보다 더 작은 변수에 대한 함수와의 관계로 표현한 것을 의미한다. 이 개념은 `다이나믹 프로그래밍`을 배울 때 중요하다.

- __Factorial 점화식__
  - n 이 0이거나 1일때 : factorial(n) = 1
  - n 이 1보다 클 때 : factorial(n) = n x factorial(n-1)  

## 스택(Stack)과 재귀(Recursive)

재귀(Recursive)를 제대로 이해하는 것은 마냥 쉽진 않다. 일단 재귀가 스택(Stack)으로 동작한다는 것을 설명하기 위해 `Factorial` 구현을 예시로 들었다.

```java
public class Recursive {

     public int solution(int n) {
        System.out.println(Thread.currentThread().getName()); // 현재 실행중인 스레드 이름
        return n <= 1 ? 1 : n * solution(n-1);
    }

    public static void main(String[] args) {
        Recursive T = new Recursive();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }
}
```

자, 재귀가 스택으로 동작한다는 것을 이해하기 위해선 다음과 같은 내용에 대해서 이해하고 있어야 한다.

- __JVM 메모리 스택 영역__
    - 자바에서는 `스레드가 생성 될 때 마다` 스택 영역이 개별적으로 생성된다. 
    - 스레드가 메서드 호출 시, 지역변수, 매개변수 등이 저장된다.
    - Heap 영역에 생성된 `Object 타입 | 데이터` 의 참조 변수(Reference Variable)가 할당된다.
        - Ex. String ref = "abc";
        - 실제로 Heap 영역에는 String | "abc" 이런식으로 들어가고, ref 의 참조 변수가 stack 에 할당된다. 
    - 원시타입의 데이터가 값과 함께 할당된다.
    - 지역변수들은 `scope` 에 따른 `visibility` 를 가진다.
    - 가장 마지막에 호출한 함수가 종료 되어야 이 전에 호출한 함수들도 종료가 된다.
- __JVM 메모리 힙 영역__
    - Heap 영역에는 주로 긴 생명주기를 가지는 데이터들이 저장된다. (대부분의 오브젝트는 크기가 크고, 서로 다른 코드블럭에서 공유되는 경우가 많다.)
    - 애플리케이션의 모든 메모리 중 stack 에 있는 데이터를 제외한 부분이라고 보면 된다.
    - 모든 Object 타입(Integer, String, ArrayList, ...)은 heap 영역에 생성된다.
    - 몇개의 스레드가 존재하든 상관없이 단 하나의 heap 영역만 존재한다.
    - Heap 영역에 있는 오브젝트들을 가리키는 레퍼런스 변수가 stack 에 올라가게 된다.
- __스택 자료 구조__
    - LIFO(Last In First Out)

> [자바 스택과 힙 메모리 관리](https://yaboong.github.io/java/2018/05/26/java-memory-management/)

자, 이제 위 코드의 입력(N) 값을 5로 주고 돌려보자.

결과는 다음과 같다. 

```
main 
main
main
main
main
120
```

자, 재귀가 현재 main 스레드 위에서 동작하는 것을 볼 수 있다. (즉, 스레드가 현재 1개이다.) 그러면 위에서 배운 개념을 적용하면 생성된 스택 영역도 1개인 것이다.

그림으로 스택과 재귀의 동작 과정을 살펴보자.

1. 스택에 들어갈 매개변수는 n 하나이다. (현재 n = 5)





