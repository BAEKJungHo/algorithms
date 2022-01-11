package thisiscodingtest.part03.Q34_placingsoldiers;

import java.util.*;

// O(NlogN)
public class OtherSolution {

    static int N;
    static int[] dp;
    static int answer;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        input();
        solution();
        System.out.println(getAnswer());
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
    }

    static void solution() {
        dp = new int[list.size()];

        Collections.reverse(list);

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = list.get(0);

        int dpIndexByLastUpdated = 0;
        for (int i = 1; i < list.size(); i++) {
            int next = list.get(i);
            int lastValueInDp = dp[dpIndexByLastUpdated];
            if(lastValueInDp < next) {
                dp[++dpIndexByLastUpdated] = next;
            } else {
                int findIndex = binarySearch(0, dpIndexByLastUpdated, next);
                dp[findIndex] = next;
            }
        }
    }

    /**
     * 이진 탐색을 통해서 next 가 dp 의 어느 index 에 들어가야하는지, 알맞은 index 를 찾는다.
     * @param start 0
     * @param end dpIndexByLastUpdated
     * @param target 비교 대상인 다음 값(next)
     */
    static int binarySearch(int start, int end, int target) {
        int index = 0;
        while(start <= end) {
            int middle = (start + end) / 2;

            if(dp[middle] >= target) {
                end = middle - 1;
                index = middle;
            }
            else{
                start = middle + 1;
            }
        }
        return index;
    }

    /**
     * dp 에 Integer.MAX_VALUE 가 아닌 값들에 대해서 개수를 카운트한다.
     */
    static int getAnswer() {
        int count = 0;
        for(int i = 0; i < dp.length; i++) {
            if(dp[i] == Integer.MAX_VALUE) {
                break;
            }
            count++;
        }
        answer = N - count;
        return answer;
    }
}
