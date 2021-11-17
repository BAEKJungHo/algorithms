package inflearn.sorting.selection;

import java.util.Scanner;

/**
 * # 선택 정렬
 *
 * 설명
 * N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
 * 정렬하는 방법은 선택정렬입니다.
 *
 * 입력
 * 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
 * 두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.
 *
 * 출력
 * 오름차순으로 정렬된 수열을 출력합니다.
 *
 * 예시 입력 1
 * 6
 * 13 5 11 7 23 15
 *
 * 예시 출력 1
 * 5 7 11 13 15 23
 */
public class Main {

    // 정렬 코드의 가장 큰 특징 중 하나가 교체(swap) 코드를 잘 기억해야 함
    // 선택정렬 : 최솟값을 찾아서 정렬 되지 않은 가장 앞의 인덱스랑 교체
    public int[] solution(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            int tmp = arr[i];
            for(int k=i+1; k<arr.length; k++) {
                if(tmp > arr[k]) {
                    tmp = arr[k];
                    arr[k] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int num : T.solution(arr)) {
            System.out.print(num + " ");
        }
    }

}
