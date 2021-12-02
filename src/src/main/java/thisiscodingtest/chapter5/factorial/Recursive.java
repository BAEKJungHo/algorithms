package thisiscodingtest.chapter5.factorial;

import java.util.Scanner;

public class Recursive {

     public int solution(int n) {
        System.out.println(Thread.currentThread().getName()); // 현재 실행중인 스레드 판단
        return n <= 1 ? 1 : n * solution(n-1);
    }

    public static void main(String[] args) {
        Recursive T = new Recursive();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }

}
