package thisiscodingtest.part03.Q05_bowlingball;

import java.util.Scanner;

class BowlingBall {

    private int number;
    private int weight;

    public BowlingBall(int number, int weight) {
        this.number = number;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}

// 볼링공 고르기
public class Main {

    private static int N;
    private static int M;
    private static int combinationCount = 0;
    private static BowlingBall[] bowlingBalls;

    public static void main(String[] args) {
        input();
        solution();
        System.out.println(combinationCount);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        bowlingBalls = new BowlingBall[N];
        for (int i = 0; i < N; i++) {
            bowlingBalls[i] = new BowlingBall(i, sc.nextInt());
        }
    }

    // O(N^2)
    private static void solution() {
        for (int i = 0; i < bowlingBalls.length; i++) {
            BowlingBall firstBall = bowlingBalls[i];
            for (int k = i + 1; k < bowlingBalls.length; k++) {
                BowlingBall secondBall = bowlingBalls[k];
                if(firstBall.getWeight() != secondBall.getWeight()) {
                    combinationCount++;
                }
            }
        }
    }
}
