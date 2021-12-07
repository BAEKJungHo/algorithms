package thisiscodingtest.chapter8.makeitone;

import java.util.Scanner;

/**
 * # 1로 만들기
 * 동적 계획법이고 최대한 Bottom-Up 방식을 사용해서 해결하기
 * 핵심은 저장된 결과를 재사용
 */
public class Main {

    private static int x;
    private static int[] dp = new int[30001];

    // 1. 최소 연산 값에 대한 초기 값 정하기
    // 2번이 점화식 세우기인데 점화식을 세우고 코드를 작성하고나서 초기값이 필요가 없으면 지우면 됌
    // 이 문제에서는 굳이 필요 없음
    static {
        dp[1] = 0; // 재귀로 구현한다고 했을때는 1이 종료조건임
        dp[2] = 1; // 2는 연산 1번 수행 1을 빼거나 2로 나누거나 둘 중 하나
    }

    public static void main(String[] args) {
        input();
        solution();
        System.out.println(dp[x]);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
    }

    // 2. 점화식 세우기
    // - 1번에서 1과 2에 대한 초기값을 줬다.
    // - 3에 대한 계산을 돌려서 점화식을 만들어보자
        // < 1을 빼는 경우 >
        // code : dpTable[3] = dpTable[2] + 1;
        // 해석 : 1을 빼는 경우에 대한 3의 최소 연산 횟수는  = 2의 최소 연산 횟수 + 1(여기의 1은 1을 뺀다는 의미가 아니라 1을 빼는 연산을 수행 했으니 연산횟수를 1 증가한다라는 의미이다.)
        // < 3의 배수인경우 >
        // 3 / 3 = 1 -> 연산 1번
        // code : dpTable[3] = dpTable[3 / 3] + 1;
    private static void solution() {
        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i-1] + 1;
            if (i % 5 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 5] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
    }
}
