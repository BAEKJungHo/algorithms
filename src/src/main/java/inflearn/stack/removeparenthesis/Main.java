package inflearn.stack.removeparenthesis;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * # 괄호 문자 제거
 *
 * 설명
 * 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 *
 * 출력
 * 남은 문자만 출력한다.
 *
 * 예시 입력 1
 * (A(BC)D)EF(G(H)(IJ)K)LM(N)
 *
 * 예시 출력 1
 * EFLM
 */
public class Main {

    private static final char OPEN = '(';
    private static final char CLOSE = ')';

    // 문자들을 넣고 닫는 괄호를 만나면, 여는 괄호까지만 제거
    public String solution(String s) {
        String answer="";
        Stack<Character> stack=new Stack<>();
        for(char x : s.toCharArray()){
            if(x == CLOSE){
                while(stack.pop() != OPEN);
            }
            else stack.push(x);
        }
        for(int i=0; i<stack.size(); i++) answer+=stack.get(i);
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(T.solution(s));
    }

}
