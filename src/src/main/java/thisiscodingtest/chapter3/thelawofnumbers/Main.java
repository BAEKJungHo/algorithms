package thisiscodingtest.chapter3.thelawofnumbers;

import java.util.Arrays;
import java.util.Scanner;

// 큰 수의 법칙
public class Main {

    // Idea.
    //  1. 입력된 숫자의 배열을 오름 차순으로 정렬한다.
    //  2. 더해야 하는 숫자는 배열의 가장 큰 값과, 두 번째로 큰 값이다.

    /**
     * 큰 수의 법칙
     * @param arr inputNumbers
     * @param m 총 더하는 횟수
     * @param k 연속해서 더할 수 있는 횟수
     * @return answer
     */
    public int solution(int[] arr, int m, int k) {
        int answer = 0;
        Arrays.sort(arr);

        int loopCount = k;
        int i = arr.length - 1;
        while(m > 0) {
            while(loopCount > 0) { // 가장 큰 수 반복해서 더하기
                answer += arr[i];
                loopCount--;
                m--;
            }
            if(m > 0) { // 두 번째로 큰 수 하나 더하기
                answer += arr[i-1];
                m--;
            }
            if(m >= k) { // 다음에 더할 가장 큰 수 반복 횟수 세팅하기
                loopCount = k;
            } else {
                loopCount = m;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr, m, k));
    }

}