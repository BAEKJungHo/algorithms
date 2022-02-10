package boj.bfs.Q_1261;

import java.util.PriorityQueue;
import java.util.Scanner;

// 알고스팟
public class Main {

    static int N;
    static int M;
    static int[][] graph;
    static int answer;
    static final int INF = Integer.MAX_VALUE;
    static final int EMPTY = 0;
    static final int WALL = 1;
    static int[] dx =  {-1, 1, 0, 0};
    static int[] dy =  {0, 0, -1, 1};
    static boolean[][] visitied;

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int value;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) {
        input();
        bfs();
        System.out.println(answer);
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        graph = new int[N][M];
        visitied = new boolean[N][M];

        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            String[] numbers = input.split("");
            for (int k = 0; k < numbers.length; k++) {
                graph[i][k] = Integer.parseInt(numbers[k]);
                visitied[i][k] = false;
            }
        }
    }

    static void bfs() {
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.add(new Node(0, 0, graph[0][0]));
        visitied[0][0] = true;

        while(!pQ.isEmpty()) {
            Node node = pQ.poll();
            search(node, pQ);
            if(visitied[N - 1][M - 1]) {
                answer = node.value;
                break;
            }
        }
    }

    static void search(Node node, PriorityQueue<Node> pQ) {
        for (int i = 0; i < dx.length; i++) {
            int nx = node.x + dx[i];
            int ny = node.y + dy[i];

            if(isInGraph(nx, ny) && isNotVisited(nx, ny)) {
                visitied[nx][ny] = true;
                if(graph[nx][ny] == WALL) {
                    pQ.add(new Node(nx, ny, node.value + 1));
                } else {
                    pQ.add(new Node(nx, ny, node.value));
                }
            }
        }
    }

    static boolean isInGraph(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static boolean isNotVisited(int x, int y) {
        return !visitied[x][y];
    }
}
