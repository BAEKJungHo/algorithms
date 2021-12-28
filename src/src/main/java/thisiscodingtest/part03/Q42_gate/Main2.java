package thisiscodingtest.part03.Q42_gate;

import java.util.Scanner;

// 탑승구 : 서로소, Union-Find 활용
public class Main2 {

    private static int G; // 탑승구의 수
    private static int P; // 비행기의 수
    private static int parents[]; // 부모 테이블
    private static int count = 0; // 도킹된 최대 개수

    public static void main(String[] args) {
        solution();
        System.out.println(count);
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        G = sc.nextInt();
        parents = new int[G + 1];

        // 부모 테이블 자기 자신으로 초기화
        for (int i = 1; i <= G; i++) {
            parents[i] = i;
        }

        // Union-Find
        P = sc.nextInt();
        for (int i = 0; i < P; i++) {
            int x = sc.nextInt();
            int parent = findParent(x);
            if (parent == 0) {
                break;
            }
            unionParent(parent, parent - 1);
            count++;
        }
    }

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parents[x]) return x; // 처음에 자기 자신으로 초기화 되었으면 그대로 반환
        return parents[x] = findParent(parents[x]); // 재귀 호출 결과를 부모 테이블에 갱신
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }
}

/*
5
6
4
4
4
4
5
5

result : 5
 */

/*
5 -> G
6 -> P

-- 자신의 root 값이 변했다는 것은 도킹되었다는 것

4 -> 처음에 4에 매칭이 되기 때문에 4,3 에 대해서 union 연산 수행 -> 4의 root 가 3으로 변경

현재 상태 : 0 1 2 3<-4 5

4 -> findParent(4) 의 값은 현재 3이기 때문에 3,2 에 대해서 union 연산 수행 -> 3의 root 가 2로 변경

현재 상태 : 0 1 2<-3<-4 5

4 -> findParent(4) 의 값은 현재 2이기 때문에 2,1 에 대해서 union 연산 수행 -> 2의 root 가 1로 변경

현재 상태 : 0 1<-2<-3<-4 5

4 -> findParent(4) 의 값은 현재 1이기 때문에 1,0 에 대해서 union 연산 수행 -> 1의 root 가 0으로 변경

현재 상태 : 0<-1<-2<-3<-4 5

5 -> findParent(5) 의 값은 현재 5이기 때문에 5,4 에 대해서 union 연산 수행 -> 5의 root 가 0으로 변경

현재 상태 : 0<-1<-2<-3<-4 5

5 -> findParent(5) 의 값은 현재 0이므로 더이상 도킹 불가능해서 운행 종료

result : 5
 */