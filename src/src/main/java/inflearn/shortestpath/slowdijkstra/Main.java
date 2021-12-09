package inflearn.shortestpath.slowdijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 입력
 * 6 11
 * 1
 * 1 2 2
 * 1 3 5
 * 1 4 1
 * 2 3 3
 * 2 4 2
 * 3 2 3
 * 3 6 5
 * 4 3 3
 * 4 5 1
 * 5 3 1
 * 5 6 2
 *
 * 출력
 * 0 // 1번 노드 자기자신에 대한 최단거리
 * 2 // 1->2 최단거리
 * 3 // 1->3 최단거리
 * 1 // 1->4 최단거리
 * 2 // 1->5 최단거리
 * 4 // 1->6 최단거리
 */
// 다익스트라 알고리즘은 가중치 방향그래프(방향과 가중치)가 주어지므로 객체로 만들어서 처리
class Node {

    private int vertex; // 정점
    private int cost; // 비용

    public Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    public int getVertex() {
        return vertex;
    }

    public int getCost() {
        return cost;
    }
}

// 다익스트라 알고리즘 : 느린 버전
public class Main {

    private static final int INF = Integer.MAX_VALUE;
    private static int n; // 노드의 개수
    private static int m; // 간선의 개수
    private static int start; // 시작 노드 번호

    // 이중 List 인 이유는 가장 바깥 리스트는 각 노드에 대한 리스트이고, 내부 리스트는 각 노드에 연결 되어있는 노드들에 대한 정보를 담고 있는 리스트를 의미한다.
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    private static List<List<Node>> graph = new ArrayList<>();

    // 방문한 적이 있는지 체크하는 목적의 배열 만들기
    private static boolean[] visited = new boolean[100001]; // 노드의 개수는 최대 100,000개라고 가정

    // 최단 거리 테이블 만들기
    private static int[] shortestPaths = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(shortestPaths, INF);

        // 다익스트라 알고리즘 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (shortestPaths[i] == INF) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(shortestPaths[i]);
            }
        }
    }

    /**
     * @param start 시작 노드 초기화
     */
    private static void dijkstra(int start) {
        // 자기 자신(start, 시작노드)에 대한 최단거리는 0으로 초기화
        shortestPaths[start] = 0;
        visited[start] = true;

        // start(시작 노드) 에 연결된 노드들에 대해서 반복문을 돌린다.
        // 해당 노드들까지 이동하기 위한 최단거리 비용을 최단거리 테이블에 세팅한다.
        for (int i = 0; i < graph.get(start).size(); i++) {
            shortestPaths[graph.get(start).get(i).getVertex()] = graph.get(start).get(i).getCost();
        }

        // 시작 노드를 제외한 전체 n - 1개의 노드에 대해서 반복문을 돌린다.
        for (int i = 0; i < n - 1; i++) {
            // 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
            int now = getSmallestNode();
            visited[now] = true;

            // 현재 노드와 연결된 다른 노드들 확인
            for(int k=0; k<graph.get(now).size(); k++) {
                int cost = shortestPaths[now] + graph.get(now).get(k).getCost(); // 현재 노드와 연결된 다른 노드 까지의 비용
                if (cost < shortestPaths[graph.get(now).get(k).getVertex()]) { // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                    shortestPaths[graph.get(now).get(k).getVertex()] = cost;
                }
            }
        }
    }

    // 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
    private static int getSmallestNode() {
        int minValue = INF;
        int index = 0; // 가장 최단 거리가 짧은 노드
        for (int i = 1; i <= n; i++) {
            // i 번째 노드로 이동하기 위한 최단거리 값이 INF 보다 작으며, 방문하지 않은 경우
            if (shortestPaths[i] < minValue && !visited[i]) {
                minValue = shortestPaths[i];
                index = i;
            }
        }
        return index;
    }
}
