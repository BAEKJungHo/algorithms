package thisiscodingtest.chapter3.changeMoney;

// 거스름돈 : Greedy
// 가장 큰 화폐 단위부터 돈을 거슬러 준다.
public class Solution {

    private static final int[] COIN_TYPES = new int[]{500, 100, 50, 10};

    public static void main(String[] args) {
        int change = 1260;
        int count = 0;

        for (int i=0; i<4; i++) {
            int coin = COIN_TYPES[i];
            count += change / coin;
            change %= coin;
        }

        System.out.println(count);
    }

}
