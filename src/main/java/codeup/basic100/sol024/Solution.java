package codeup.basic100.sol024;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            String time = sc.nextLine();
            String[] arr = time.split(":");

            if (arr.length != 3) {
                System.out.println("시:분:초 형식으로 입력해야 합니다.");
                continue;
            }

            System.out.println(arr[1]);
            break;
        }

    }

}
