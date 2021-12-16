package thisiscodingtest.part02.chapter4.time;

import java.util.Scanner;

// 시각 : 완전 탐색 -> 데이터 개수가 100만 개 이하일 때 사용하면 적절하다.
public class Main {

    public static boolean validate(int h, int m, int s) {
        if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3) {
            return true;
        }
        return false;
    }

    // 3이 포함된거 찾기 -> 시분초를 10으로 나누었을때 몫이 3이거나 나머지가 3
    public int solution(int n) {
        int answer = 0;
        for(int i=0; i<=n; i++) {
            for(int k=0; k<60; k++) {
                for(int p=0; p<60; p++) {
                    if(validate(i, k, p)) {
                       answer++;
                    }
                }
            }
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
