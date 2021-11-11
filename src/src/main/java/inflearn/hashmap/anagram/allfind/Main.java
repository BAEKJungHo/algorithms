package inflearn.hashmap.anagram.allfind;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * # 모든 아나그램 찾기 : Hash, Sliding Window -> O(n)
 *
 * 설명
 * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
 * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
 *
 * 입력
 * 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
 * S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
 *
 * 출력
 * S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
 *
 * 예시 입력 1
 * bacaAacba
 * abc
 *
 * 예시 출력 1
 * 3
 *
 * 힌트
 * 출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.
 */
public class Main {

    // 문자열 t 를 문자 배열로 만든다.
    // map 에 t 의 문자들을 담는다.
    // 문자열 s 를 문자 배열로 만든다.
    // 문자열 t 의 길이만큼 map2에 담는다.
    // sliding window 를 사용하여 비교한다.
    public int solution(String s, String t) {
        int answer = 0;

        char[] arr1 = t.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        for(int i=0; i<arr1.length; i++) {
            map1.put(arr1[i], map1.getOrDefault(arr1[i], 0) + 1);
        }

        char[] arr2 = s.toCharArray();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<t.length(); i++) {
            map2.put(arr2[i], map2.getOrDefault(arr2[i], 0) + 1);
        }

        if(map1.equals(map2)) {
            answer++;
        }

        // sliding window : rt lt  같이 증가
        int lt = 0;
        for(int rt=t.length(); rt<s.length(); rt++) {
            map2.put(arr2[rt], map2.getOrDefault(arr2[rt], 0) + 1); // arr[rt] 가 map 에 값이 있으면 value 증가
            map2.put(arr2[lt], map2.getOrDefault(arr2[lt], 0) - 1); // arr[lt] 가 map 에 값이 있으면 value 감소
            if(map2.get(arr2[lt]) == 0) { // arr[lt] 에 대한 value 가 0 이면 원소 제거
                map2.remove(arr2[lt]);
            }
            lt++;
            if(map1.equals(map2)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(T.solution(s, t));
    }

}
