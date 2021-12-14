package thisiscodingtest.chapter10.citydivisionplan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 마을은 N 개의 집과, M 개의 길이 존재 (N : 노드, M : 간선)
 * 마을을 2개로 쪼개려고하고, 길의 유지 비용이 최소가 되게끔 하려함
 * Kruskal 을 사용해야겠다라고 생각이 드는 핵심적인 부분
 * - 임의의 두 집 사이의 경로가 항상 존재하는데 -> 즉, 사이클이 발생하지 않아야 한다. -> 신장 트리(spanning tree) 인걸 눈치 채야 함
 * - 길의 유지 비용을 최소화 하고 싶다. -> 최소 신장 트리인 것을 눈치 채야 함
 *
 * 그러면 MST 알고리즘을 사용하기 위한 기법으로 크루스칼을 배웠으니 적용하면 된다.
 * 하지만 마을을 2개로 쪼개려고 한다 했으니까 크루스칼을 사용하여 하나의 MST 를 뽑아내고
 * 거기서 가장 비용이 큰 간선을 제거하면 2개의 MST 가 생성 된다.
 */

// Edge : 간선에 연결되어 있는 노드들과 비용을 저장하기 위한 클래스
class Edge implements Comparable<Edge> {

    private int cost;
    private int nodeA;
    private int nodeB;

    public Edge(int cost, int nodeA, int nodeB) {
        this.cost = cost;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getCost() {
        return cost;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {

    private static int vertexCount; // N : 노드, 정점
    private static int edgeCount; // M : 간선 = Union 연산의 횟수
    private static int[] parents; // 부모 테이블
    private static List<Edge> edges = new ArrayList<>();
    private static int answer = 0;
    private static int maxCost = 0; // MST 에 존재하는 간선 중 최고 비용

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        vertexCount = sc.nextInt();
        edgeCount = sc.nextInt();

        initParents();

        for (int i = 0; i < edgeCount; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(cost, a, b));
        }

        // 간선을 비용순으로 정렬
        Collections.sort(edges);

        // Kruskal Algorithm 수행
        kruskal();

        System.out.println(answer - maxCost);
    }

    // 부모 테이블을 자기 자신의 노드로 초기화
    private static void initParents() {
        parents = new int[vertexCount + 1];
        for (int i = 1; i <= vertexCount; i++) {
            parents[i] = i;
        }
    }

    // Kruskal Algorithm
    private static void kruskal() {
        // 최소 비용을 갖는 간선을 하나씩 확인하며
        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getCost();
            int nodeA = edges.get(i).getNodeA();
            int nodeB = edges.get(i).getNodeB();

            // 사이클이 발생하지 않는 경우에만 집합에 포함(Union 연산 수행)
            // 즉, nodeA 와 nodeB 에 대한 root 값이 달라야 한다는 의미
            if (findParent(nodeA) != findParent(nodeB)) {
                union(nodeA, nodeB);
                answer += cost;
                maxCost = cost;
            }
        }
    }

    // find 연산
    // 특정 원소가 속한 집합을 찾기 : 경로 압축(Path Compression)
    private static int findParent(int vertex) {
        if (vertex == parents[vertex]) return vertex;
        return parents[vertex] = findParent(parents[vertex]);
    }

    // union 연산
    private static void union(int nodeA, int nodeB) {
        nodeA = findParent(nodeA);
        nodeB = findParent(nodeB);
        if (nodeA < nodeB) {
            parents[nodeB] = nodeA;
        } else {
            parents[nodeA] = nodeB;
        }
    }

}
