package codeup.basic100.sol081;

import java.util.Scanner;

// 1083
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for(int i=1; i<=num; i++) {
            if(i>=3 && i%3 == 0) {
                System.out.print("X ");
            } else {
                System.out.print(i + " ");
            }
        }
    }

}
