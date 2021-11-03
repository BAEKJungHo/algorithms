package codeup.basic100.sol051;

import java.util.Scanner;

// 1053
public class Solution {

    public static void main(String[] args) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();

            if (num != 0 || num != 1) {
                continue;
            }

            System.out.println(num == 0 ? 1 : 0);
            break;
        }
    }

}
