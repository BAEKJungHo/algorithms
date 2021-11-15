package inflearn.stack.postfix;

import java.util.*;

/**
 * 후위식 연산(postfix)
 *
 * 설명
 * 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
 * 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
 *
 * 입력
 * 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
 * 식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
 *
 * 출력
 * 연산한 결과를 출력합니다.
 *
 * 예시 입력 1
 * 352+*9-
 *
 * 예시 출력 1
 * 12
 */
public class Main {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String DIVIDE = "/";
    private static final String MULTIPLY = "*";

    // 1. 피연산자(숫자)를 만나면 STACK 에 PUSH
    // 2. 연산자를 만나면 STACK 에서 POP (연산 식이 될 때 까지)
            // 연산식은 피연산자가 2개 필요
    // 3. 연산 결과를 다시 STACK 에 PUSH
    public int solution(String postfix) {
        Stack<Integer> stack = new Stack<>();
        for(String x : postfix.split("")) {
            if(PLUS.equals(x)) {
                stack.push(stack.pop() + stack.pop());
            } else if(MINUS.equals(x)) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second - first);
            } else if(DIVIDE.equals(x)) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second / first);
            } else if(MULTIPLY.equals(x)) {
                stack.push(stack.pop() * stack.pop());
            } else {
                stack.push(Integer.parseInt(x));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String postfix = sc.nextLine();
        System.out.println(T.solution(postfix));
    }
}
