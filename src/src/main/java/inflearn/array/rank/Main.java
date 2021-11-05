package inflearn.array.rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * # 등수 구하기
 *
 * 설명
 * N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
 * 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
 * 즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
 *
 * 입력
 * 첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.
 *
 * 출력
 * 입력된 순서대로 등수를 출력한다.
 *
 * 예시 입력 1
 * 5
 * 87 89 92 100 76
 *
 * 예시 출력 1
 * 4 3 2 1 5
 */
public class Main {

    // 같거나 자기가 점수가 크면 순위 1 유지
    // 자기 점수가 더 낮으면 순위 + 1
    public List<Integer> solution(int[] scores) {
        List<Integer> answer = new ArrayList<>();
        int rank = 1;
        for(int i=0; i<scores.length; i++) {
            for(int k=0; k<scores.length; k++) {
                if(scores[i] < scores[k]) {
                   rank++;
                }
            }
            answer.add(rank);
            rank = 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] scores = new int[count];
        for(int i = 0; i < count; i++) {
            scores[i] = sc.nextInt();
        }
        List<Integer> result = T.solution(scores);
        for (Integer rank : result) {
            System.out.print(rank + " ");
        }
    }

}
