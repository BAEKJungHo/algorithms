package inflearn.string.palindrome;

import java.util.Scanner;

/**
 * # 회문 문자열 : palindrome
 *
 * 설명
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
 * 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 * 단, 회문을 검사할 때 대소문자를 구분하지 않습니다.
 *
 * 입력
 * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
 *
 * 출력
 * 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
 *
 *
 * 예시 입력 1
 * gooG
 *
 * 예시 출력 1
 * YES
 */
public class Main {

    // StringBuilder 의 reverse 이용
    public String solution(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        String reversedStr = stringBuilder.reverse().toString();

        if(str.equalsIgnoreCase(reversedStr)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    // String 의 charAt(), i < len/2 : 홀수, 짝수 다 해당 됨
    public String solution2(String str) {
        int len = str.length();
        for(int i=0; i<len/2; i++) {
            if(str.charAt(i) != str.charAt(len-i-1)) {
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }

}
