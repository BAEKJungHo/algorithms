package thisiscodingtest.part03.Q31_goldmine;


/**
 * https://freedeveloper.tistory.com/276 여기 해석 참고 하여 구현
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 금광
public class Main2 {

    static int T;
    static List<int[][]> testcases = new ArrayList<>();
    static int[][] dp;

    public static void main(String[] args) {
        input();
        solution();
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] graph = new int[n][m];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    graph[x][y] = sc.nextInt();
                }
            }
            testcases.add(graph);
        }
    }

    static void solution() {
        for (int i = 0; i < testcases.size(); i++) {
            int[][] graph = testcases.get(i);

            int n = graph.length;
            int m = graph[0].length;
            dp = new int[n][m];

            // DP 테이블 초기화
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    dp[x][y] = graph[x][y];
                }
            }

            for (int y = 1; y < m; y++) {
                for (int x = 0; x < n; x++) {
                    int leftUp, leftDown, left;

                    // 왼쪽 위에서 오는 경우, x == 0 일때는 왼쪽 위에서 올 수가 없으니까 0으로 초기화
                    if(x == 0) {
                        leftUp = 0;
                    } else {
                        leftUp = dp[x - 1][y - 1];
                    }

                    // 왼쪽 아래에서 오는 경우, x 가 n - 1 일때는 왼쪽 아래에서 올 수가 없으니까 0으로 초기화
                    if(x == n - 1) {
                        leftDown = 0;
                    } else {
                        leftDown = dp[x + 1][y -1];
                    }

                    // 왼쪽에서 오는 경우
                    left = dp[x][y - 1];

                    // 점화식
                    dp[x][y] = dp[x][y] + Math.max(leftUp, Math.max(leftDown, left));
                }
            }

            int result = 0;
            for (int p = 0; p < n; p++) {
                // 마지막 열에 각 케이스에 대한 최댓값이 존재함
                result = Math.max(result, dp[p][m - 1]);
            }
            System.out.println(result);
        }
    }
}
