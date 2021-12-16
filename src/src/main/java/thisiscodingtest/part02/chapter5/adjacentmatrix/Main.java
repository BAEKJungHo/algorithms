package thisiscodingtest.part02.chapter5.adjacentmatrix;

// 인접 행렬 방식
public class Main {

    private static final int INF = Integer.MAX_VALUE;

    private static int[][] graph = {
            {0, 7, 5},
            {7, 0, INF},
            {5, INF, 0}
    };

    public static void main(String[] args) {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

}
