package thisiscodingtest.chapter10.concepts.disjointsets.cycling;

import java.util.Scanner;

public class Main {

    private static int vertexCount; // 정점, 노드의 개수
    private static int edgeCount; // 간선의 개수
    private static int[] parents; // 부모 테이블
    private static final int[][] unionSets = new int[][]{ {1, 2}, {1, 3}, {2, 3} }; // union 연산 대상 집합
    private static boolean cycle = false; // 싸이클 발생 여부

    public static void main(String[] args) {
        input();
        initParents();
        if(isOccurCycling()) {
            System.out.println("Occur Cycling");
        } else {
            System.out.println("Not Occur Cycling");
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        vertexCount = sc.nextInt();
        edgeCount = sc.nextInt();
    }

    // INIT : 부모 테이블 초기화 -> 초기 root 노드들을 자기 자신으로 설정
    private static void initParents() {
        parents = new int[vertexCount + 1];
        for (int i = 1; i <= vertexCount; i++) {
            parents[i] = i;
        }
    }

    // 싸이클이 발생했는지 판단
    private static boolean isOccurCycling() {
        for(int i=0; i<unionSets.length; i++) {
            int firstVertex = unionSets[i][0];
            int secondVertex = unionSets[i][1];

            // 싸이클 발생 시 종료
            if(findParent(firstVertex) == findParent(secondVertex)) {
                cycle = true;
                break;
            } else { // 싸이클이 발생하지 않으면 union 연산 수행
                unionParent(firstVertex, secondVertex);
            }
        }
        return cycle;
    }

    // find 연산
    private static int findParent(int vertex) {
        if (vertex == parents[vertex]) {
            return vertex;
        }
        return parents[vertex] = findParent(parents[vertex]);
    }

    // union 연산
    private static void unionParent(int firstVertex, int secondVertex) {
        int firstParentVertex = findParent(firstVertex);
        int secondParentVertex = findParent(secondVertex);
        if (firstParentVertex < secondParentVertex) {
            parents[secondParentVertex] = firstParentVertex;
        } else {
            parents[firstParentVertex] = secondParentVertex;
        }
    }
}
