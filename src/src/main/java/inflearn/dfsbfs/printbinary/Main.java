package inflearn.dfsbfs.printbinary;

import java.util.Scanner;

// 이진수 출력(재귀)
// Ex. 입력 값 11이 주어졌을 때 2로 계속 나눈 나머지를 합해서 출력
public class Main {

    private static int n;

    public static void main(String[] args) {
        input();
        recursive(n);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
    }

    public static void recursive(int n) {
        // 종료조건 : n = 0
        if(n == 0) {
            return;
        } else {
            System.out.print(n % 2 + " ");
            recursive(n/2);
        }
    }

}
