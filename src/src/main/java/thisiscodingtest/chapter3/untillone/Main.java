package thisiscodingtest.chapter3.untillone;

import java.util.Scanner;

// 1이 될 때까지
public class Main {

    public int solution(int n, int k) {
        int answer = 0;
        while(n > 1) {
            if(isDivisor(n, k)) {
                n /= k;
            } else {
                n--;
            }
            answer++;
        }
        return answer;
    }

    // 약수인지 판단
    public boolean isDivisor(int n, int k) {
        return n % k == 0;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(T.solution(n, k));
    }

}
