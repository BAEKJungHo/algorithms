package thisiscodingtest.part03.Q42_gate;

import java.util.Scanner;

// 탑승구
public class Main {

    private static int G; // 탑승구의 수
    private static int P; // 비행기의 수
    private static boolean[] dockedGates; // 도킹된 탑승구 정보
    private static int[] dockingAbleGates;
    private static int count = 0; // 도킹된 최대 개수

    public static void main(String[] args) {
        input();
        solution();
        System.out.println(count);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        G = sc.nextInt();
        dockedGates = new boolean[G + 1];

        P = sc.nextInt();
        dockingAbleGates = new int[P + 1];
        for (int i = 1; i <= P; i++) {
            dockingAbleGates[i] = sc.nextInt();
        }
    }

    private static void solution() {
        for (int i = 1; i < dockingAbleGates.length - 1; i++) {
            boolean stop = false; // 운행 중지 여부
            int dockingAbleGateNumber = dockingAbleGates[i];

            // 처음 도착한 비행기에 대해서는 가장 큰 번호로 도킹 처리
            if(i == 1) {
                dockedGates[dockingAbleGateNumber] = true;
            } else {
                // 도킹 가능한 가장 큰 번호부터 도킹 가능한지 확인
                for (int k = dockingAbleGateNumber; k > 0; k--) {
                    if(dockedGates[k]) { // 이미 도킹이 되어있는 경우
                        stop = true;
                    } else { // 도킹이 되어있지 않은 경우에는 도킹 시키고 break 문으로 탈출
                        dockedGates[k] = true;
                        stop = false;
                        break;
                    }
                }
            }
            if(stop) {
                break;
            } else {
                count++;
            }
        }
    }

}
