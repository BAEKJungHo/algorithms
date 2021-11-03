package inflearn.string.reversewords;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * # 단어 뒤집기
 *
 * 설명
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
 * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
 *
 * 출력
 * N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
 *
 * 예시 입력 1
 * 3
 * good
 * Time
 * Big
 *
 * 예시 출력 1
 * doog
 * emiT
 * giB
 */
public class Main {

    public List<String> solution(String[] words) {
        List<String> answer = new ArrayList<>();

        /* StringBuilder 이용
        for (String word : words) {
            String tmp = new StringBuilder(word).reverse().toString();
            answer.add(tmp);
        }
        */

        /**
         * 아래의 문제는 손 코딩으로도 낼 만한 문제임.
         *
         * study -> 가운데(u)를 기준으로 lt(s,t) rt(d,y) 끼리 변경하기
         * lt == rt 이면 다 바뀐 것
         * good -> 무조건 lt < rt 밖에 없음
         */
        for(String word : words) {
            char[] s = word.toCharArray();
            int lt = 0;
            int rt = word.length()-1;
            while(lt < rt) {
                // 교환 코드
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int inputCount = sc.nextInt();
        String[] words = new String[inputCount];
        for(int i=0; i<inputCount; i++) {
            words[i] = sc.next();
        }

        List<String> reversedWords = T.solution(words);
        for (String reversedWord : reversedWords) {
            System.out.println(reversedWord);
        }
    }

}
