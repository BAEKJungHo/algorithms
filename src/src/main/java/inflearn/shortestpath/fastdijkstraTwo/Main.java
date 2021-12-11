package inflearn.shortestpath.fastdijkstraTwo;

import java.util.*;

class Node implements Comparable<Node> {
    
    public int vertex; 
    public int cost; 
    
    Node(int vertex, int cost) {
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
    public int compareTo(Node o){
        return this.cost-o.cost;
    }
}

class Main {

    private static int n;
    private static int m;
    private static List<List<Node>> graph;
    private static int[] shortestPaths;

    public static void main(String[] args){
        input();
        dijkstra(1);
        output();
    }
    
    private static void input() {
        inflearn.shortestpath.fastdijkstra.Main T = new inflearn.shortestpath.fastdijkstra.Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        shortestPaths = new int[n + 1];
        Arrays.fill(shortestPaths, Integer.MAX_VALUE);

        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            int c=kb.nextInt();
            // a 에서 b 로 가는데 c 의 비용이 든다.
            graph.get(a).add(new Node(b, c));
        }
    }

    private static void dijkstra(int vertex){
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(vertex, 0));
        shortestPaths[vertex] = 0; // 자기 자신에 대한 최단거리는 0

        while(!pQ.isEmpty()){
            Node tmp = pQ.poll();
            int now = tmp.vertex;
            int nowCost = tmp.cost;
            if (nowCost > shortestPaths[now]) {
                continue;
            }
            for (Node node : graph.get(now)) {
                if (shortestPaths[node.getVertex()] > nowCost + node.getCost()) {
                    shortestPaths[node.getVertex()] = nowCost + node.getCost();
                    pQ.offer(new Node(node.getVertex(), nowCost + node.getCost()));
                }
            }
        }
    }

    private static void output() {
        for (int i = 2; i <= n; i++) {
            if (shortestPaths[i] != Integer.MAX_VALUE) System.out.println(i + " : " + shortestPaths[i]);
            else System.out.println(i + " : impossible");
        }
    }
}