package thisiscodingtest.chapter6.toptodown;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 위에서 아래로 : 내림차순 정렬
public class Main {

    // input data : 알고리즘 풀 때, 대체적으로 입력데이터들을 static 으로 선언해서 사용하는듯
    private static int n;
    private static Integer[] arr;

    public static void main(String[] args) {
        initializeInputData();
        descendingSort();
        printData();
    }

    // 입력값 받아서 데이터 초기화
    private static void initializeInputData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    // 내림 차순 정렬
    private static void descendingSort() {
        Arrays.sort(arr, Collections.reverseOrder());
    }

    // 데이터 출력
    private static void printData() {
        for(int element : arr) {
            System.out.print(element +" ");
        }
    }
}
