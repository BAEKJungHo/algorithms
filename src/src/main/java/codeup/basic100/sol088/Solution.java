package codeup.basic100.sol088;

import java.util.Scanner;

// 1090
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int r = sc.nextInt();
        int n = sc.nextInt();

        for(int i=1; i<n; i++) {
            a*=r;
        }
        System.out.print(a);
    }

}
