package codeup.basic100.sol065;

import java.util.Scanner;

// 1067
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num != 0) {
            printResult(num);
        }
    }

    private static void printResult(int num) {
        System.out.println(findPlusOrMinus(num));
        System.out.println(findEvenOrOdd(num));
    }

    private static String findPlusOrMinus(int num) {
        return num > 0 ? "plus" : "minus";
    }

    private static String findEvenOrOdd(int num) {
        return num % 2 == 0 ? "even" : "odd";
    }

}
