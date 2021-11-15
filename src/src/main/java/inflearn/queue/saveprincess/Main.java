package inflearn.queue.saveprincess;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * # 공주 구하기
 *
 * Tip 공주 구하기 처럼 원형으로 이루어져있고 index 가 다시 처음부터 반복되는 경우에는 Queue 문제일 수 있음.
 *
 * 입력
 * 첫 줄에 자연수 N(5<=N<=1,000)과 K(2<=K<=9)가 주어진다.
 *
 * 출력
 * 첫 줄에 마지막 남은 왕자의 번호를 출력합니다.
 *
 * 예시 입력 1
 * 8 3
 *
 * 예시 출력 1
 * 7
 */
public class Main {

    public int solution(int n, int k){
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            Q.offer(i);
        }

        while(!Q.isEmpty()) {
            for(int i=1; i<k; i++) { // 제거 대상 전 까지
                Q.offer(Q.poll()); // k 가 3이면 1, 2를 뽑아서 없앤 후, 다시 끝에 붙여 넣는다. -> 34567812
            }
            Q.poll(); // 맨 앞하나를 꺼낸다. (i == k) 34567812 -> 4567812
            if(Q.size()==1) answer = Q.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(T.solution(n, k));
    }

}
