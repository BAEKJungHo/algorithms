package thisiscodingtest.part02.chapter10.concepts.topologysort;

import java.util.*;

public class Main {

    private static int vertexCount; // 노드의 개수
    private static int edgeCount; // 간선의 개수
    private static int[] indegree; // 모든 노드에 대한 진입 차수
    private static List<List<Integer>> graph = new ArrayList<>(); // 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트 초기화
    private static List<Integer> result = new ArrayList<>(); // 알고리즘 수행 결과 리스트

    public static void main(String[] args) {
        input();
        topologySort();
        output();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        vertexCount = sc.nextInt();
        edgeCount = sc.nextInt();

        indegree = new int[vertexCount + 1];

        // 그래프 초기화
        for (int i = 0; i <= vertexCount; i++) {
            graph.add(new ArrayList<>());
        }

        // 방향 그래프의 모든 간선 정보를 입력 받기
        for (int i = 0; i < edgeCount; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b); // A 노드에서 B 로 이동
            indegree[b] += 1; // 진입 차수 1증가
        }
    }

    private static void topologySort() {
        Queue<Integer> Q = new LinkedList<>();

        // step 0. 진입차수가 0인 노드를 큐에 삽입
        for (int i = 1; i <= vertexCount; i++) {
            if (indegree[i] == 0) {
                Q.offer(i);
            }
        }

        // step N. 큐가 빌 때까지 반복
        while(!Q.isEmpty()) {
            // 큐에서 원소 꺼내기
            int now = Q.poll();
            result.add(now);
            // 해당 원소와 연결된 노드들의 진입차수에서 1 빼기
            for (int i = 0; i < graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)] -= 1;
                // 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
                if (indegree[graph.get(now).get(i)] == 0) {
                    Q.offer(graph.get(now).get(i));
                }
            }
        }
    }

    private static void output() {
        // 위상 정렬을 수행한 결과 출력
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
