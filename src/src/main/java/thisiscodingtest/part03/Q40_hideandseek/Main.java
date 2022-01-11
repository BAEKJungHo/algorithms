package thisiscodingtest.part03.Q40_hideandseek;

/*
1 ~ N 번까지의 헛간 중 하나를 골라 숨을 수 있다.
술래는 항상 1번에서 출발
전체 맵에는 M 개의 양방향 통로가 존재
전체 맵은 항상 어떤 헛간에서 다른 헛간으로 도달이 가능한 형태로 주어진다.
각 노드간의 거리는 동일
 */
import java.util.*;

// 숨바꼭질
public class Main {

    static class Node implements Comparable<Node> {

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

    private static int INF = 10000000;
    private static int N; // 노드의 개수
    private static int M; // 간선의 개수
    private static List<List<Node>> graph = new ArrayList<>();
    private static int[] shortestPaths;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        // 최단거리테이블 초기화
        shortestPaths = new int[N + 1];

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미 : 비용은 1로 고정
            graph.get(a).add(new Node(b, 1));
            // 통로는 양방향이므로 반대로도 연결
            graph.get(b).add(new Node(a, 1));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(shortestPaths, INF);

        // 다익스트라 알고리즘을 수행
        dijkstra(1);

        // 숨어야 하는 헛간 까지의 거리 = 최단거리배열에 존재하는 최댓값
        int maxShortestPath = 0;
        for (int i = 1; i <= N; i++) {
            if(shortestPaths[i] > maxShortestPath && shortestPaths[i] != INF){
                maxShortestPath = shortestPaths[i];
            }
        }

        // 숨어야 하는 헛간 번호
        int node = 0;
        for (int i = 1; i < N; i++) {
            if(shortestPaths[i] == maxShortestPath) {
                node = i;
                break;
            }
        }

        // 숨어야 하는 헛간과 같은 거리를 갖는 헛간의 개수
        int count = 1;
        for (int i = 1; i < N; i++) {
            if(shortestPaths[i] == maxShortestPath) {
                count++;
            }
        }

        System.out.println(node + " " + maxShortestPath + " " + count);
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
                int nextCost = graph.get(now).get(i).getCost();
                int nextVertex = graph.get(now).get(i).getVertex();
                int cost = shortestPaths[now] + nextCost; // 현재 노드로 이동하기 위한 최단거리 비용 + linkedVertex 의 비용

                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < shortestPaths[nextVertex]) {
                    shortestPaths[nextVertex] = cost;
                    pQ.offer(new Node(nextVertex, cost));
                }
            }
        }
    }
}
