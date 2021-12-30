package thisiscodingtest.part03.Q35_uglynumber;

import java.util.Scanner;

// 못생긴 수 : 오답
public class Main {

    private static int n;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int discoveredUglyNumberCount = 0;
        int targetNumber = 1;
        while(discoveredUglyNumberCount < n) {
            if(isUglyNumber(targetNumber)) {
                discoveredUglyNumberCount++;
            }
            targetNumber++;
        }
        System.out.println(targetNumber - 1);
    }

    private static boolean isUglyNumber(int n) {
        return ((n % 2 == 0 || n % 3 == 0 || n % 5 == 0) && (n % 7 != 0)) || n == 1;
    }

}
