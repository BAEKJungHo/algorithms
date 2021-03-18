package codeup.basic100.sol021;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        float fNum = 0f;
        try {
            fNum = Float.parseFloat(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException("실수를 입력해 주세요.");
        }

        String[] arr = str.split("\\.");
        boolean isNotCorrectCondition = Math.abs(fNum) > 10000 || arr[1].length() > 6 || arr[1].substring(0, 1).equals("0");

        if(isNotCorrectCondition) {
            System.out.println("조건에 맞지 않습니다.");
            return;
        }

        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }

}
