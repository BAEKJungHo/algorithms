package inflearn.dfsbfs.subset;


import java.util.Scanner;

/**
 * 부분 집합 구하기
 * 자연수 N 이 주어지면 1 ~ N 까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.
 * 단, 공집합은 출력하지 않습니다.
 *
 * 원소가 N 개인 부분집합의 개수는 2^N (공집합 포함)
 *
 * 입력 : 3
 * 출력
 * 1 2 3
 * 1 2
 * 1 3
 * 1
 * 2 3
 * 2
 * 3
 */
public class Main {

    private static int N;
    private static boolean[] checked; // checked 배열 : 해당 숫자를 부분집합으로 사용하는지 안하는지 판단하기 위함

    public static void main(String[] args) {
        input();
        dfs(1);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        checked = new boolean[N + 1];
    }

    /**
     * @param L 각 뎁스에 해당하는 숫자를 의미 N 이 3이면 L 은 1 ~ 4 까지의 DEPTH 를 가진다.
     */
    private static void dfs(int L) {
        if(L == N + 1) { // 종료 조건
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                if(checked[i]) {
                    stringBuilder.append(i).append(" ");
                }
            }
            if(stringBuilder.length() > 0) { // 공집합 출력 X
                System.out.println(stringBuilder);
            }
            // check 배열에 있는 true 로 체크되어있는 원소를 출력
        } else {
            checked[L] = true; // L 이라는 원소를 사용한다라는 의미
            dfs(L + 1); // 왼쪽으로 뻗는 그래프

            checked[L] = false; // L 이라는 원소를 사용하지 않는다라는 의미
            dfs(L + 1); // 오른쪽으로 뻗는 그래프
        }
    }
}
