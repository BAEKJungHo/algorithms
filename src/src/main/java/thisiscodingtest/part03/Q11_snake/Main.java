package thisiscodingtest.part03.Q11_snake;

import java.util.*;

/**
 * 시간 초과 후 Queue 부분 해설 보고 다시 구현
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

    public char getDirection() {
        return direction;
    }
}

class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {

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
        System.out.println(playDummyGame());
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

    private static int playDummyGame() {
        // 초기 뱀 위치 1,1  (0,0 은 외곽임)
        int x = 1;
        int y = 1;
        square[1][1] = SNAKE; // 현재는 뱀의 머리만 있음

        int direction = 0; // 처음 바라보는 방향은 동쪽
        int seconds = 0; // 경과 시간(초)
        int index = 0; // 다음에 회전할 정보

        Queue<Position> Q = new LinkedList<>();
        Q.offer(new Position(x, y));

        while(true) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 사각형 보드안에 존재하며, 뱀이 존재하는 위치가 아닐 경우
            if(isInSquare(nx, ny) && square[nx][ny] != SNAKE) {
                // 사과가 없으면 이동 후에 꼬리 제거
                if (square[nx][ny] != APPLE) {
                    square[nx][ny] = SNAKE;
                    Q.offer(new Position(nx, ny));

                    // 꼬리 제거 코드
                    Position prev = Q.poll();
                    square[prev.getX()][prev.getY()] = EMPTY;
                }
                // 사과가 있다면 이동 후에 꼬리 그대로 두기
                if (square[nx][ny] == APPLE) {
                    square[nx][ny] = SNAKE;
                    Q.offer(new Position(nx, ny));
                }
            } else { // 벽이나 뱀의 몸통과 부딪힌 경우
                seconds++;
                break;
            }

            // 다음 위치로 머리를 이동
            x = nx;
            y = ny;
            seconds++;
            if (index < L && seconds == strategies.get(index).getSeconds()) { // 회전할 시간인 경우 회전
                direction = turn(direction, strategies.get(index).getDirection());
                index += 1;
            }
        }
        return seconds;
    }

    // 사각형 보드안에 존재하는 경우
    private static boolean isInSquare(int x, int y) {
        return 1 <= x && x <= N && 1 <= y && y <= N;
    }

    // 회전
    public static int turn(int direction, char c) {
        if (c == 'L') {
            direction = (direction == 0) ? 3 : direction - 1;
        } else {
            direction = (direction + 1) % 4;
        }
        return direction;
    }

}
