package codeup.basic100.sol066;

import java.util.Scanner;

// 1068
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        printResult(num);
    }

    private static void printResult(int num) {
        System.out.println(findGrade(num));
    }

    private static String findGrade(int num) {
        if(num >= 90 && num <= 100) {
            return "A";
        } else if(num >= 70 && num <= 89) {
            return "B";
        } else if(num >= 40 && num <= 69) {
            return "C";
        } else {
            return "D";
        }
    }

}
