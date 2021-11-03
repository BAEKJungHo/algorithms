package codeup.basic100.sol087;

import java.util.Scanner;

// 1089
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int d = sc.nextInt();
        int n = sc.nextInt();
        for(int i=a; i<n; i++) {
            a += d;
        }
        System.out.print(a);
    }

}
