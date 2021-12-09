package inflearn.shortestpath.floydwarshall;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 입력
 * 4
 * 7
 * 1 2 3
 * 1 4 6
 * 2 1 3
 * 2 3 7
 * 3 1 5
 * 3 4 4
 * 4 3 2
 *
 * 출력
 * 0 4 8 6
 * 3 0 7 9
 * 5 9 0 4
 * 7 11 2 0
 */

// 플로이드 워셜 알고리즘 : 모든 지점에서 다른 모든 지점까지의 최단 경로를 모두 구해야 할 때 사용
// 점화식 : D(ab) = min(D(ab), D(ak) + D(kb))
// D(23) = min(D(23), D(21) + D(13)) : 2번 노드에서 3번 노드로 가는 비용보다 2번 노드에서 1번을 거쳐 3번 노드로가는 비용이 더 작다면, 그것으로 갱신해주겠다라는 의미
public class Main {

    private static final int INF = (int) 1e9; // 다익스트라 알고리즘과는 달리 여기서는 Integer.MAX_VALUE 로 초기화하면 안된다.
    private static int n; // 노드의 개수
    private static int m; // 간선의 개수
    private static int[][] graph = new int[501][501]; // 최단 경로 그래프, 노드의 개수는 최대 500이라 가정

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
        for (int i = 0; i < 501; i++) {
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
            graph[a][b] = c;
        }
    }

    private static void floydwarshall() {
        // 점화식에 따라 플로이드 워셜 알고리즘을 수행
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    // graph[a][b] 에 대한 최단 경로 값을 갱신하는 코드
                    // a 에서 b 로 가는 비용 = Min(기존에 저장된 a 에서 b 로 가는 비용 vs a 에서 k 를 거쳐 b 로 가는 비용)
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
    }

    private static void output() {
        // 수행된 결과를 출력
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
                if (graph[a][b] == INF) {
                    System.out.print("INFINITY ");
                }
                // 도달할 수 있는 경우 거리를 출력
                else {
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }
    }

}
