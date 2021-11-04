package inflearn.array.fibonaccisequence;

import java.util.Scanner;

/**
 * # 피보나치 수열
 *
 * 설명
 * 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 *
 * 입력
 * 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
 *
 * 출력
 * 첫 줄에 피보나치 수열을 출력합니다.
 *
 * 예시 입력 1
 * 10
 *
 * 예시 출력 1
 * 1 1 2 3 5 8 13 21 34 55
 */
public class Main {

    public int[] solution(int count) {
        int start = 1;
        int[] answer = new int[count];
        answer[0] = 1;
        answer[1] = 1;
        for(int i=2; i<count; i++) {
            answer[i] = answer[i-2] + answer[i-1];
        }
        return answer;
    }

    // 손코딩
    public void solution2(int n) {
        int a=1, b=1, c;
        System.out.println(a+" "+b+" ");
        for(int i=2; i<n; i++) {
            c=a+b;
            System.out.println(c+ " ");
            a = b;
            b = c;
        }
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] result = T.solution(count);
        for (int s : result) {
            System.out.print(s + " ");
        }
    }

}
