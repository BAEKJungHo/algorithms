package codeup.basic100.sol025;

import java.util.Scanner;

// 1027
public class Solution {

    public static void main(String[] args) {

        while(true) {
            Scanner sc = new Scanner(System.in);
            String date = sc.nextLine();
            String[] arr = date.split("\\.");

            if(arr.length != 3) {
                System.out.println("년월일 형식을 .으로 구분해서 입력해야 합니다.");
                continue;
            }

            System.out.println(String.format("%02d-%02d-%04d", Integer.parseInt(arr[2]), Integer.parseInt(arr[1]), Integer.parseInt(arr[0])));
            break;
        }

    }

}
