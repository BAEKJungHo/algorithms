package inflearn.dfsbfs.fibonacci;

import java.util.Scanner;

// 메모이제이션
public class Memoization {

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
        // Memoization 기법 사용
        if(hasResult(n)) {
            return fibonacciResult[n];
        }

        // 재귀를 이용한 Fibonacci 계산
        if (n == 1 || n == 2) {
            return fibonacciResult[n] = 1;
        } else {
            return fibonacciResult[n] = fibonacci(n - 2) + fibonacci(n - 1);
        }
    }

    // 처음에 배열이 0으로 초기화 되니까 0 보다 크면 이미 계산된 값이 존재한다는 의미
    private static boolean hasResult(int n) {
        return fibonacciResult[n] > 0;
    }
}