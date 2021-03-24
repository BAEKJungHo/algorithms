package codeup.basic100.sol062;

import java.util.Scanner;

// 1064
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");

        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[1]);
        int num3 = Integer.parseInt(arr[2]);

        int first_result = num1 > num2 ? num2 : num1;

        System.out.println(first_result > num3 ? num3 : first_result);
    }

}
