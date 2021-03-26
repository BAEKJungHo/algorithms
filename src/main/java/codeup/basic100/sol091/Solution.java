package codeup.basic100.sol091;

import java.util.Scanner;

// 1093
public class Solution {

    private static final int MAX_NUMBER_LIMIT = 23;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int attendanceCount = sc.nextInt();

        int[] result = new int[MAX_NUMBER_LIMIT];
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

        for(int i=0; i<attendances.length; i++) {
            result[attendances[i]] += 1;
        }

        for(int i=1; i<MAX_NUMBER_LIMIT; i++) {
            System.out.print(result[i] + " ");
        }
    }

}
