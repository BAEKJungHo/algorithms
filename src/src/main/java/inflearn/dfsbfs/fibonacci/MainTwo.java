package inflearn.dfsbfs.fibonacci;

import java.util.Scanner;

// 피보나치 수열 : 앞의 2개의 수를 합하여 다음 숫자가 되는 수열
// 아래의 코드에서 입력값 n = 45 일때 재귀를 돌면서 배열에 저장하기 때문에 8초가 걸린다.
// 4초 -> 1초 개선 방법은 메모이제이션을 이용하는 것이다.
public class MainTwo {

    private static int n;
    private static int[] fibonacciResult;

    public static void main(String[] args) {
        initializeInputData();
        fibonacci(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibonacciResult[i] + " ");
        }
    }

    private static void initializeInputData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        fibonacciResult = new int[n + 1];  // 1 1 2 3 ... 따라서 0 번째 인덱스는 필요 없음
    }

    // 점화식 fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)
    // 종료 조건 n == 1 || n == 2
    private static int fibonacci(int n) {
        if(n == 1 || n == 2) {
            return fibonacciResult[n] = 1;
        } else {
            return fibonacciResult[n] = fibonacci(n - 2) + fibonacci(n - 1);
        }
    }
}
