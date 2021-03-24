package codeup.basic100.sol085;

import java.util.Scanner;

// 1087
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int sum = 0;
        int index = 1;

        while(true) {
            sum += index;
            if(sum >= num) {
                break;
            }
            index++;
        }

        System.out.println(sum);
    }

}
