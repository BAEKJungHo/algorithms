package codeup.basic100.sol041;

import java.util.Scanner;

// 1043
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");

        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[1]);

        if(num1 < num2) {
            System.out.println("첫 번째 숫자는 두 번째 숫자보다 작을 수 없습니다.");
            return;
        }

        System.out.println(Integer.parseInt(arr[0]) % Integer.parseInt(arr[1]));
    }

}
