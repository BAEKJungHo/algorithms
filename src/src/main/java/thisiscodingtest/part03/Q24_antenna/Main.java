package thisiscodingtest.part03.Q24_antenna;

import java.util.Arrays;
import java.util.Scanner;

/*
안테나로부터 모든 집까지의 거리의 총합이 최소
안테나는 집이 위치한 곳에만 설치 가능
안테나를 설치할 위치를 선택

1 5 7 9
18 10 10 18

1 3 5 7 9
1과 9는 같고
3과 7은 같고
5가 제일 작고

중간값들 중 왼쪽에 있는 값이 가장 작음
 */
public class Main {

    static int N;
    static int[] houses;

    public static void main(String[] args) {
        solution();
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = sc.nextInt();
        }

        Arrays.sort(houses);
        System.out.println(houses[(houses.length - 1) / 2]);
    }
}
