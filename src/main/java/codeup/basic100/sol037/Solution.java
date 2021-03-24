package codeup.basic100.sol037;

import java.util.Scanner;

// 1039
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        long result = Long.parseLong(arr[0]) + Long.parseLong(arr[1]);
        System.out.println(result);
    }

}
