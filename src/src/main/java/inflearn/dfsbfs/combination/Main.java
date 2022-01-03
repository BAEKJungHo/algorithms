package inflearn.dfsbfs.combination;

import java.util.Scanner;

// 조합(Combination) : nCr = n-1Cr-1 + n-1Cr
// n 명 중에서 r 명을 뽑는 경우
// 5C3 = 4C2 + 4C3
public class Main {

    static int[][] store = new int[35][35];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(combinationByDfsWithMemoization(sc.nextInt(), sc.nextInt()));
    }

    // 일반 재귀
    static int combinationByDFS(int n, int r) {
        if(n == r || r ==0) {
            return 1;
        } else {
            return combinationByDFS(n - 1, r - 1) + combinationByDFS(n - 1, r);
        }
    }

    // 메모이제이션
    static int combinationByDfsWithMemoization(int n, int r) {
        if(store[n][r] > 0) {
            return store[n][r];
        }
        if(n == r || r ==0) {
            return 1;
        } else {
            return store[n][r] = combinationByDfsWithMemoization(n - 1, r - 1) + combinationByDfsWithMemoization(n - 1, r);
        }
    }
}
