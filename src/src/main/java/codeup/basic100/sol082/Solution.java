package codeup.basic100.sol082;

import java.util.Scanner;

// 1084
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] rgb = str.split(" ");
        int red = Integer.parseInt(rgb[0]);
        int green = Integer.parseInt(rgb[1]);
        int blue = Integer.parseInt(rgb[2]);

        int count = 0;
        for(int r=0; r<red; r++) {
            for(int g=0; g<green; g++) {
                for(int b=0; b<blue; b++) {
                    System.out.println(String.format("%d %d %d", r, g, b));
                    count++;
                }
            }
        }
        System.out.println(count);
    }

}
