package inflearn.sorting.lru;

import java.util.Scanner;

/**
 * # LRU 알고리즘(캐시, 카카오 변형) : 삽입정렬
 *
 * 설명
 * 캐시메모리는 CPU 와 주기억장치(DRAM) 사이의 고속의 임시 메모리로서 CPU 가 처리할 작업을 저장해 놓았다가
 * 필요할 바로 사용해서 처리속도를 높이는 장치이다. 워낙 비싸고 용량이 작아 효율적으로 사용해야 한다.
 * 철수의 컴퓨터는 캐시메모리 사용 규칙이 LRU 알고리즘을 따른다.
 * LRU 알고리즘은 Least Recently Used 의 약자로 직역하자면 가장 최근에 사용되지 않은 것 정도의 의미를 가지고 있습니다.
 * 캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하겠다는 알고리즘입니다.
 */
public class Main {

    // 삽입정렬 응용 문제 -> list.set(2, 5) 이런식으로 할 순있지만 직접 구현하는게 더 좋음
    // 손 코딩으로도 나올 수 있는 문제
    public int[] solution(int cacheSize, int[] arr) {
        int[] cache = new int[cacheSize];
        for(int x : arr) { // 작업 번호 반복
            int position = -1;
            for(int i=0; i<cacheSize; i++) {
                if (x == cache[i]) { // 작업 번호가 cache 안에 있는 경우
                    position = i; // 해당 인덱스를 설정
                }
            }
            if(isCacheMiss(position)) { // cache miss -> 새로들어갈원소의 맨 앞 인덱스 0 을 제외하고 값을 한 칸씩 뒤로 이동
                for(int i=cacheSize-1; i>=1; i--) {
                    cache[i] = cache[i-1];
                }
            } else { // cache hit
                for(int i=position; i>=1; i--) { // 설정된 인덱스 부터 맨 앞 인덱스 0 을 제외하고 값을 한 칸씩 뒤로 이동
                    cache[i] = cache[i-1];
                }
            }
            cache[0] = x; // 현재 작업 번호는 항상 맨 앞에 삽입
        }
        return cache;
    }

    private boolean isCacheMiss(int position) {
        return position == -1;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int cacheSize = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x : T.solution(cacheSize, arr)) System.out.print(x+" ");
    }

}
