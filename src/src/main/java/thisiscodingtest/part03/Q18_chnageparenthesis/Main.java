package thisiscodingtest.part03.Q18_chnageparenthesis;

import java.util.Scanner;

// 괄호 변환
public class Main {

    private static final Character OPEN_PARENTHESIS = '(';
    private static final Character CLOSE_PARENTHESIS = ')';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String p = sc.nextLine();

        // step 1. 만약 올바른 문자열이면 그대로 리턴
        if (isCorrect(p)) {
            System.out.println(p);
        } else {
            System.out.println(solution(p));
        }
    }

    /**
     * @param p 원본 입력 문자열(= 부모 문자열)
     */
    private static String solution(String p) {
        String correctedParenthesis = "";

        // step 1. 빈 문자열을 반환
        if("".equals(p)) {
            return correctedParenthesis;
        }

        // step 2. p 문자열을 u, v 로 분리
        int index = findIndexForSeparate(p);
        String u = p.substring(0, index);
        String v = p.substring(index);

        // step 3. u 가 올바른 괄호 문자열이면 v 에 대해서 1단계 부터 다시 수행(solution(child.getV())), 수행한 결과 문자열을 u에 이어 붙인 후 반환
        if(isCorrect(u)) {
            correctedParenthesis += u + solution(v);
        }
        // step 4. u 가 올바른 괄호 문자열이 아니면, 문자열을 재조립하여 올바른 문자열 생성
        else {
            correctedParenthesis = OPEN_PARENTHESIS +
                    solution(v) +
                    CLOSE_PARENTHESIS +
                    reverse(findUByRemoveFrontAndRear(u));
        }
        return correctedParenthesis;
    }

    // 문자열을 분리하기 위한 인덱스 조회 : 맨처음 발견되는 균형잡힌 문자열의 마지막 인덱스를 반환
    private static int findIndexForSeparate(String s) {
        int index = 0;
        int open = 0;
        int close = 0;
        while(index < s.length()) {
            if(OPEN_PARENTHESIS.equals(s.charAt(index))) {
                open++;
            } else {
                close++;
            }
            if(open == close) {
                break;
            }
            index++;
        }
        return index + 1;
    }

    // 올바른 문자열인지
    private static boolean isCorrect(String s) {
        int index = 0;
        int count = 0;
        while(index < s.length()) {
            if(OPEN_PARENTHESIS.equals(s.charAt(index))) {
                count++;
            } else {
                count--;
                if(count == -1) {
                    return false;
                }
            }
            index++;
        }
        return true;
    }

    // 문자열 U 의 앞과 뒤 제거
    private static String findUByRemoveFrontAndRear(String u) {
        return u.substring(1, u.length() - 1);
    }

    // 문자열 뒤집기
    private static String reverse(String u) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < u.length(); i++) {
            if(OPEN_PARENTHESIS.equals(u.charAt(i))) {
                builder.append(CLOSE_PARENTHESIS);
            } else {
                builder.append(OPEN_PARENTHESIS);
            }
        }
        return builder.toString();
    }
}
