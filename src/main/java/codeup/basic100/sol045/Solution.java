package codeup.basic100.sol045;

import java.util.Scanner;

// 1047
public class Solution {

    /**
     * printf("%d", a<<1); //10을 2배 한 값인 20 이 출력된다.
     * printf("%d", a>>1); //10을 반으로 나눈 값인 5 가 출력된다.
     * printf("%d", a<<2); //10을 4배 한 값인 40 이 출력된다.
     * printf("%d", a>>2); //10을 반으로 나눈 후 다시 반으로 나눈 값인 2 가 출력된다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        // 정수 a의 각 비트를 b만큼 왼쪽으로 이동(빈자리는 0으로 채워진다)
        System.out.println(num<<1);
    }

}
