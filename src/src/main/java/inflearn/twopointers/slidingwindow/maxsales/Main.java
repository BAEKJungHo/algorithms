package inflearn.twopointers.slidingwindow.maxsales;


import java.util.Scanner;

/**
 * # 최대 매출 : Sliding window -> O(n)
 * 슬라이딩 윈도우(Sliding Window) 알고리즘은 배열이나 리스트의 요소의 일정 범위의 값을 비교할때 사용하면 유용한 알고리즘이다.
 *
 * 설명
 * 현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
 * 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
 * 12 1511 20 2510 20 19 13 15
 * 연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
 * 여러분이 현수를 도와주세요.
 *
 * 입력
 * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 *
 * 출력
 * 첫 줄에 최대 매출액을 출력합니다.
 *
 * 예시 입력 1
 * 10 3
 * 12 15 11 20 25 10 20 19 13 15
 *
 * 예시 출력 1
 * 56
 */
public class Main {

    public int solution(int n, int m, int[] arr) {
        int answer = 0, sum = 0;

        // sum 초기화 : 연속된 m 개의 합
        for(int i=0; i<m; i++) {
            sum += arr[i];
        }

        // answer 초기화
        answer = sum;

        // m 부터 n 까지 반복문
        // 기존 sum 을 더하는 이유는 공통요소가 들어있기 때문이다. (sum = 공통요소의 합 + 맨 뒷자리의 값)
        // 즉, m 이후의 반복문에서는 공통요소의합 + m 이후의 값 - 기존 sum 의 맨 뒷자리의 값(i-m) 이된다.
        for(int i=m; i<n; i++) {
            sum += (arr[i] - arr[i-m]); // Point. 공통요소는 냅두고, 맨 뒷 자리 값만 뺀다.
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }

}
