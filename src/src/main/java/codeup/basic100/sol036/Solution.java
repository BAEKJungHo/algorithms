package codeup.basic100.sol036;

import java.util.Scanner;

// 1038
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        System.out.println(Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]));
    }

}
