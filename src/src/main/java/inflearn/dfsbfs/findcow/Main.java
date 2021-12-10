package inflearn.dfsbfs.findcow;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 송아지 찾기
public class Main {

    private static int s; // 현수의 위치
    private static int e; // 송아지 위치
    private static int[] strategy = new int[] {-1, 1, 5};
    private static boolean[] visited = new boolean[10001];
    private static int level; // 점프의 최소 횟수

    public static void main(String[] args) {
        input();
        bfs();
        System.out.println(level);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();
        e = sc.nextInt();
    }

    private static void bfs() {
        Queue<Integer> Q = new LinkedList();
        Q.offer(s); // 시작위치 큐에 삽입
        visited[s] = true; // 현수의 좌표 방문처리

        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                int x = Q.poll();
                for (int k = 0; k < strategy.length; k++) {
                    int nx = x + strategy[k];
                    if(nx == e) { // 이동한 곳이 송아지 위치인 경우
                        level++;
                        return;
                    }
                    if(nx >= 1 && nx <= 10000 && !visited[nx]) { // 좌표가 범위 내에 존재하며, 방문하지 않은 경우
                        visited[nx] = true;
                        Q.offer(nx);
                    }
                }
            }
            level++;
        }
    }

}
