package programmers.level1.crainclawmachinegame.before;

import java.util.Stack;

public class Solution {

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

    /*
    public void initBoard(int[][] board) {
        if(board.length < 1 || board.length > 1000) {
            throw new IllegalArgumentException("board 배열의 크기는 1이상 1000이하만 가능합니다.");
        }

        final boolean isOverBoardMatrixSize = board.length > 30 && board[0].length > 30;
        final boolean isUnderBoardMatrixSize = board.length < 5 && board[0].length < 5;

        if(isOverBoardMatrixSize || isUnderBoardMatrixSize) {
            throw new IllegalArgumentException("board 배열의 크기는 5x5 이상 30x30 이하만 가능합니다.");
        }

        this.board = board;
    }

    public void initMoves(int[] moves) {
        if(moves.length < 1 || moves.length > 1000) {
            throw new IllegalArgumentException("moves 배열의 크기는 1이상 1000이하만 가능합니다.");
        }
        for(int element : moves) {
            if(element > board.length) {
                throw new IllegalArgumentException("moves 배열의 원소 크기는 board 배열의 행 크기보다 클 수 없습니다.");
            }
        }
        this.moves = moves;
    }
*/
}
