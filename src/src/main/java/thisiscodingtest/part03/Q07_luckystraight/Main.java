package thisiscodingtest.part03.Q07_luckystraight;

import java.util.Scanner;

public class Main {

    private static String N;
    private static int left = 0;
    private static int right = 0;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLine();
    }

    private static void solution() {
        String[] numbers = N.split("");
        int middle = numbers.length / 2;
        for (int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);
            if (i < middle) {
                left += number;
            } else {
                right += number;
            }
        }

        if(left == right) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
