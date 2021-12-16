package thisiscodingtest.part02.chapter8.moneycomposition;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 효율적인 화폐 구성
 */
public class Main {

    private static int n;
    private static int m;
    private static int[] arr;
    private static int[] dp; // 최소한의 화폐개수를 저장하는 배열

    public static void main(String[] args) {
        input();
        solution();
        output();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    /**
     * 1. 초기값
     * 2. 점화식
     * 3. Hint 문제에서 최솟값이라 했으니 min 사용 -> 점화식 자체에 min 이 들어감
     */
    private static void solution() {
        Arrays.fill(dp, 10001); // (i - k)원을 만드는 방법이 존재하지 않는 경우로 초기화
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {
                // (i - k)원을 만드는 방법이 존재하는 경우
                if (dp[j - arr[i]] != 10001) {
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }
    }

    private static void output() {
        // 계산된 결과 출력
        if (dp[m] == 10001) { // 최종적으로 M 원을 만드는 방법이 없는 경우
            System.out.println(-1);
        } else {
            System.out.println(dp[m]);
        }
    }

}
