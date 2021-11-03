package codeup.basic100.sol089;

import java.util.Scanner;

// 1091
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        int n = sc.nextInt();

        for(int i=1; i<n; i++) {
            a = (a*m)+d;
        }
        System.out.println(a);
    }

}
