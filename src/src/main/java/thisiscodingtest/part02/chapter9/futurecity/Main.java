package thisiscodingtest.part02.chapter9.futurecity;

import java.util.Arrays;
import java.util.Scanner;

// 미래 도시
public class Main {

    private static final int INF = (int) 1e9; // 다익스트라 알고리즘과는 달리 여기서는 Integer.MAX_VALUE 로 초기화하면 안된다.
    private static final int COST = 1;
    private static int n; // 노드의 개수
    private static int m; // 간선의 개수
    private static int x; // 판매처
    private static int k; // 소개팅 장소
    private static int[][] graph = new int[101][101]; // 최단 거리 테이블 : 노드와 간선의 범위는 1 ~ 100 까지
    private static int shortestPath = 0;

    public static void main(String[] args) {
        input();
        floydwarshall();
        output();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        // 최단 거리 테이블 초기화
        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b) {
                    graph[a][b] = 0;
                }
            }
        }

        // 서로 연결되어 있는 회사들 : 전부 양방향으로 이동 가능
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(); // a 회사
            int b = sc.nextInt(); // b 회사
            graph[a][b] = COST; // 가중치 값은 1로 동일
            graph[b][a] = COST; // 가중치 값은 1로 동일
        }

        // 판매처와 소개팅 장소
        x = sc.nextInt();
        k = sc.nextInt();
    }

    private static void floydwarshall() {
        // 점화식에 따라 플로이드 워셜 알고리즘을 수행
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    // graph[a][b] 에 대한 최단 경로 값을 갱신하는 코드
                    // a 에서 b 로 가는 비용 = Min(기존에 저장된 a 에서 b 로 가는 비용 vs a 에서 k 를 거쳐 b 로 가는 비용)
                    // 이 과정을 전부 수행하면 도로로 연결 되어있는 모든 회사에 대한 최단 거리들이 들어있다.
                    // 즉, graph[a][b] 에 1 ~ k 까지의 최단거리, k ~ x 까지의 최단거리도 들어있다.
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
        // 1 - k - x 의 최단거리 : 1 ~ k 까지의 최단거리 + k ~ x 까지의 최단거리
        // 여기서 x 까지의 경로를 도달할 수 없다고 하면 계산된 shortestPath 의 값이 INF 보다 커질 것이다.
        shortestPath = graph[1][k] + graph[k][x];
    }

    private static void output() {
        if(shortestPath >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(shortestPath);
        }
    }

}
