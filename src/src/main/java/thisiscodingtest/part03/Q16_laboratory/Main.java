package thisiscodingtest.part03.Q16_laboratory;

import java.util.*;

/*
연구소는 N X M 크기의 직사각형
직사각형은 1 x 1 크기를 갖는 정사각형들의 집합
연구소는 빈칸과 벽으로 이루어져 있음
일부 칸에는 바이러스 존재
바이러스는 상하좌우로 인접한 빈칸으로 퍼져나감
0 : 빈칸
1 : 벽
2 : 바이러스

바이러스 퍼지는 것을 막기 위해 새로운 벽을 3개 세워야 함
벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전영역
안전 영역 크기의 최댓값을 구하시오

# 아이디어
일단.. 안전 영역의 최댓값은 빈칸의 최댓값이니까
빈칸 좌표들을 List 에 담고
빈칸들 중에서 3개를 뽑는 조합을 생각하면되나 ?
치킨 배달 문제랑 비슷한거 같기도..
 */
// 연구소
public class Main {

    static class SafetyZone {
        private int x;
        private int y;

        public SafetyZone(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Virus {
        private int x;
        private int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int M;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static final int EMPTY = 0;
    static final int WALL = 1;
    static final int VIRUS = 2;
    static boolean[] visited;
    static List<SafetyZone> safetyZones = new ArrayList<>();
    static List<Virus> viruses = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        input();
        useCombination(0, 3);
        System.out.println(answer);
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                graph[i][k] = sc.nextInt();
                if(graph[i][k] == EMPTY) {
                    safetyZones.add(new SafetyZone(i, k));
                }
                if(graph[i][k] == VIRUS) {
                    viruses.add(new Virus(i, k));
                }
            }
        }
        visited = new boolean[safetyZones.size()];
    }

    // 조합 사용
    static void useCombination(int currentIndex, int r) {
        if(r == 0) {
            constructWallsAndSpreadTheVirus();
            return;
        }
        if(currentIndex == safetyZones.size()) {
            return;
        } else {
            visited[currentIndex] = true;
            useCombination(currentIndex + 1, r - 1);

            visited[currentIndex] = false;
            useCombination(currentIndex + 1, r);
        }
    }

    // 벽세우고 바이러스 퍼트리기
    static void constructWallsAndSpreadTheVirus() {
        int[][] clonedGraph = new int[N][M];

        // 배열 깊은 복사
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                clonedGraph[i][k] = graph[i][k];
            }
        }

        // 벽을 먼저 세우기
        for (int i = 0; i < safetyZones.size(); i++) {
            if(visited[i]) {
                SafetyZone safetyZone = safetyZones.get(i);
                clonedGraph[safetyZone.x][safetyZone.y] = WALL;
            }
        }

        // 벽세우고 나서 바이러스 퍼트리기 : 바이러스 퍼트리는 것을 BFS 로 구현
        // 바이러스 퍼지기 전, 초기에 존재하던 바이러스 사이즈 만큼 반복
        for (int i = 0; i < viruses.size(); i++) {
            Queue<Virus> virusQ = new LinkedList<>();
            virusQ.add(viruses.get(i));
            while(!virusQ.isEmpty()) {
                Virus virus = virusQ.poll();
                // 상하좌우 탐색
                for (int k = 0; k < dx.length; k++) {
                    int nx = virus.x + dx[k];
                    int ny = virus.y + dy[k];

                    if(isInGraph(nx, ny)) {
                        if(clonedGraph[nx][ny] == EMPTY) {
                            clonedGraph[nx][ny] = VIRUS;
                            virusQ.add(new Virus(nx, ny));
                        }
                    }
                }
            }
        }

        countSafetyZone(clonedGraph);
    }

    // 그래프 안에 존재하면
    static boolean isInGraph(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M;
    }

    // 안전 지대의 개수 계산
    static void countSafetyZone(int[][] clonedGraph) {
        int result = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if(clonedGraph[x][y] == EMPTY) {
                    result++;
                }
            }
        }
        answer = Math.max(answer, result);
    }
}
