package boj.string.Q_1254;

public class Main {

    public int solution(String plain) {
        int answer = plain.length();

        for (int i = 0; i < plain.length(); i++) {
            // 문자열을 앞에서부터 자른후에 팔린드롬인지 확인
            // abab 에서 a 를 자른 bab 가 팔린드롬이면 뒤에 a 만 붙여주면 팔린드롬을 만들 수 있음
            if (isPalindrome(plain.substring(i))) {
                return answer + i;
            }
        }

        return answer * 2 - 1;
    }

    static boolean isPalindrome(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            // 처음과 끝을 비교
            if(str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
