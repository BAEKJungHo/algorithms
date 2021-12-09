package thisiscodingtest.chapter9.telegram;

import java.util.*;

class City implements Comparable<City> {
    
    private int vertex; // 정점
    private int cost; // 비용 : 걸리는시간

    public City(int vertex, int cost) {
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
    public int compareTo(City o) {
        return this.cost - o.cost;
    }
}

// 전보
public class Main {

    private static int INF = Integer.MAX_VALUE;
    private static int n; // 도시의 개수
    private static int m; // 통로의 개수
    private static int c; // 메시지를 보내고자하는 도시. 즉, 시작점을 의미
    private static List<List<City>> graph = new ArrayList<>(); // 각 도시에 연결되어 있는 도시에 대한 정보를 담는 배열
    private static int[] shortestPaths; // 최단 거리 테이블 만들기
    
    public static void main(String[] args) {
        input();
        dijkstra(c);
        output();
    }
    
    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();
        shortestPaths = new int[n + 1];

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // x 도시에서 y 도시로 이어지는 통로가 있으며 z 시간이 걸린다.
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            graph.get(x).add(new City(y, z));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(shortestPaths, INF);
    }

    private static void dijkstra(int start) {
        PriorityQueue<City> pQ = new PriorityQueue<>();
        pQ.offer(new City(start, 0)); // 자기 자신에 대한 비용은 0
        shortestPaths[start] = 0;

        while(!pQ.isEmpty()) { // 큐가 비어있지 않으면
            City City = pQ.poll(); // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            int nowCost = City.getCost(); // 현재 노드까지 이동하기위한 비용
            int now = City.getVertex(); // 현재 노드(정점)
            if(shortestPaths[now] < nowCost) { // 현재 노드에 대한 최단거리 비용이 더 작은경우 : 즉, 처리된 적이 있는 경우
                continue;
            }
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = shortestPaths[now] + graph.get(now).get(i).getCost();
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < shortestPaths[graph.get(now).get(i).getVertex()]) {
                    shortestPaths[graph.get(now).get(i).getVertex()] = cost;
                    pQ.offer(new City(graph.get(now).get(i).getVertex(), cost));
                }
            }
        }
    }

    private static void output() {
        // 모든 노드로 가기 위한 최단 거리를 출력
        int totalCity = 0; // 메시지를 받는 도시의 총 개수
        int totalCost = 0; // 총 시간 : c 도시로부터 가장 멀리 떨어져있으면서 메시지를 받은 도시와의 최단 거리
        for (int i = 1; i <= n; i++) {
            if(shortestPaths[i] != INF) {
                totalCity++;
                totalCost = Math.max(totalCost, shortestPaths[i]);
            }
        }
        System.out.println(totalCity - 1  + " " + totalCost);
    }

}
