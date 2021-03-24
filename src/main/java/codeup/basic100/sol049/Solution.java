package codeup.basic100.sol049;

import java.util.Scanner;

// 1051
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");

        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[1]);

        System.out.println(num2 >= num1 ? '1' : '0');
    }

}
