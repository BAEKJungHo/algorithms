package inflearn.sorting.insertion;

import java.util.Scanner;

/**
 * # 삽입 정렬
 *
 * 설명
 * N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
 * 정렬하는 방법은 삽입정렬입니다.
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
 * 11 7 5 6 10 9
 *
 * 예시 출력 1
 * 5 6 7 9 10 11
 */
public class Main {

    public int[] solution(int[] arr) {
        int key;

        // 인덱스 0은 이미 정렬된 것으로 볼 수 있다.
        for(int i=1; i<arr.length; i++) { // 바깥 반복문은 삽입될 숫자들에 대한 반복문 (즉, 첫 인덱스를 제외한 n-1 만큼 반복)
            key = arr[i]; // 현재 삽입될 숫자인 i번째 정수를 key 변수로 복사

            // 현재 정렬된 배열은 i-1까지이므로 i-1번째부터 역순으로 조사한다.
            // k 값은 음수가 아니어야 되고
            // key 값보다 정렬된 배열에 있는 값이 크면 k 번째를 k+1 번째로 이동
            for(int k=i-1; k>=0; k--) { // 내부 반복문은 자기 바로 앞에 존재하는 자료들과 비교
                if(arr[k] > key) {
                    key = arr[k+1];
                    arr[k+1] = arr[k];
                    arr[k] = key;
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
