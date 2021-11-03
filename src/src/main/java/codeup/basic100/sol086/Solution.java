package codeup.basic100.sol086;

import java.util.Scanner;

// 1088
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for(int i=1; i<=num; i++) {
            if(i % 3 == 0) continue; // 3의배수면 아래부분 생략하고 계속 반복
            System.out.print(i+" ");
        }
    }

}
