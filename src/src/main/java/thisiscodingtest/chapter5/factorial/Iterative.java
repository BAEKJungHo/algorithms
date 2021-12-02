package thisiscodingtest.chapter5.factorial;

import java.util.Scanner;

// 반복문을 사용한 팩토리얼 구현
public class Iterative {

    // n!
    // n == 1 || n == 0 ? factorial(n) = 1 : factorial(n) = n * factorial(n-1)
    public int solution(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        int answer = 1;
        for(int i=n; i>0; i--) {
            answer *= i;
        }
        return answer;
    }

    public static void main(String[] args) {
        Iterative T = new Iterative();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }
}
