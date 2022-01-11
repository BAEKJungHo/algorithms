package thisiscodingtest.part03.Q34_placingsoldiers;

/*
인프런 참고 -> 백준 제출했을때 100퍼센트에서 실패했다고 뜸
이유를 모르겠음..

아래의 방식이 인프런 강의에서 알려준 방식.
아래의 코드에서 Collections.reverse(list); 이 부분만 제거하면 LIS 의 길이를 구하는 코드가 된다.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 병사 배치하기
public class MainFail1 {

    static int N;
    static int[] dp;
    static int answer;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        input();
        solution();
        System.out.println(answer);
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
    }

    static void solution() {
        dp = new int[list.size()];
        dp[0] = 1;
        Collections.reverse(list);
        for (int i = 1; i < list.size(); i++) {
            int max = 0;
            for (int k = i - 1; k >= 0; k--) {
                int prev = list.get(k);
                int next = list.get(i);
                if(next > prev && dp[k] > max) {
                    max = dp[k];
                }
            }
            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }
        answer = N - answer;
    }
}
