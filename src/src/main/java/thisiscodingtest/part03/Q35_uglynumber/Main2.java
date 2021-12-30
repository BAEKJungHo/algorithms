package thisiscodingtest.part03.Q35_uglynumber;

import java.util.Scanner;

// 못생긴 수 : 답지
public class Main2 {

    private static int n;
    private static int[] ugly = new int[1000]; // 못생긴 수를 담기 위한 테이블 (1차원 DP 테이블)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 2배, 3배, 5배를 위한 인덱스
        int i2 = 0, i3 = 0, i5 = 0;
        // 처음에 곱셈 값을 초기화
        int next2 = 2, next3 = 3, next5 = 5;

        ugly[0] = 1; // 첫 번째 못생긴 수는 1
        // 1부터 n 까지의 못생긴 수들을 찾기 : 못생긴 수 x 못생긴 수 = 못생긴 수
        for (int now = 1; now < n; now++) {
            // 맨처음에 2, 3, 5 가 못생긴 숫자이므로, 못생긴 수들 중 가장 최솟값을 선택하여 ugly[now] 에 저장
            // ugly[1] = Math.min(2, 3, 5)
            // 가능한 곱셈 결과 중에서 가장 작은 수를 선택
            // ugly[now] = 현재 못생긴 수
            ugly[now] = Math.min(next2, Math.min(next3, next5));

            // 인덱스에 따라서 곱셈 결과를 증가
            // ugly[i2] : 2를 소인수로 갖는, 이전 못생긴 수
            if (ugly[now] == next2) {
                i2 += 1;
                next2 = ugly[i2] * 2;
            }
            if (ugly[now] == next3) {
                i3 += 1;
                next3 = ugly[i3] * 3;
            }
            if (ugly[now] == next5) {
                i5 += 1;
                next5 = ugly[i5] * 5;
            }
        }

        // n번째 못생긴 수를 출력
        System.out.println(ugly[n - 1]);
    }
}
