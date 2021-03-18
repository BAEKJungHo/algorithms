package codeup.basic100.sol012;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String[] str = num.split(" ");
        System.out.println(Integer.parseInt(str[0]) + " " + Integer.parseInt(str[1]));
    }

}
