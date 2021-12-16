package thisiscodingtest.part02.chapter3.numbercardgame;

import java.util.Scanner;

// 숫자 카드 게임
public class Main {

    public int solution(int n, int m, int[][] arr) {
        int answer = 0;
        int[] minOfRows = new int[n];
        for(int i=0; i<n; i++) {
            minOfRows[i] = arr[i][0];
            for(int k=0; k<m; k++) {
                minOfRows[i] = Math.min(minOfRows[i], arr[i][k]);
            }
            answer = Math.max(answer, minOfRows[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int k=0; k<m; k++) {
                arr[i][k] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, m, arr));
    }

}
