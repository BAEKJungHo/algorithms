package codeup.basic100.sol046;

import java.util.Scanner;

// 1048
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");

        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[1]);

        int powNum = (int) Math.pow(2, num2);
        System.out.println(num1 * powNum);
    }

}
