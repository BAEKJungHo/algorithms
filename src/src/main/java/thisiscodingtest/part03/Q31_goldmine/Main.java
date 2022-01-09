package thisiscodingtest.part03.Q31_goldmine;

/*
n x m 크기의 금광
1 x 1 크기로 나눠져 있고 각 칸에는 특정한 크기의 금이 있음
채굴자는 첫번째 열부터 출발해서 금 캐기
맨 첫 번째 열의 어느 행에서든 출발 가능
이후에 m 번에 걸쳐 매번 오른쪽위, 오른쪽 오른쪽 아래 3가지 중 하나로 이동
채굴자가 얻을 수 있는 금의 최대 크기
 */
// 금광
import java.util.*;

// 금광 : Fail
public class Main {

    static class GoldMine {
        private int x;
        private int y;
        private int gold;

        public GoldMine(int x, int y, int gold) {
            this.x = x;
            this.y = y;
            this.gold = gold;
        }
    }

    static int T;
    static List<int[][]> testcases = new ArrayList<>();
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};

    public static void main(String[] args) {
        input();
        solution();
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] graph = new int[n][m];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    graph[x][y] = sc.nextInt();
                }
            }
            testcases.add(graph);
        }
    }

    static void solution() {
        for (int i = 0; i < testcases.size(); i++) {
            int[][] graph = testcases.get(i);
            int answer = Integer.MIN_VALUE;
            int rowLength = graph.length;
            int columnLength = graph.length;

            /*
                    (1, 0, #2) -> (0, 1, #3) -> answer = 2 + 3
                    (1, 0, #2) -> (1, 1, #1) -> answer(5) = math.max(5, 2+1)
                    (1, 0, #2) -> (2, 1, #6) -> answer(5) = math.max(5, 2+6)
             */

            Integer[] maxValues = new Integer[rowLength];
            for (int y = 0; y < columnLength - 1; y++) {
                for(int x = 0; x < rowLength; x++) {
                    Queue<GoldMine> goldMines = new LinkedList<>();
                    goldMines.add(new GoldMine(x, 0, graph[x][0]));

                    while (!goldMines.isEmpty()) {
                        GoldMine goldMine = goldMines.poll();

                        for (int k = 0; k < dx.length; k++) {
                            int nx = dx[k] + goldMine.x;
                            int ny = dy[k] + goldMine.y;

                            if (isInGraph(nx, ny, rowLength, columnLength)) {
                                int sumOfGold = goldMine.gold + graph[nx][ny];
                                answer = Math.max(answer, sumOfGold);
                                goldMines.add(new GoldMine(nx, ny, graph[nx][ny]));
                            }
                        }
                    }
                    maxValues[x] = answer;
                }
            }

            Arrays.sort(maxValues, Collections.reverseOrder());
            System.out.println(maxValues[0]);
        }
    }

    static boolean isInGraph(int nx, int ny, int rowLength, int columnLength) {
        return nx >= 0 && ny >= 0 && nx < rowLength && ny < columnLength;
    }
}
