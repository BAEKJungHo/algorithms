package thisiscodingtest.chapter8.constructionfloor;

import java.util.Scanner;

/**
 * 바닥 공사
 */
public class Main {

    private static int n; // 가로의 길이
    private static int[] dp = new int[1001]; // 경우의 수를 담고 있는 배열

    public static void main(String[] args) {
        input();
        solution();
        System.out.println(dp[n]);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
    }

    private static void solution() {
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 796796;
        }
    }
}
