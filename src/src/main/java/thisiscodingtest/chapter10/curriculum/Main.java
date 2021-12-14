package thisiscodingtest.chapter10.curriculum;

import java.util.*;

public class Main {

    private static int vertexCount; // 노드의 개수 : 듣고자 하는 강의의 수
    private static int[] indegree; // 모든 노드에 대한 진입 차수
    private static List<List<Integer>> graph = new ArrayList<>(); // 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트 초기화
    public static int[] times; // 각 강의 시간들
    public static int[] result; // // 알고리즘 수행 결과 리스트

    public static void main(String[] args) {
        input();
        topologySort();
        output();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        vertexCount = sc.nextInt();

        times = new int[vertexCount + 1];
        result = new int[vertexCount + 1];
        indegree = new int[vertexCount + 1];

        // 그래프 초기화
        for (int i = 0; i <= vertexCount; i++) {
            graph.add(new ArrayList<>());
        }

        // 방향 그래프의 모든 간선 정보를 입력 받기
        for (int currentNode = 1; currentNode <= vertexCount; currentNode++) { // currentNode : 현재 노드
            int time = sc.nextInt(); // 첫 번째 입력 값이 시간
            times[currentNode] = time;

            while (true) {
                int parentNode = sc.nextInt(); // 부모 노드 : 선수 과목
                if (parentNode == -1) {
                    break;
                }
                graph.get(parentNode).add(currentNode);
                indegree[currentNode] += 1; // 진입 차수 1증가
            }
        }
    }

    private static void topologySort() {
        Queue<Integer> Q = new LinkedList<>();

        // 결과 배열을 시간배열에 담긴 값으로 초기화 : 구하고자 하는 결과가 N 개의 강의에 대하여 수강하기까지 걸리는 최소시간
        // 따라서, result 배열에 자기 자신의 수강 시간 값으로 초기화
        for (int i = 1; i <= vertexCount; i++) {
            result[i] = times[i]; // 자기 자신의 수강 시간 값으로 초기화
        }

        // step 0. 진입차수가 0인 노드를 큐에 삽입
        for (int i = 1; i <= vertexCount; i++) {
            if (indegree[i] == 0) {
                Q.offer(i);
            }
        }

        // step N. 큐가 빌 때까지 반복
        while(!Q.isEmpty()) {
            // 큐에서 원소 꺼내기
            int parentNode = Q.poll();

            /**
            * graph.get(parentNode).get(i) = parentNode 에 연결된 currentNodes
            * result[currentNode] = Math.max(result[currentNode], result[parentNode] + times[currentNode]
            * 해당 원소와 연결된 노드들의 진입차수에서 1 빼기
            */
            for (int i = 0; i < graph.get(parentNode).size(); i++) {
                int currentNode = graph.get(parentNode).get(i);
                result[currentNode] = Math.max(result[currentNode], result[parentNode] + times[currentNode]);
                indegree[graph.get(parentNode).get(i)] -= 1;
                // 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
                if (indegree[graph.get(parentNode).get(i)] == 0) {
                    Q.offer(graph.get(parentNode).get(i));
                }
            }
        }
    }

    private static void output() {
        // 위상 정렬을 수행한 결과 출력
        for (int i = 1; i <= vertexCount; i++) {
            System.out.println(result[i]);
        }
    }
}
