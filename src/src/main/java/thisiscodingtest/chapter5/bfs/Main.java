package thisiscodingtest.chapter5.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 너비 우선 탐색
public class Main {

    private static boolean[] visited = new boolean[9]; // 방문 정보
    private static List<List<Integer>> graph = new ArrayList<>(); // 그래프

    public static void bfs(int start) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(start); // 시작 값을 큐에 넣는다.
        visited[start] = true; // 현재 노드 방문 처리
        while(!Q.isEmpty()) { // 큐가 빌 때 까지 반복
            int x = Q.poll(); // Q 에서 원소를 뽑고
            for(int i=0; i<graph.get(x).size(); i++) { // 해당 원소와 연결되어 있으며 아직 방문하지 않은 원소들을 큐에 삽입
                int y = graph.get(x).get(i);
                if(!visited[y]) {
                    Q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i=0; i<9; i++) {
            graph.add(new ArrayList<>());
        }

        // 노드 0 은 없어서 생략하려고 1부터 시작
        // 노드 1에 연결된 노드 정보 저장
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 노드 2에 연결된 노드 정보 저장
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 노드 3에 연결된 노드 정보 저장
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 노드 6에 연결된 노드 정보 저장
        graph.get(6).add(7);

        // 노드 7에 연결된 노드 정보 저장
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        // 노드 8에 연결된 노드 정보 저장
        graph.get(8).add(1);
        graph.get(8).add(7);

        bfs(1);
    }

}
