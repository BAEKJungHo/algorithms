package inflearn.array.gridsum;

import java.util.Scanner;

/**
 * # 격자판 최대 합
 *
 * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
 *
 * 입력
 * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 *
 * 출력
 * 최대합을 출력합니다.
 *
 * 예시 입력 1
 *
 * 5
 * 10 13 10 12 15
 * 12 39 30 23 11
 * 11 25 50 53 15
 * 19 27 29 37 27
 * 19 13 30 13 19
 * 예시 출력 1
 *
 * 155
 */
public class Main {

    // 행, 열에 대한 합을 구한다.
    // 1. Math.max 로 answer 와 행을 비교한 후 answer 에 대입
    // 2. Math.max 로 answer 와 열을 비교
        // 이 과정이 끝나면 answer 에는 각 행과 열의 합에 대한 max 값이 있음
    // 대각선 반복문을 돌린다.
        // Math.max 로 answer 와 왼쪽 대각선, 오른쪽 대각선 합을 비교
    public int solution(int n, int[][] grid) {
        int answer=-2147000000;
        int sum1=0, sum2=0;
        for(int i=0; i<n; i++){
            sum1=sum2=0;
            for(int j=0; j<n; j++){
                sum1+=grid[i][j];
                sum2+=grid[j][i];
            }
            answer=Math.max(answer, sum1);
            answer=Math.max(answer, sum2);
        }
        sum1=sum2=0;
        for(int i=0; i<n; i++){
            sum1+=grid[i][i];
            sum2+=grid[i][n-i-1];
        }
        answer=Math.max(answer, sum1);
        answer=Math.max(answer, sum2);
        
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[][] grid = new int[count][count];
        for(int i=0; i<count; i++) {
            for(int k=0; k<count; k++) {
                grid[i][k] = sc.nextInt();
            }
        }
        System.out.println(T.solution(count, grid));
    }

}
