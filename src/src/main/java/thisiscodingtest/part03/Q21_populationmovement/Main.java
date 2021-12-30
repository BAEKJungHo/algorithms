package thisiscodingtest.part03.Q21_populationmovement;

/*
# 인구이동
N X M 크기의 땅
각각의 땅에는 나라(노드)가 하나씩 존재
r 행 c 열에 있는 나라에는 A[r][c] 명이 살고 있음
인접한 나라 사이에는 국경선(간선)이 존재
모든 나라는 1x1 크기

- 국경선을 공유하는 두 나라의 인구차이가 L 명 이상, R 명 이하라면, 두 나라가 공유하는 국경선을 하루동안 연다
- 국경선이 열렸으면 인구이동 시작
- 국경선을 통해서 이동할 수 있으면 그 나라들을 오늘 하루동안 '연합' 이라고 함
- 연합을 이루고 있는 각 칸의 인구수 : 연합의 인구수 / 연합을 이루고 있는 칸의 개수
- 연합을 해체하고 국경선 닫기

# Example
3 5 10
10 15 20
20 30 25
40 22 10

5 <= p <= 10
(x, y) : 나라
- : 국경선

(1, 1 #10)-(1, 2 #15)-(1, 3 #20)
  |                       |
(2, 1 #20)-(2, 2 #30)-(2, 3 #25)
                |
(3, 1 #40) (3, 2 #22) (3, 3 #10)

인접한 것을 판단하기 위해서 상하좌우로 탐색해야 함

----------------------------------------------------------------------------------------------------------------
Step1. 상하좌우로 분석하여 연합 찾기
연합1
(1, 1 #10)-(1, 2 #15)-(1, 3 #20)
  |                       |
(2, 1 #20)-(2, 2 #30)-(2, 3 #25)
                |
           (3, 2 #22)

연합을 이루고 있는 각 칸의 인구수 = 연합의 인구수(10 + 15 + 20 + 20 + 22 + 25 + 30) / 연합을 이루고 있는 칸의 개수
142 / 7 = 20

따라서, 연합의 인구수를 계산하기 위한 변수와, 칸의 개수를 나타내는 변수가 필요함

연합 후 인구 이동한 수 : 인구수가 균등분배되었기 때문에 기존에 연합했던 애들은 연합이 끊어짐
(1, 1 #20) (1, 2 #20) (1, 3 #20)

(2, 1 #20) (2, 2 #20) (2, 3 #20)

(3, 1 #40) (3, 2 #20) (3, 3 #10)

Step2. 다시 연합 가능한 애들이 있는지 확인하여 연합

연합2
             (2, 3 #20)
                 |
(3, 2 #20) - (3, 3 #10)

50 / 3 = 16

연합 더이상 불가능 종료
(1, 1 #20) (1, 2 #20) (1, 3 #20)

(2, 1 #20) (2, 2 #20) (2, 3 #16)

(3, 1 #40) (3, 2 #16) (3, 3 #16)

----------------------------------------------------------------------------------------------------------------

문제에서 원하는 결과는 인구이동이 몇번일어났는지를 원하는데, "연합이 몇번 생겼는지" 를 확인하면 된다.

----------------------------------------------------------------------------------------------------------------
# BFS
(1, 1 #10) 을 먼저 큐에 넣고, 여기에 인접한(상하좌우) 애들을 탐색해서, 국경선이 열려있으면 해당 나라들을 큐에넣어서
큐가 빌 때까지 반복

위 예시를 기준으로 bfs 함수를 타는 횟수는 총 3번이다.

step1. 0,0 일때 bfs 탐색으로 인해서 국경선을 쭉 연결하고 -> (2,0) 과 (2,2) 는 연결이 안된상태
step2. (2,0) 과 (2,2) 에 대해서 연결 가능한 나라들을 bfs 로 탐색
step3. 이동이 일어나지 않으면 종료
 */
import java.util.*;

class Country {

    private int x;
    private int y;

    public Country(int x, int y) {
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

public class Main {

    private static int N;
    private static int L;
    private static int R;
    private static int[][] graph; // (x, y) 나라 에 저장된 값은 인구수
    private static boolean[][] visited; // 방문 처리 여부
    private static List<Country> unitedCountries; // 연합된 나라들
    private static int unitedCount = 0; // 연합한 나라의 개수
    private static int sumOfPopulationInUnitedCountry = 0; // 연합한 나라들의 인구수 합
    private static int answer = 0; // 인구 이동이 일어난 횟수

    // 상하좌우 : 인접한 나라를 판단하기 위함
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        input();
        solution();
        System.out.println(answer);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        // 그래프, 방문처리여부 초기화
        graph = new int[N][N];

        // 인구수 저장
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                graph[i][k] = sc.nextInt();
            }
        }
    }

    // 인구이동이 발생하지 않을 때 까지 반복
    private static void solution() {
        while(true) {
            boolean isMoved = false;
            visited = new boolean[N][N];
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if(!visited[x][y]) { // uniteByBfs 를 통해 방문처리 된 인접리스트들에 대해서도 생략
                        uniteByBfs(x, y);
                        if(unitedCountries.size() > 1) {
                            move();
                            answer++;
                            isMoved = true;
                        }
                    }
                }
            }
            if(!isMoved) {
                break;
            }
        }
    }

    private static void uniteByBfs(int x, int y) {
        Queue<Country> Q = new LinkedList<>();
        unitedCountries = new ArrayList<>();

        Country start = new Country(x, y);
        Q.offer(start);
        unitedCountries.add(start);
        visited[x][y] = true;

        // 연합한 나라의 개수 : 자기 자신으로 초기화
        unitedCount = 1;
        // 연합한 나라의 인구수 합 탐색 대상인 나라의 인구수로 초기화
        sumOfPopulationInUnitedCountry = graph[x][y];
        while(!Q.isEmpty()) {
            Country country = Q.poll();
            x = country.getX();
            y = country.getY();
            int p1 = graph[x][y];
            // 상하좌우 탐색
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if((nx >= 0 && ny >= 0 && nx < N && ny < N) && !visited[nx][ny]) {
                    int p2 = graph[nx][ny];
                    if(isLinkable(p1, p2)) {
                        Country adjacentCountry = new Country(nx, ny);
                        // 연결 가능한 인접한 나라를 Q 에 넣는다.
                        Q.offer(adjacentCountry);
                        // 연합한 나라를 보관하는 리스트에 넣는다.
                        unitedCountries.add(adjacentCountry);
                        // 연합한 나라의 인구수 합 누적
                        sumOfPopulationInUnitedCountry += p2;
                        // 연합한 나라의 개수 증가
                        unitedCount++;
                        // 방문 처리
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    // 인구가 존재하는지
    private static boolean hasPopulation(int p2) {
        return p2 > 0;
    }

    // 연결 가능한지
    private static boolean isLinkable(int p1, int p2) {
        int absValue = Math.abs(p1 - p2);
        return L <= absValue && absValue <= R;
    }

    // 인구 이동, 연합한 나라들의 인구수를 재계산
    private static void move() {
        for(Country country : unitedCountries) {
            graph[country.getX()][country.getY()] = sumOfPopulationInUnitedCountry / unitedCount;
        }
    }
}
