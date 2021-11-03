package codeup.basic100.sol084;

import java.util.Scanner;

// 1086
public class Solution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();
        int b = sc.nextInt();
        double total = 0;

        if(w>0 && w<=1024 && h>0 && h<=1024 && b>0 && b<=40 && b%4==0) {
            total = (w*h*b)/8;
        }
        double result = (total/Math.pow(2,10))/Math.pow(2, 10);
        System.out.format("%.2f MB", result);
    }

}
