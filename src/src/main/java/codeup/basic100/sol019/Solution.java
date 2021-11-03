package codeup.basic100.sol019;

import java.util.Scanner;

// 1021
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] data = new char[51];

        if(str.length() <= 51) {
            for (int i = 0; i < str.length(); i++) {
                data[i] = str.charAt(i);
                System.out.print(data[i]);
            }
        }

    }

}
