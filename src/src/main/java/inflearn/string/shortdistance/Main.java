package inflearn.string.shortdistance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * # 가장 짧은 문자거리
 *
 * 설명
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
 * 문자열의 길이는 100을 넘지 않는다.
 *
 * 출력
 * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 *
 * 예시 입력 1
 *
 * teachermode e
 * 예시 출력 1
 *
 * 1 0 1 2 1 0 1 2 2 1 0
 */
public class Main {

    // 1. e 가 속한 index 위치들을 조사한다.
    // 2. e 를 제외한 각 단어의 index 를 조사한다.
    // 3. 각단어의 index - 각 단어랑 가깝게 위치한 e 의 index 를 뺀다.
    public List<Integer> solution(String s, char c) {
        List<Integer> answer = new ArrayList<>();

        List<Integer> indices = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == c) {
                indices.add(i);
            }
        }

        for(int i=0; i<s.length(); i++) {
            int m = Integer.MAX_VALUE;
            if(indices.contains(i)) {
                answer.add(0);
            } else {
                for (Integer index : indices) {
                    int distance = getDistance(index, i);
                    if(distance < m) {
                        m = distance;
                    }
                }
                answer.add(m);
            }
        }

        return answer;
    }

    // 1. 왼쪽으로 짧은 거리
    // 2. 오른쪽으로 짧은 거리 계산
    public int[] solution2(String s, char t){
        int[] answer=new int[s.length()];
        int p=1000;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==t){
                p=0;
                answer[i]=p;
            }
            else{
                p++;
                answer[i]=p;
            }
        }
        p=1000;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)==t) p=0;
            else{
                p++;
                answer[i]=Math.min(answer[i], p);
            }
        }
        return answer;
    }

    private int getDistance(int includeWordIndex, int excludeWordsIndex) {
        int result = includeWordIndex - excludeWordsIndex;
        return result < 0 ? result * -1 : result;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char c = sc.next().charAt(0);

        List<Integer> result = T.solution(s, c);
        for (Integer r : result) {
            System.out.print(r + " ");
        }
    }

}
