package codeup.basic100.sol073;

import java.util.Scanner;

// 1075
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while(num-1 >= 0) {
            System.out.println(--num);
        }
    }

}
