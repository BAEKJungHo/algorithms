package codeup.basic100.sol038;

import java.util.Scanner;

// 1040
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num < 0) {
            System.out.println(num * -1);
        } else {
            System.out.println(num);
        }
    }

}
