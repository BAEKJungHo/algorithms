package inflearn.twopointers.continuoussum;

import java.util.Scanner;

/**
 * # 연속된 자연수의 합
 *
 * 설명
 * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
 * 만약 N=15이면
 * 7+8=15
 * 4+5+6=15
 * 1+2+3+4+5=15
 * 와 같이 총 3가지의 경우가 존재한다.
 *
 * 입력
 * 첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.
 *
 * 출력
 * 첫 줄에 총 경우수를 출력합니다.
 *
 * 예시 입력 1
 * 15
 *
 * 예시 출력 1
 * 3
 */
public class Main {

    // 1. 배열을 만든다 15 기준으로 연속된 자연수의 합이 15가 되려면 7,8 이 끝임 즉, 배열의 원소는 15/2+1만큼만 있으면 됌
    // 2. Two pointers 와 Sliding window 를 이용
    public int solution(int n) {
        int size = n/2 + 1;
        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = i+1;
        }

        // Two pointers 와 Sliding window 를 이용 : 암기
        int answer = 0, sum = 0, lt = 0;
        for(int rt=0; rt<size; rt++) {
            sum += arr[rt];
            if(sum == n) {
                answer++;
            }
            while(sum >= n) {
                sum -= arr[lt++];
                if(sum == n) {
                    answer++;
                }
            }
        }

        return answer;
    }

    // 수학적인 방법으로 해결
    // cnt = 연속된 자연수의 개수
    public int solution2(int n){
        int answer=0, cnt=1;
        n--;
        while(n>0){
            cnt++;
            n=n-cnt;
            if(n%cnt==0) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }
}
