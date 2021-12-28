package thisiscodingtest.part03.Q37_floyd;

import java.util.Arrays;
import java.util.Scanner;

// 플로이드 : D(ab) = min(D(ab), D(ak) + D(kb))
public class Main {

    private static final int INF = (int) 1e9;
    private static int n;
    private static int m;
    private static int[][] graph;

    public static void main(String[] args) {
        input();
        floydwarshall();
        output();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        // 최단 거리 테이블을 모두 무한으로 초기화
        graph = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
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

        // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        for (int i = 0; i < m; i++) {
            // A에서 B로 가는 비용은 C라고 설정
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            // 입력 조건에서 (3,4,1), (3,4,2) 이렇게 입력할 수 있음
            graph[a][b] = Math.min(graph[a][b], c);
        }
    }

    private static void floydwarshall() {
        // 점화식에 따라 플로이드 워셜 알고리즘을 수행
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
    }

    private static void output() {
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (graph[a][b] == INF) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }
    }
}
