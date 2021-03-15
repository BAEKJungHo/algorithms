package programmers.level1.crainclawmachinegame.after;

import java.util.Stack;

public class Solution {

    // 0행 : 1열 2열 3열 4열 5열 ...
    // 1행
    // 2행
    // ...
    // 0,1 -> 맨위 1열을 뽑는다.
    // 열의 값은 moves 배열의 원소값이다.
    // 배열은 index 가 0부터 시작하므로 moves[i]-1 (원소값 -1)
    // 뽑은애의 값이 0인지 아닌지 판단하고 0이 아니면 Stack 에 넣는다. (처음에 스택은 비어있으므로 비어있는 경우 넣어주는 코드 필요)
    // 비어있지 않으면 stack 맨위 값이랑 넣어줘야할 값이랑 동일한지 확인
    // 동일하다면 stack 에 저장되어있던애를 꺼내서 없애고
    // 넣어줘야하는 애의 값을 0으로 바꾼다.
    // 이 과정이 끝나면 break 해서 불필요한 반복문을 돌리지 않는다.

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<moves.length; i++) {
            for(int k=0; k<board.length; k++) {
                if(board[k][moves[i]-1] != 0) {
                    if(stack.isEmpty()) {
                        stack.push(board[k][moves[i]-1]);
                    } else {
                        if(stack.peek() == board[k][moves[i]-1]) {
                            stack.pop();
                            answer += 2;
                        } else {
                            stack.push(board[k][moves[i]-1]);
                        }
                    }
                    board[k][moves[i]-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }

}
