package codeup.basic100.sol063;

import java.util.Scanner;

// 1065
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");

        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[1]);
        int num3 = Integer.parseInt(arr[2]);

        if(num1 % 2 == 0) {
            System.out.println(num1);
        }
        if(num2 % 2 == 0) {
            System.out.println(num2);
        }
        if(num3 % 2 == 0) {
            System.out.println(num3);
        }
    }

}
