package thisiscodingtest.chapter6.swapelementsintwoarrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 두 배열의 원소 교체
public class Main {

    private static int n;
    private static int k;
    private static Integer[] firstArray;
    private static Integer[] secondArray;

    public static void main(String[] args) {
        initializeInputData();
        ascendingSort(firstArray);
        descendingSort(secondArray);
        swap();
        printData();
    }

    private static void initializeInputData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        firstArray = new Integer[n];
        secondArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            firstArray[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            secondArray[i] = sc.nextInt();
        }
    }

    private static void ascendingSort(Integer[] arr) {
        Arrays.sort(arr);
    }

    private static void descendingSort(Integer[] arr) {
        // Collections.reverseOrder() 쓰려면 첫 번째 매개변수로 객체 타입의 배열을 넘겨야함
        Arrays.sort(arr, Collections.reverseOrder());
    }

    private static void swap() {
        for (int i = 0; i < k; i++) {
            firstArray[i] = secondArray[i];
        }
    }

    private static void printData() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += firstArray[i];
        }
        System.out.println(sum);
    }

}
