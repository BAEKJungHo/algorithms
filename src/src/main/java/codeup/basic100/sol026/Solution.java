package codeup.basic100.sol026;

import java.util.Scanner;

// 1028
public class Solution {

    public static void main(String[] args) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            long num = sc.nextLong();

            if (num < 0 || num > 4294967295L) {
                System.out.println("0 ~ 4294967295 범위의 정수를 입력해야 합니다.");
                continue;
            }

            System.out.println(num);
            break;
        }
    }

}
