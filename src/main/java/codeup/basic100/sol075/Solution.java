package codeup.basic100.sol075;

import java.util.Scanner;

// 1077
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean canPass = num >=0 && num <= 100;
        if(!canPass) {
            return ;
        }

        for(int i=0; i<num; i++) {
            System.out.println(i);
        }
    }

}
