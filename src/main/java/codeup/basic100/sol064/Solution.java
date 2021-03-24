package codeup.basic100.sol064;

import java.util.Scanner;

// 1066
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");

        for(int i=0; i<arr.length; i++) {
            printResult(Integer.parseInt(arr[i]));
        }
    }

    private static void printResult(int num) {
        System.out.println(findEvenOrOdd(num));
    }

    private static String findEvenOrOdd(int num) {
        return num % 2 == 0 ? "even" : "odd";
    }

}
