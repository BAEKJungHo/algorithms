package jungho.thisiscodingtest.part03.Q26_cardsort;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    private static int N;
    private static PriorityQueue<Integer> pQ = new PriorityQueue<>();

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            pQ.add(sc.nextInt());
        }
    }

    private static void solution() {
        int sum = 0;
        while(pQ.size() > 1) {
            int x = pQ.poll();
            int y = pQ.poll();
            sum += (x + y);
            pQ.add(x + y);
        }
        System.out.println(sum);
    }
}
