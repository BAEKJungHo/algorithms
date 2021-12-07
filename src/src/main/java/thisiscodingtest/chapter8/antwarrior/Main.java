package thisiscodingtest.chapter8.antwarrior;

import java.util.Scanner;

/**
 * # 개미 전사
 * 서로 인접한 노드를 공격하면 메뚜기한테 들킴
 * 서로 인접하지 않은 노드를 선택적으로 약탈하여 최대의 식량을 확보해야 함
 */
public class Main {

    private static int n; // 식량 창고의 개수
    private static int[] storage; // 식량 창고
    private static int[] dp; // 선택적으로 약탈하여 얻은 식량의 최댓값을 저장하고있는 배열

    public static void main(String[] args) {
        input();
        solution();
        System.out.println(dp[n - 1]);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        storage = new int[n];
        dp =  new int[n];
        for (int i = 0; i < n; i++) {
            storage[i] = sc.nextInt();
        }
    }


    /**
     * 점화식 : DP[i] = max(DP[i-1], DP[i-2] + arr[i])
     * 위 점화식을 보면 i 는 2부터 반복문을 시작해야함. 따라서 0과 1에 대한 초기값이 필요할 수 있음
     */
    private static void solution() {
        // 초기값 지정
        dp[0] = storage[0];
        dp[1] = Math.max(storage[0], storage[1]); // 0 번째와 1번째 식량창고를 털어서 MAX 값 저장
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + storage[i]);
        }
    }

}
