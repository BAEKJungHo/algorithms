package codeup.basic100.sol078;

import java.util.Scanner;

// 1080
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int sum = 0;
        for(int i=1; i<num; i++) {
            sum += i;
            if(sum >= num) {
                System.out.println(i);
                break;
            }
        }
    }

}
