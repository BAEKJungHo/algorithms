package inflearn.array.rockpaperscissors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * # 가위바위보
 *
 * A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
 * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
 *
 * 입력
 * 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
 * 두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
 * 세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
 *
 * 출력
 * 각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
 *
 * 예시 입력 1
 * 5
 * 2 3 3 1 3
 * 1 1 2 2 3
 *
 * 예시 출력 1
 * A
 * B
 * A
 * B
 * D
 */
public class Main {

    public List<String> solution(int[] a, int[] b) {
        List<String> result = new ArrayList<>();
        for(int i=0; i<a.length; i++) {
            if(a[i] == b[i]) {
                result.add("D");
            } else if(a[i] == 1) {
                if(b[i] == 2) {
                    result.add("B");
                } else {
                    result.add("A");
                }
            } else if(a[i] == 2) {
                if(b[i] == 3) {
                    result.add("B");
                } else {
                    result.add("A");
                }
            } else if(a[i] == 3) {
                if(b[i] == 1) {
                    result.add("B");
                } else {
                    result.add("A");
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] a = new int[count];
        int[] b = new int[count];
        for(int i=0; i<count; i++) {
            a[i] = sc.nextInt();
        }
        for(int i=0; i<count; i++) {
            b[i] = sc.nextInt();
        }

        List<String> result = T.solution(a, b);
        for(String s : result) {
            System.out.println(s);
        }

    }

}
