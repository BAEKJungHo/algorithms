package codeup.basic100.sol044;

import java.util.Scanner;

// 1046
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");

        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[1]);
        int num3 = Integer.parseInt(arr[2]);
        int sum = num1 + num2 + num3;
        System.out.println(sum);
        System.out.println(String.format("%.1f",(float)sum / 3.0));

    }

}
