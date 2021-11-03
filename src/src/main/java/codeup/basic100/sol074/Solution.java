package codeup.basic100.sol074;

import java.util.Scanner;

// 1076
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char alphabet = sc.nextLine().charAt(0);

        char start = 'a';
        do {
            System.out.print(start + " ");
            start += 1;
        } while(start <= alphabet);
    }

}
