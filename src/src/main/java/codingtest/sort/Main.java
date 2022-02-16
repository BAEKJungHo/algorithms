package codingtest.sort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        int[][] arr = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] arr = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        solution(arr);
    }

    public static int[][] solution(int[][] L) {
        Arrays.sort(L, (o1, o2) -> {
            if(o1[0] + o1[1] == o2[0] + o2[1]) {
                return o1[1] - o2[1];
            } else {
                return (o1[0] + o1[1]) - (o2[0] + o2[1]);
            }
        });

        for (int i = 1; i < L.length; i++) {
            int count = 0;
            for (int k = i - 1; k >= 0; k--) {
                if(L[i][0] <= L[k][0]) {
                    count++;
                }
            }

            // people 이 count 보다 작으면 자기 바로 앞에 있는 애랑 자리 교체
            int tempNum;
            int tempPeople;
            if(L[i][1] < count) {
                tempNum = L[i][0];
                tempPeople = L[i][1];
                L[i][0] = L[i-1][0];
                L[i][1] = L[i-1][1];
                L[i-1][0] = tempNum;
                L[i-1][1] = tempPeople;
            }
        }

        return L;
    }
}
