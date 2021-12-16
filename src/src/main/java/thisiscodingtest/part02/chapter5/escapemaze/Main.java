package thisiscodingtest.part02.chapter5.escapemaze;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
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

// BFS
public class Main {

    private static int n;
    private static int m;
    private static int[][] graph = new int[201][201];

    // 이동 방향 : 상, 하, 좌, 우
    private static int dx[] = {-1, 1, 0, 0};
    private static int dy[] = {0, 0, -1, 1};

    // 방문 시작
    public static int solution() {
        Queue<Node> Q = new LinkedList<>(); // 큐를 만든다.
        Q.offer(new Node(0, 0)); // 탐색 시작 노드를 큐에 삽입하고 방문 처리한다.

        while(!Q.isEmpty()) { // 큐가 빌 때까지 반복한다.
            Node node = Q.poll(); // 큐에서 노드를 꺼내서 인접 노드 중 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리를 한다.
            int x = node.getX();
            int y = node.getY();

            // 상하좌우 검색 -> 인접한 노드를 찾는 과정
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if(graph[nx][ny] == 0) {
                    continue;
                }

                // graph[nx][ny] 는 탐색 대상인 graph[x][y] 의 인접한 노드(adjacent node) 라고 할 수 있음
                // 인접한 노드(adjacent node) 의 최단 경로는 탐색 시작 노드 + 1 이라고 할 수 있음.
                if(graph[nx][ny] == 1) { // 1 이라는 것은 아직 방문을 안한 경우 (첫 방문)
                    graph[nx][ny] = graph[x][y] + 1; // 인접한 노드를 방문 처리
                    Q.offer(new Node(nx, ny)); // 방문하지 않은 인접한 노드를 큐에 넣는다.
                }
            }
        }
        return graph[n-1][m-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<n; i++) {
            String str = sc.nextLine();
            for(int k=0; k<m; k++) {
                graph[i][k] = str.charAt(k) - '0';
            }
        }
        System.out.println(solution());
    }

}
