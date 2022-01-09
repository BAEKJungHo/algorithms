package inflearn.dpnamicprogramming.lis;

import java.util.Scanner;

// LIS : 최대 부분 증가수열
public class Main {

    static int N;
    static int[] arr;
    static int[] dp;
    static int answer = 0;

    public static void main(String[] args) {
        input();
        solution();
        System.out.println(answer);
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
    }

    static void solution() {
        dp = new int[arr.length];
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int k = i - 1; k >= 0; k--) {
                if (arr[k] < arr[i] && dp[k] > max) {
                    max = dp[k];
                }
            }
            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }
    }

}
