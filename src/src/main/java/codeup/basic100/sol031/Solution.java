package codeup.basic100.sol031;

import java.util.Scanner;

// 1033
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String hexStr = Integer.toHexString(num);
        System.out.println(String.format("%S", hexStr));
    }

}
