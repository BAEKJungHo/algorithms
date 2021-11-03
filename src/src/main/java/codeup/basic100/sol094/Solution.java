package codeup.basic100.sol094;

import java.util.Scanner;

// 1096
public class Solution {

    public static final int WHITE_STONE_VALUE = 1;
    public static final int GREED_PATTERN_SIZE = 20;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int whiteStoneCount = sc.nextInt();

        int[][] greedPattern = new int[GREED_PATTERN_SIZE][GREED_PATTERN_SIZE];

        while(whiteStoneCount > 0) {
            int x = sc.nextInt();
            int y= sc.nextInt();

            if(x == 0 || y == 0 || x > GREED_PATTERN_SIZE-1 || y > GREED_PATTERN_SIZE -1) {
                System.out.println("x, y 는 1 <= x,y <= 19 사이어야 합니다.");
                continue;
            }

            if(greedPattern[x][y] == WHITE_STONE_VALUE) {
                System.out.println("같은 좌표는 입력될 수 없습니다.");
                continue;
            }

            greedPattern[x][y] = WHITE_STONE_VALUE;
            whiteStoneCount--;
        }

        for(int x=1; x<GREED_PATTERN_SIZE; x++) {
            for(int y=1; y<GREED_PATTERN_SIZE; y++) {
                System.out.print(greedPattern[x][y]);
            }
            System.out.println();
        }
    }

}
