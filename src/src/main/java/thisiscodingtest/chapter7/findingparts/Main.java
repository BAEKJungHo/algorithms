package thisiscodingtest.chapter7.findingparts;

import java.util.Arrays;
import java.util.Scanner;

// 부품 찾기
public class Main {

    // input data
    private static int n; // 전자 매장에서 취급하는 부품 개수 N
    private static int m; // 손님이 구매하고자하는 부품 의 종류 개수 M
    private static int[] partsInShop; // 매장에서 취급하는 부품들
    private static int[] partsForCustomer; // 손님이 구매하고자 하는 부품들

    public static void main(String[] args) {
        initializeInputData();

        // Binary search 를 하기 위한 precondition
        ascendingSort(partsInShop);

        // 부품 찾기
        for(int i = 0; i < m; i++) {
            String findResult = findParts(partsForCustomer[i]);
            System.out.print(findResult + " ");
        }
    }

    private static void initializeInputData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        partsInShop = new int[n];
        for(int i = 0; i < n; i++) {
            partsInShop[i] = sc.nextInt();
        }

        m = sc.nextInt();
        partsForCustomer = new int[m];
        for(int i = 0; i < m; i++) {
            partsForCustomer[i] = sc.nextInt();
        }
    }

    private static void ascendingSort(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 부품 찾기
     * @param target 찾고자 하는 대상
     */
    private static String findParts(int target) {
        int startPoint = 0;
        int endPoint = n - 1;

        while(startPoint <= endPoint) {
            int middlePoint = (startPoint + endPoint) / 2;
            if(partsInShop[middlePoint] == target) {
                return "yes";
            }

            if(partsInShop[middlePoint] > target) {
                endPoint = middlePoint - 1;
            } else {
                startPoint = middlePoint + 1;
            }
        }

        return "no";
    }


}
