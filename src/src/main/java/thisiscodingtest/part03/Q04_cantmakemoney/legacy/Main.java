package thisiscodingtest.part03.Q04_cantmakemoney.legacy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int N;
    private static int[] coins;
    private static boolean[] check = new boolean[1000001]; // 1 ~ 9 까지에 최솟값이 무조건 존재


    public static void main(String[] args) {
        input();
        solution();
        output();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        coins = new int[N];
        // check 배열 초기화
        for (int i = 1; i < check.length; i++) {
            check[i] = false;
        }
        for (int i = 0; i < N; i++) {
            int coin = sc.nextInt();
            coins[i] = coin;
            // 보유하고 있는 코인에 대해 check
            check[coin] = true;
        }
    }

    private static void solution() {
        Arrays.sort(coins);

        // 더하기 연산
        for (int i = 0; i < coins.length; i++) {
            int outSum = coins[i];
            for (int k = i+1; k < coins.length; k++) {
                int inSum = coins[i] + coins[k];
                outSum += coins[k];
                if(inSum < 1000001) {
                    check[inSum] = true;
                }
                if(outSum < 1000001) {
                    check[outSum] = true;
                }
            }
        }
    }

    private static void output() {
        for (int i = 1; i < check.length; i++) {
            if(!check[i]) {
                System.out.println(i);
                break;
            }
        }
    }


}
