package inflearn.array.eratosthenes;

import java.util.Scanner;

/**
 * # 소수(에라토스테네스 체)
 * 1과 자기 자신만으로 나누어 떨어지는 1보다 큰 양의 정수.
 *
 * 설명
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
 *
 * 입력
 * 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
 *
 * 출력
 * 첫 줄에 소수의 개수를 출력합니다.
 *
 * 예시 입력 1
 * 20
 *
 * 예시 출력 1
 * 8
 */
public class Main {

    public int solution(int number) {
        int cnt = 0;
        int[] ch = new int[number+1];
        for(int i=2; i<=number; i++) {
            if(ch[i] == 0) {
                cnt++;
                for(int k=i; k<=number; k=k+i) { // 자기 배수에 해당하는 배열 부분들을 1 로 업데이트(즉, 소수가 아닌 부분은 1로 업데이트)
                    ch[k] = 1;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(T.solution(number));
    }

}
