package thisiscodingtest.chapter10.maketeam;

import java.util.Scanner;

public class Main {

    private static int vertexCount; // 입력 값 n
    private static int edgeCount; // 연산의 수 = 간선의 개수 m
    private static int[] parents; // 부모 테이블

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        vertexCount = sc.nextInt();
        edgeCount = sc.nextInt();

        initParents();

        for (int i = 0; i < edgeCount; i++) {
            int operationType = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionAndFind(operationType, a, b);
        }
    }

    // INIT : 부모 테이블 초기화 -> 초기 root 노드들을 자기 자신으로 설정
    private static void initParents() {
        parents = new int[vertexCount + 1];
        for (int i = 1; i <= vertexCount; i++) {
            parents[i] = i;
        }
    }

    /**
     * @param operationType 0 : union, 1 : find
     * @param a firstVertex
     * @param b secondVertex
     */
    private static void unionAndFind(int operationType, int a, int b) {
        if(operationType == 0) {
            union(a, b);
        } else {
            if(findParent(a) == findParent(b)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void union(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);

        if(parentA < parentB) {
            parents[parentB] = parentA;
        } else {
            parents[parentA] = parentB;
        }
    }

    // 경로 압축 기법 적용
    private static int findParent(int vertex) {
        if (vertex == parents[vertex]) return vertex;
        return parents[vertex] = findParent(parents[vertex]);
    }

}
