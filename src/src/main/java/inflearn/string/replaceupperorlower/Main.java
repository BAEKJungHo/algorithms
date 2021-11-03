package inflearn.string.replaceupperorlower;

import java.util.Scanner;

/**
 * # 대소문자 변환
 *
 * 설명
 *
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
 *
 * 문자열은 영어 알파벳으로만 구성되어 있습니다.
 *
 *
 * 출력
 * 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
 *
 * 예시입력
 * Study
 *
 * 예시출력
 * sTUDY
 */
public class Main {

    public String solution(String str) {
        // StringBuilder 는 동기화 지원 X
        // 단일 스레드인 경우에는 StringBuffer 보다 성능이 뛰어남, StringBuffer 는 멀티스레드 환경에서 안정적.
        StringBuilder stringBuilder = new StringBuilder();
        char[] words = str.toCharArray();
        for (char word : words) {
            if(Character.isUpperCase(word)) {
                word = Character.toLowerCase(word);
            } else {
                word = Character.toUpperCase(word);
            }
            stringBuilder.append(word);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }

}
