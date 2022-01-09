package thisiscodingtest.part03.Q34_placingsoldiers;

/*
N 명의 병사 무작위로 나열
각 병사는 특정한 값의 전투력을 보유
병사를 배치할때 전투력 순으로 내림차순
배치 과정에서 특정한 위치에 있는 병사를 열외시키는 방법 이용
남아있는 병사의 수가 최대가 되도록 -> LIS

인프런 참고 -> 백준 제출했을때 100퍼센트에서 실패했다고 뜸
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 병사 배치하기
public class Main {

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
