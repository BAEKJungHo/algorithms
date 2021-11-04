package inflearn.string.compactstring;

import java.util.Scanner;

/**
 * # 문자열 압축
 *
 * 설명
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 * 단 반복횟수가 1인 경우 생략합니다.
 *
 * 입력
 * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 *
 * 출력
 * 첫 줄에 압축된 문자열을 출력한다.
 *
 * 예시 입력 1
 * KKHSSSSSSSE
 *
 * 예시 출력 1
 * K2HS7E
 *
 * 예시 입력 2
 * KSTTTSEEKFKKKDJJGG
 *
 * 예시 출력 2
 * KST3SE2KFK3DJ2G2
 */
public class Main {

    // 1. 첫 번째 단어를 tmp 에 넣는다.
    // 2. 두 번째 인덱스부터 첫 번째 단어랑 비교하고, 같으면 count 증가, 다르면 tmp 랑 count 값을 concat
    public String solution(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char tmp = s.charAt(0);
        int duplicatedCount = 1;
        for(int i=1; i<s.length(); i++) {
            if(tmp == s.charAt(i)) {
                duplicatedCount++;
                if(i==s.length()-1) {
                    stringBuilder.append(tmp);
                    stringBuilder.append(duplicatedCount);
                }
            } else {
                stringBuilder.append(tmp);
                if(duplicatedCount > 1) {
                    stringBuilder.append(duplicatedCount);
                }
                tmp = s.charAt(i);
                duplicatedCount = 1;
            }
        }
        return stringBuilder.toString();
    }

    // i 번째랑 i+1 번째의 문자를 비교한다.

    public String solution2(String s){
        String answer="";
        s=s+" ";
        int cnt=1;
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)==s.charAt(i+1)) cnt++;
            else{
                answer+=s.charAt(i);
                if(cnt>1) answer+=String.valueOf(cnt);
                cnt=1;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(T.solution(s));
    }


}
