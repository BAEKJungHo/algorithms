package codeup.basic100.sol093;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 1095
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int attendanceCount = sc.nextInt();

        int[] attendances =  new int[1];

        int index = 0;
        while(attendanceCount > 0) {
            int value = sc.nextInt();
            if(value < 1 || value > 23) {
                System.out.println("1~23 사이의 숫자를 입력해 주세요.");
                continue;
            }

            if(index == 0) {
                attendances[0] = value;
            } else {
                if (value < attendances[0]) {
                    attendances[0] = value;
                }
            }
            index++;
            attendanceCount--;
        }


        System.out.print(attendances[0]);
    }

}
