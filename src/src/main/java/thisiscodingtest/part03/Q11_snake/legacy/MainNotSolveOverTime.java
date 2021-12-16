package thisiscodingtest.part03.Q11_snake.legacy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 시간 초과
 * - 꼬리, 몸통, 머리 부분이 이해가 잘 안갔음 -> 구현하다가 이 부분 이해하려다 시간 다 까먹음
 * - 답지를 보니 지금까지 구현한 내용은 맞았는데, 핵심인 Queue 를 생각하지 못했음
 *
 * 해설
 * 예를들어 뱀이 (0, 0)에서 시작해서 계속 사과를 먹으며 우측으로 이동해 (0, 3)까지 간 상태라면
 * queue = (앞=꼬리) { (0,0), (0,1), (0,2), (0,3) } (뒤=머리) 가 된다.
 * 사과를 못 먹어서 꼬리부분을 당겨야 되는 상황이라면 queue.front(), queue.pop()을 이용해 처리하면 된다.
 */
class Strategy {

    private int seconds; // 초
    private char direction; // 방향

    public Strategy(int seconds, char direction) {
        this.seconds = seconds;
        this.direction = direction;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getDirection() {
        return direction;
    }
}

public class MainNotSolveOverTime {

    private static int N;
    private static int K;
    private static int L;

    private static int[][] square;
    private static final int EMPTY = 0;
    private static final int APPLE = Integer.MAX_VALUE; // 사과과 존재하는 위치
    private static final int SNAKE = Integer.MIN_VALUE; // 뱀이 존재하는 위치
    private static List<Strategy> strategies = new ArrayList<>(); // 이동 전략

    // 방향 전환 D(right) 기준으로 동(초기방향) -> 남 -> 서 -> 북
    // 방향 전환 L(left) 기준으로 동(초기방향) -> 북 -> 서 -> 남
    private static int dx[] = {0, 1, 0, -1};
    private static int dy[] = {1, 0, -1, 0};

    public static void main(String[] args) {
        input();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);

        // 게임판 생성
        N = sc.nextInt();
        square = new int[N + 1][N + 1]; // 외곽을 표시하기 위해서 N + 1 사이즈로 정사각형 보드 생성

        // 사과 위치 저장
        K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            square[x][y] = APPLE;
        }

        // 이동 전략 저장
        L = sc.nextInt();
        for (int i = 0; i < L; i++) {
            strategies.add(new Strategy(sc.nextInt(), sc.next().charAt(0)));
        }
    }

    private static void playDummyGame() {
        // 초기 뱀 위치 1,1  (0,0 은 외곽임)
        int x = 1;
        int y = 1;
        square[1][1] = SNAKE; // 현재는 뱀의 머리만 있음
    }
}
