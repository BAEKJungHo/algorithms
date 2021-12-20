package thisiscodingtest.part03.Q04_cantmakemoney;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {

    public static int n;
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arrayList.add(sc.nextInt());
        }

        Collections.sort(arrayList);

        /**
         * Case. 1 1 2 3 9
         * 1 1 2 까지 계산한 경우에 4까지는 만들 수 있는 숫자
         * 4까지는 만들 수 있으니까 +1 한 값(5)은 만들 수 없는 최솟값이 된다.
         * sum = 4 인상태에서 다음 반복문 돌면 3인데, 3은 이미 만들 수 있는 숫자니까 계산하고
         * 7 + 1한 값(만들 수 없는)은 9보다 작으니까 7 + 1한 값이 만들 수 없는 최솟값이 된다.
         */
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // sum = 현재 값을 다 더한 값
            // 만들 수 없는 최솟값 = 현재 값을 다 더한 값 + 1
            if (sum + 1 < arrayList.get(i)) break;
            sum += arrayList.get(i); // 1 1 2(4) -> + 1 3 9
        }

        System.out.println(sum + 1);
    }
}