package inflearn.graph.unionfind;

import java.util.Scanner;

public class Main {

    private static int n; // 정점의 개수
    private static int m; // 간선, 숫자 쌍의 개수
    private static int[] parents; // 부모 테이블

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        initParents();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b);
        }

        int x = sc.nextInt();
        int y = sc.nextInt();

        output(x, y);
    }

    private static void initParents() {
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
    }

    private static void union(int a, int b) {
        int firstParentVertex = findParent(a);
        int secondParentVertex = findParent(b);
        if(firstParentVertex < secondParentVertex) {
            parents[secondParentVertex] = firstParentVertex;
        } else {
            parents[firstParentVertex] = secondParentVertex;
        }
    }

    private static int findParent(int vertex) {
        if (vertex == parents[vertex]) {
            return vertex;
        }
        return parents[vertex] = findParent(parents[vertex]);
    }

    private static void output(int x, int y) {
        int parentX = findParent(x);
        int parentY = findParent(y);
        if (parentX == parentY) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}
