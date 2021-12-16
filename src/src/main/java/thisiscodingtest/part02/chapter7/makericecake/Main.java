package thisiscodingtest.part02.chapter7.makericecake;

import java.util.Arrays;
import java.util.Scanner;

// 떡볶이 떡 만들기
public class Main {

    private static int n; // 떡의 개수
    private static int m; // 조건(condition) : 손님이 얻고자 하는 떡의 길이
    private static int[] arr; // 떡's

    public static void main(String[] args) {
        initializeInputData();
        System.out.println(decisionAlgorithm());
    }

    private static void initializeInputData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    // 절단기의 높이를 middlePoint 로 설정하여 이분 검색 실시 (middlePoint = h = answer)
    private static int decisionAlgorithm() {
        // precondition
        ascendingSort(arr);

        int answer = 0; // 구하고자하는 답 : max h (절단기 높이의 최댓값)
        int startPoint = 1; // 입력 값 n 의 시작 범위 (1 <= n <= 1000000 이므로 1)
        int endPoint = arr[n - 1]; // 배열의 마지막 원소 값

        while(startPoint <= endPoint) {
            int middlePoint = (startPoint + endPoint) / 2;
            if(decisionToFindTheOptimizedValue(middlePoint) >= m) {
                answer = middlePoint;
                startPoint = middlePoint + 1;
            } else {
                endPoint = middlePoint - 1;
            }
        }

        return answer;
    }

    private static void ascendingSort(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * answer(middlePoint)에 따라서 계산되는 함수 = 최적화된 값을 구하기 위해 판단을 내려주는 함수
     * @param middlePoint 절단기의 높이
     * @return 절단된 떡의 길이의 합
     */
    private static int decisionToFindTheOptimizedValue(int middlePoint) {
        int sum = 0;
        for(int element : arr) {
            if(element > middlePoint) {
                sum += element - middlePoint;
            }
        }
        return sum;
    }
}
