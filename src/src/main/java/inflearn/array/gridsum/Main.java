package inflearn.array.gridsum;

import java.util.Scanner;

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
