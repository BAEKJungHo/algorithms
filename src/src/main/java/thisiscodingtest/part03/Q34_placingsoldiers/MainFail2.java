package thisiscodingtest.part03.Q34_placingsoldiers;

/*
N 명의 병사 무작위로 나열
각 병사는 특정한 값의 전투력을 보유
병사를 배치할때 전투력 순으로 내림차순
배치 과정에서 특정한 위치에 있는 병사를 열외시키는 방법 이용
남아있는 병사의 수가 최대가 되도록 -> LIS

답지 참고 -> 이것도 100 퍼센트에서 틀렸다고 나옴
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 병사 배치하기
public class MainFail2 {

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
        Collections.reverse(list);

        // dp 초기화
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < list.size(); i++) {
            int max = 0;
            for (int k = 0; k < i; k++) {
                int prev = list.get(k);
                int next = list.get(i);
                if(next > prev) {
                    dp[i] = Math.max(dp[i], dp[k] + 1);
                    if(dp[i] > max) {
                        max = dp[i];
                    }
                }
            }
            answer = Math.max(answer, max);
        }
        answer = N - answer;
    }
}
