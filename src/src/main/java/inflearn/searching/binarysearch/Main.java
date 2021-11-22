package inflearn.searching.binarysearch;

import java.util.*;

/**
 * # 이분 검색(Binary Search)
 *
 * 설명
 * 임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
 * 이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.
 *
 * 입력
 * 첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.
 * 두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.
 *
 * 출력
 * 첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.
 *
 * 예시 입력 1
 * 8 32
 * 23 87 65 12 57 32 99 81
 *
 * 예시 출력 1
 * 3
 */
public class Main {

    public int solution(int n, int m, List<Integer> list) {
        list.sort(Comparator.comparing(Integer::intValue));
        return list.indexOf(m)+1;
    }

    // Binary Search
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 0, rt = n-1;
        while(lt <= rt){
            int mid = (lt + rt) / 2;
            if(arr[mid] == m) {
                answer = mid + 1;
                break;
            }
            if(arr[mid] > m) rt = mid - 1; // 찾고자하는 값이 더 작은 쪽에 있다면 검색범위 큰 쪽을 아예 날린다. = mid - 1;
            else lt = mid + 1; // 찾고자하는 값이 더 큰 쪽에 있다면 검색범위 작은 쪽을 아예 날린다.
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(sc.nextInt());
        }
        System.out.println(T.solution(n, m, list));
    }


}
