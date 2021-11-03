package codeup.basic100.sol013;

import java.util.Scanner;

// 1014
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();

        String[] str = num.split(" ");
        char a = str[0].charAt(0);
        char b= str[1].charAt(0);

        System.out.println(a + " " + b);
    }

}
