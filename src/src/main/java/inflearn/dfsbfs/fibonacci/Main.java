package inflearn.dfsbfs.fibonacci;

import java.util.Scanner;

// 피보나치 수열 : 앞의 2개의 수를 합하여 다음 숫자가 되는 수열
public class Main {

    private static int n;

    public static void main(String[] args) {
        initializeInputData();
        for (int i = 1; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    private static void initializeInputData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
    }

    // 점화식 fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)
    // 종료 조건 n == 1 || n == 2
    private static int fibonacci(int n) {
        if(n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 2) + fibonacci(n - 1);
        }
    }
}
