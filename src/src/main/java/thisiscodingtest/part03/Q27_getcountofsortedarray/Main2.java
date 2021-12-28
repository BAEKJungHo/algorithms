package thisiscodingtest.part03.Q27_getcountofsortedarray;

import java.util.Arrays;
import java.util.Scanner;

// 정렬된 배열에서 특정 수의 개수 구하기
public class Main2 {

    private static int N;
    private static int x; // 찾고자 하는 값
    private static boolean isEmpty = true; // X 가 배열안에 존재하지 않는지 확인하기 위한 변수
    private static int[] numbers;

    public static void main(String[] args) {
        input();
        if(isEmpty) {
            System.out.println(-1);
        } else {
            Arrays.sort(numbers);
            System.out.println(findLastIndex() - findFirstIndex());
        }
    }

    // 정렬이 되어있지 않다고 가정하고 문제 풀이
    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        x = sc.nextInt();

        // 배열과 종료점 초기화
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
            if(numbers[i] == x) { // 찾고자하는 값이 존재하면
                isEmpty = false;  // isEmpty false 처리
            }
        }
    }

    /**
     * # 결정 알고리즘 이용 : 구하고자 하는 값을 반복해서 조정
     * 처음 발견되는 x 와 마지막으로 발견되는 x 의 위치값을 구해서 빼면 된다.
     * findLastIndex() - findFirstIndex()
     * Ex. 1 2 2 5 5 5 6
     * step1. middlePoint = 3 -> 5
     *  5 >= 2 -> end = 3 -> middlePoint = 0 + 3 / 2 -> 1
     */

    private static int findFirstIndex() {
        int startPoint = 0;
        int endPoint = N - 1;

        while(startPoint <= endPoint) {
            int middlePoint = (startPoint + endPoint) / 2;
            if(numbers[middlePoint] >= x) {
                endPoint = middlePoint; // // 구하고자하는 답(answer)을 반복해서 조정
            } else {
                startPoint = middlePoint + 1; // 오른쪽 범위 탐색
            }
        }
        return endPoint;
    }

    private static int findLastIndex() {
        int startPoint = 0;
        int endPoint = N;

        /**
         * startPoint <= endPoint 하면 무한루프 발생
         * 7 2
         * 1 1 2 2 2 2 3
         * (s, e, m)
         * 0, 6, 3
         * 4, 6, 5
         * 6, 6, 6
         */
        while(startPoint < endPoint) {
            int middlePoint = (startPoint + endPoint) / 2;
            if(numbers[middlePoint] > x) {
                endPoint = middlePoint; // 구하고자하는 답(answer)을 반복해서 조정
            } else {
                startPoint = middlePoint + 1;
            }
        }
        return endPoint;
    }
}
