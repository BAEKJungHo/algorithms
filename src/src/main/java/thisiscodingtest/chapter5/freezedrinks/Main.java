package thisiscodingtest.chapter5.freezedrinks;

import java.util.Scanner;

// 음료수 얼려먹기 : DFS(재귀 -> 즉, 종료 조건이 있어야 함)
public class Main {

    private static int n, m;
    private static final int VISITED = Integer.MAX_VALUE;
    private static int[][] graph = new int[1000][1000]; // 문제에서 n, m 의 입력조건 MAX 가 1000

    public static boolean solution(int x, int y) {
        // 종료조건 : 범위를 벗어나는 경우
        if (x <= -1 || x >=n || y <= -1 || y >= m) {
            return false;
        }

        // 재귀
        // 값이 1(칸막이로 막혀있거나) 방문한 경우에는 제외
        if(isNotVisited(graph[x][y])) {
            // 방문 처리
            graph[x][y] = VISITED;

            // 상, 하, 좌, 우의 위치들도 모두 재귀로 호출
            solution(x - 1, y);
            solution(x, y - 1);
            solution(x + 1, y);
            solution(x, y + 1);

            return true;
        }

        return false;
    }

    private static boolean isNotVisited(int node) {
        return node == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<n; i++) {
            String str = sc.nextLine();
            for(int k=0; k<m; k++) {
                graph[i][k] = str.charAt(k) - '0'; // 0 아스키 코드 값 48 빼서 int 로 저장
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int k=0; k<m; k++) {
                if(solution(i, k)) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
