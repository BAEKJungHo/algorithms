package codeup.basic100.sol076;

import java.util.Scanner;

// 1078
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean canPass = num >=0 && num <= 100;
        if(!canPass) {
            return ;
        }

        int sum = 0;
        for(int i=2; i<=num; i+=2) {
            sum += i;
        }
        System.out.println(sum);
    }

}
