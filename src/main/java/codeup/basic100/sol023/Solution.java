package codeup.basic100.sol023;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num > 9999 && num < 100000) {
            int tenThounsand = num/10000 * 10000;
            int thousand = (num - tenThounsand)/1000 * 1000;
            int hundred = (num - tenThounsand - thousand)/100 * 100;
            int ten = (num - tenThounsand - thousand - hundred)/10 * 10;
            int one = num - tenThounsand - thousand - hundred - ten;

            System.out.println("["+ tenThounsand +"]");
            System.out.println("["+ thousand +"]");
            System.out.println("["+ hundred +"]");
            System.out.println("["+ ten +"]");
            System.out.println("["+ one +"]");
        }

    }

}
