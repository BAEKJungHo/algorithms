package thisiscodingtest.part03.Q25_failurerate;

/*
실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레어이어의 수 / 스테이지에 도달한 플레이어의 수
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class GameStage {

    private int stage;

    private double failureRate;

    public GameStage(int stage, double failureRate) {
        this.stage = stage;
        this.failureRate = failureRate;
    }

    public int getStage() {
        return stage;
    }

    public double getFailureRate() {
        return failureRate;
    }

    public void changeFailureRate(double failureRate) {
        this.failureRate = failureRate;
    }
}

// 실패율
public class Main {

    private static int N;
    private static int[] stages = new int[]{4, 4, 4, 4, 4};
    private static GameStage[] storages;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
    }

    private static void solution() {
        Arrays.sort(stages);
        initializeStorages(N);

        int playerCountWhoReached = stages.length;
        int playerCountWhoNotClear = 1;
        int stageNumber = stages[0];
        for (int i = 1; i < stages.length; i++) {
            if (stages[i] == stageNumber) {
                playerCountWhoNotClear++;
            } else {
                // 실패율 변경
                changeFailureRates(playerCountWhoNotClear, playerCountWhoReached, stageNumber);
                // stageNumber 값 변경
                stageNumber = stages[i];
                // 도달한 플레이어의 수 재 계산
                playerCountWhoReached -= playerCountWhoNotClear;
                // 클리어 하지 못한 플레이어의 수 초기화
                playerCountWhoNotClear = 1;
            }
            if (i == stages.length - 1 && stageNumber <= N) {
                changeFailureRates(playerCountWhoNotClear, playerCountWhoReached, stageNumber);
            }
        }

        List<GameStage> gameStages = Arrays.asList(storages);
        gameStages.sort((o1, o2) -> {
            if (o2.getFailureRate() == o1.getFailureRate()) {
                return o1.getStage() - o2.getStage();
            }
            return o2.getFailureRate() > o1.getFailureRate() ? 1 : -1;
        });

        int[] answer = new int[gameStages.size()];
        for (int i = 0; i < gameStages.size(); i++) {
            GameStage gameStage = gameStages.get(i);
            System.out.print(gameStage.getStage() + " ");
        }
    }

    /**
     * GameStage 를 저장하는 자료구조를 초기화하고, 실패율을 0으로 초기화
     *
     * @param N
     */
    private static void initializeStorages(int N) {
        storages = new GameStage[N];
        for (int i = 0; i < N; i++) {
            storages[i] = new GameStage(i + 1, 0.0);
        }
    }

    /**
     * 실패율 변경
     *
     * @param playerCountWhoNotClear 스테이지에 도달 했으나 클리어 하지 못한 플레이어의 수
     * @param playerCountWhoReached  스테이지에 도달한 플레이어의 수
     * @param stageNumber            스테이지 번호
     */
    private static void changeFailureRates(int playerCountWhoNotClear, int playerCountWhoReached, int stageNumber) {
        double failureRate = (double) playerCountWhoNotClear / (double) playerCountWhoReached;
        GameStage gameStage = storages[stageNumber - 1];
        gameStage.changeFailureRate(failureRate);
    }
}