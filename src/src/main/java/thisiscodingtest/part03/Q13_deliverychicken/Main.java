package thisiscodingtest.part03.Q13_deliverychicken;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
N X N 크기의 도시 존재
도시는 1 X 1 크기
도시의 각 칸은 좌표 형태(r,c) 이며 '빈칸' OR '치킨집'
r 과 c 는 1부터 시작
치킨 거리 : 집과 가장 가까운 치킨집 사이의 거리
도시의 치킨 거리는 모든 집의 치킨 거리의 합

(r1, c1) 과 (r2, c2) 사이의 거리는 (r1 - r2) + (c1 - c2)
0은 빈칸
1은 집
2는 치킨집

치킨 집 중 M 개만 살아남고 나머지는 폐업
M 개를 선택했을 때 수익이 최대가 되어야 함
치킨 집의 수는 M <= 치킨집 <= 13
M = 폐업 시키지 않을 치킨집의 수

치킨 거리의 최솟값 출력

Example1.
(1, 1, #0) (1, 2, #0) (1, 3, #HOUSE) (1, 4, #0) (1, 5, #0)
(2, 1, #0) (2, 2, #0) (2, 3, #CHICKEN) (2, 4, #0) (2, 5, #HOUSE)
(3, 1, #0) (3, 2, #HOUSE) (3, 3, #CHICKEN) (3, 4, #0) (3, 5, #0)
(4, 1, #0) (4, 2, #0) (4, 3, #HOUSE) (4, 4, #0) (4, 5, #0)
(5, 1, #0) (5, 2, #0) (5, 3, #0) (5, 4, #0) (5, 5, #CHICHKEN)

1,3,HOUSE 의 치킨 거리 값은 1
2,5,HOUSE 의 치킨 거리 값은 2
3,2,HOUSE 치킨 거리 값은 1
4,3,HOUSE 치킨 거리 값은 1

도시의 치킨 거리 최솟값은 = 모든 집의 치킨 거리의 합 1 + 2 + 1 + 1 = 5

Example2.
(1, 1, #0) (1, 2, #CHICKEN) (1, 3, #0) (1, 4, #HOUSE) (1, 5, #0)
(2, 1, #HOUSE) (2, 2, #0) (2, 3, #HOUSE) (2, 4, #0) (2, 5, #HOUSE)
(3, 1, #0) (3, 2, #0) (3, 3, #0) (3, 4, #0) (3, 5, #0)
(4, 1, #CHICKEN) (4, 2, #0) (4, 3, #0) (4, 4, #HOUSE) (4, 5, #HOUSE)
(5, 1, #CHICKEN) (5, 2, #CHICKEN) (5, 3, #0) (5, 4, #HOUSE) (5, 5, #CHICHKEN)

여기서 치킨집 2개만 남기고 폐업

그러면 2개를 남길 치킨집을 선택해야 함

즉, 현재 그래프에서 치킨집은 chickens = { (1,2), (4,1), (5,1), (5,2), (5,5) }

chickens(치킨집 좌표를 담고 있는 리스트)에서 5개 중에서 2개를 선택해야 하니 조합을 사용해야 함

조합은 서로 다른 n 개의 원소를 가지는 어떤 집합 에서 순서에 상관없이 r 개의 원소를 선택하는 것

이렇게 선택된 2개는 각 집으로부터 치킨 거리를 구할때 사용, 따라서 이중 반복문 필요

dfs() {
    int result = 0;
    for(집) {
        int temp = INTEGER.MAX_VALUE;
        for(치킨집) {
            if(조합으로 선택된 치킨집) {
                // 집과 선택된 치킨집과의 최소 거리가 temp 에 담긴다.
                거리 = Math.abs(집x - 치킨x) + Math.abs(집y - 치킨y);
                temp = Math.min(temp, 거리);
            }
        }
        // 최소 거리의 합 = 도시의 치킨 거리의 최솟값
        result += temp;
    }
    // 기존 answer 에 담긴 도시의 치킨 거리 최솟값과, 조합으로 선택된 도시의 치킨 거리 최솟값을 비교하여 작은 값을 answer 로 갱신
    answer = Math.min(answer, result);
}
 */
public class Main {

    static int N;
    static int M;
    static final int HOUSE = 1;
    static final int CHICKEN = 2;
    static int[][] graph;
    static List<Position> houses = new ArrayList<>();
    static List<Position> chickens = new ArrayList<>();
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) {
        input();
        combinationByDfs(chickens, visited, 0, M);
        System.out.println(answer);
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N + 1][N + 1];

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                int value = sc.nextInt();
                graph[r][c] = value;
                if(value == HOUSE) {
                    houses.add(new Position(r, c));
                }
                if(value == CHICKEN) {
                    chickens.add(new Position(r, c));
                }
            }
        }
        visited = new boolean[chickens.size()];
    }

    /**
     * 조합을 이용하여 부분집합 구하기
     * @param chickens 치킨 집
     * @param visited 해당 원소를 사용하는지 여부
     * @param currentIndex 현재 인덱스
     * @param r 뽑을 개수
     */
    static void combinationByDfs(List<Position> chickens, boolean[] visited, int currentIndex, int r) {
        if(r == 0) {
            calculateMinDistance(chickens, visited);
            return;
        }
        if(currentIndex == chickens.size()) {
            return;
        } else {
            visited[currentIndex] = true; // currentIndex 에 해당하는 원소를 사용한다라는 의미
            combinationByDfs(chickens, visited, currentIndex + 1, r - 1);

            visited[currentIndex] = false; // currentIndex 에 해당하는 원소를 사용하지 않는다라는 의미
            combinationByDfs(chickens, visited, currentIndex + 1, r);
        }
    }

    // 도시의 치킨 거리 최솟 값 계산하기
    static void calculateMinDistance(List<Position> chickens, boolean[] visited) {
        // 집과 치킨 집을 비교
        int result = 0;
        for (int i = 0; i < houses.size(); i++) {
            int temp = Integer.MAX_VALUE;
            for (int k = 0; k < chickens.size(); k++) {
                if(visited[k]) { // 치킨 집은 조합으로 선택된 치킨집이어야 함
                    int distance = Math.abs(houses.get(i).x - chickens.get(k).x)
                            + Math.abs(houses.get(i).y - chickens.get(k).y);
                    temp = Math.min(temp, distance);
                }
            }
            result += temp; // 도시의 치킨 거리 누적
        }
        answer = Math.min(answer, result);
    }
}
