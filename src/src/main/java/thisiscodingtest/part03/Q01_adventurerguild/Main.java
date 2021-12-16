package thisiscodingtest.part03.Q01_adventurerguild;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int N;
    private static int[] fear;
    private static int group;

    public static void main(String[] args) {
        input();
        greedy();
        System.out.println(group);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        fear = new int[N];

        for (int i = 0; i < N; i++) {
            fear[i] = sc.nextInt();
        }
    }

    private static void greedy() {
        Arrays.sort(fear);
        int adventurer = 0;
        for (int i = 0; i < N; i++) {
            adventurer++;
            if(adventurer >= fear[i]) {
                group++;
                adventurer = 0;
            }
        }
    }
}
