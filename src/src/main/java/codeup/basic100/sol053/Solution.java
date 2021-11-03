package codeup.basic100.sol053;

import java.util.Scanner;

// 1055
public class Solution {

    public static void main(String[] args) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            String[] arr = str.split(" ");

            int num1 = Integer.parseInt(arr[0]);
            int num2 = Integer.parseInt(arr[1]);

            if (num1 != 0 || num1 != 1 || num2 != 0 || num2 != 1) {
                continue;
            }

            System.out.println(num1 == 1 || num2 == 1 ? 1 : 0);
            break;
        }
    }

}
