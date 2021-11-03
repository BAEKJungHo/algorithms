package codeup.basic100.sol092;

import java.util.Scanner;

// 1094
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int attendanceCount = sc.nextInt();

        int[] attendances =  new int[attendanceCount];

        int index = 0;
        while(attendanceCount > 0) {
            int value = sc.nextInt();
            if(value < 1 || value > 23) {
                System.out.println("1~23 사이의 숫자를 입력해 주세요.");
                continue;
            }
            attendances[index++] = value;
            attendanceCount--;
        }

        for(int i=attendances.length-1; i>=0; i--) {
            System.out.print(attendances[i] + " ");
        }
    }

}
