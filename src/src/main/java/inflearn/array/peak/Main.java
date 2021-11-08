package inflearn.array.peak;

import java.util.Scanner;

/**
 * # 봉우리
 *
 * 설명
 * 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
 * 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
 * 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
 *
 * 입력
 * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 *
 * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 *
 *
 * 출력
 * 봉우리의 개수를 출력하세요.
 *
 *
 * 예시 입력 1
 * 5
 * 5 3 7 2 3
 * 3 7 1 6 1
 * 7 2 5 3 4
 * 4 3 6 4 1
 * 8 7 3 5 2
 *
 * 예시 출력 1
 * 10
 */
public class Main {

    int[] dx={-1, 0, 1, 0};
    int[] dy={0, 1, 0, -1};

    /*
       방향이 들어가는 문제는 아래 처럼 사용
       int[] dx = {-1, 0, 1, 0};
       int[] dy = {0, 1, 0, -1};
       3중 포문 필요 : 격자판 i,k 에 대한 2중 포문 + 좌표 p 에 대한 포문
     */
    public int solution(int n, int[][] grid) {
        int answer=0;
        for(int i=0; i<n; i++){ // 격자판 행 반복
            for(int k=0; k<n; k++){ // 격자판 열 반복
                boolean isPeak=true;
                for(int p=0; p<4; p++){ // 봉우리를 구하기 위해 비교해야 하는 좌표 반복
                    int nx=i+dx[p];
                    int ny=k+dy[p];
                    if(nx>=0 && nx<n && ny>=0 && ny<n && grid[nx][ny]>=grid[i][k]){
                        isPeak=false;
                        break;
                    }
                }
                if(isPeak) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int gridCount = sc.nextInt();

        int[][] grid = new int[gridCount][gridCount];
        for(int i=0; i<gridCount; i++) {
            for(int k=0; k<gridCount; k++) {
                grid[i][k] = sc.nextInt();
            }
        }

        System.out.println(T.solution(gridCount, grid));
    }

}
