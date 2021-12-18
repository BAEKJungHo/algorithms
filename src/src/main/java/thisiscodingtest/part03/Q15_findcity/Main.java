package jungho.thisiscodingtest.part03.Q15_findcity;

import java.util.*;

class Node implements Comparable<Node> {

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

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost; // 비용이 낮을 수록 높은 우선순위를 갖도록한다. : 오름차순
    }
}

// 개선된 다익스트라 알고리즘 : PriorityQueue 사용
// PriorityQueue 는 우선순위에 따라 큐에서 뽑아낸다. (우선순위가 가장 높은 데이터를 가장 먼저 삭제한다.)
// 우선순위가 높다는 기준이 필요하기 때문에 Node 객체에 Comparable 을 구현한다.
public class Main {

    private static int INF = Integer.MAX_VALUE;
    private static int n; // 노드의 개수
    private static int m; // 간선의 개수
    private static int k; // 최단거리 정보
    private static int start; // 시작 노드 번호

    // 이중 List 인 이유는 가장 바깥 리스트는 각 노드에 대한 리스트이고, 내부 리스트는 각 노드에 연결 되어있는 노드들에 대한 정보를 담고 있는 리스트를 의미한다.
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    private static List<List<Node>> graph = new ArrayList<>();

    // 최단 거리 테이블 만들기
    private static int[] shortestPaths;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        start = sc.nextInt();

        // 최단거리테이블 초기화
        shortestPaths = new int[n + 1];

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미 : 비용은 1로 고정
            graph.get(a).add(new Node(b, 1));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(shortestPaths, INF);

        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 최단 거리 k 를 갖는 노드 출력
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(shortestPaths[i] == k){
                System.out.println(i);
                count++;
            }
        }

        if(count == 0) {
            System.out.println(-1);
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(start, 0)); // 자기 자신에 대한 비용은 0
        shortestPaths[start] = 0;

        while(!pQ.isEmpty()) { // 큐가 비어있지 않으면
            Node node = pQ.poll(); // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            int nowCost = node.getCost(); // 현재 노드까지 이동하기위한 비용
            int now = node.getVertex(); // 현재 노드(정점)
            if(shortestPaths[now] < nowCost) { // 현재 노드에 대한 최단거리 비용이 더 작은경우 : 즉, 처리된 적이 있는 경우
                continue;
            }
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = shortestPaths[now] + graph.get(now).get(i).getCost();
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < shortestPaths[graph.get(now).get(i).getVertex()]) {
                    shortestPaths[graph.get(now).get(i).getVertex()] = cost;
                    pQ.offer(new Node(graph.get(now).get(i).getVertex(), cost));
                }
            }
        }
    }
}