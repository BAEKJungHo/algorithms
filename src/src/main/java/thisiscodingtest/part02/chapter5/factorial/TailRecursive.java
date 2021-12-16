package thisiscodingtest.part02.chapter5.factorial;

import java.util.Scanner;

public class TailRecursive {

    public static int factorialTail(int n, int total) {
        return n == 1 ? total : factorialTail(n - 1,  n * total);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorialTail(n, 1));
    }

}
