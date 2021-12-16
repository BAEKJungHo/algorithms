package thisiscodingtest.part02.chapter10.concepts.kruscal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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

    private static int vertexCount; // 노드, 정점
    private static int edgeCount; // 간선의 개수 = Union 연산의 횟수
    private static int[] parents; // 부모 테이블
    private static List<Edge> edges = new ArrayList<>();
    private static int answer = 0; // 문제에서 구하고자 하는 답 : MST 를 만드는데 드는 비용

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

        System.out.println(answer);
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
        // 간선을 하나씩 확인하며
        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getCost();
            int nodeA = edges.get(i).getNodeA();
            int nodeB = edges.get(i).getNodeB();

            // 사이클이 발생하지 않는 경우에만 집합에 포함(Union 연산 수행)
            // 즉, nodeA 와 nodeB 에 대한 root 값이 달라야 한다는 의미
            if (findParent(nodeA) != findParent(nodeB)) {
                unionParent(nodeA, nodeB);
                answer += cost; // 최종 비용을 구하기 위한 연산
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
    private static void unionParent(int nodeA, int nodeB) {
        nodeA = findParent(nodeA);
        nodeB = findParent(nodeB);
        if (nodeA < nodeB) {
            parents[nodeB] = nodeA;
        } else {
            parents[nodeA] = nodeB;
        }
    }
}
