package inflearn.stack.ironstick;

import java.util.Scanner;
import java.util.Stack;

/**
 * # 쇠막대기
 *
 * 예시 입력 1
 * ()(((()())(())()))(())
 *
 * 예시 출력 1
 * 17
 *
 * 예시 입력 2
 * (((()(()()))(())()))(()())
 *
 * 예시 출력 2
 * 24
 */
public class Main {

    // 여는 괄호를 만나면 스택에 넣는다.
    // 닫는 괄호를 만나면 레이저의 여는 괄호 하나를 POP 한다.
        // 그리고 바로 앞 인덱스를 확인해서 여는 괄호이면 '레이저' 이다.
        // 만약 바로 앞 인덱스가 닫는 괄호이면 막대기의 끝을 의미한다.
            // 막대기의 끝 한 조각을 더한다.
    public int solution(String str){
        int cnt = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='(') stack.push('(');
            else {
                stack.pop();
                if(str.charAt(i-1)=='(') cnt+=stack.size(); // 레이저 인 경우, stack.size() 는 레이저로 잘린 조각을 의미한다.
                else cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}