package thisiscodingtest.part03.Q27_getcountofsortedarray;

import java.util.Scanner;

// 정렬된 배열에서 특정 수의 개수 구하기
public class Main {

    private static int N;
    private static int x; // 찾고자 하는 값
    private static boolean isEmpty = true; // X 가 배열안에 존재하지 않는지 확인하기 위한 변수
    private static int[] numbers;
    private static int startPoint = Integer.MIN_VALUE; // 시작점
    private static int endPoint = Integer.MAX_VALUE; // 종료점

    public static void main(String[] args) {
        solution();
        if(isEmpty) {
            System.out.println(-1);
        } else {
            System.out.println(endPoint - startPoint);
        }
    }

    // 문제에서 정렬이 주어진채로 입력하게 되어있어서, 굳이 이진 탐색 필요 없이, 입력에서 끝낼 수 있음.
    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        x = sc.nextInt();

        // 배열과 종료점 초기화
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
            if(numbers[i] == x) { // 찾고자하는 값이 존재하면
                isEmpty = false;  // isEmpty false 처리
                // startPoint 가 갱신된 적이 없으면, 가장 처음 발견된 x 의 위치를 startPoint 로 설정
                if(startPoint == Integer.MIN_VALUE) {
                    startPoint = i;
                }
            }
            // endPoint 가 갱신된 적이 없고, x 보다 큰 값이 처음 발견되면 종료점으로 초기화
            if(numbers[i] > x && endPoint == Integer.MAX_VALUE) {
                endPoint = i;
            }
        }
    }
}
