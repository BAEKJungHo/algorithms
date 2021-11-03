package inflearn.string.duplicatedwordsremove;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * # 중복 문자 제거
 *
 * 설명
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
 * 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 *
 *
 * 입력
 * 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
 *
 * 출력
 * 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
 *
 * 예시 입력 1
 * ksekkset
 *
 * 예시 출력 1
 * kset
 */
public class Main {

    // 이중 for 문
    public String solution(String str) {
        char[] chars = str.toCharArray();
        for(int i=0; i<chars.length-1; i++) {
            for(int k=i+1; k<chars.length; k++) {
                if(chars[i] == chars[k]) {
                    chars[k] = '+';
                }
            }
        }
        return String.valueOf(chars).replace("+", "");
    }

    // indexOf : 처음 발견되는 문자열 위치를 반환
    public String solution2(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            if(str.indexOf(str.charAt(i)) == i) {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution2(str));
    }

}
