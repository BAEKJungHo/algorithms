package inflearn.greedy.conferenceroom;

import java.util.Arrays;
import java.util.Scanner;

class Conference implements Comparable<Conference> {
    private int start;
    private int end;

    public Conference(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public int compareTo(Conference o) {
        if(this.end == o.end) {
            return this.start - o.start;
        } else {
            return this.end - o.end;
        }
    }
}

// 회의실 배정
// target 의 endtime 이랑 다음 비교대상의 starttime 이 같아야함
public class Main {

    private static int N;
    private static Conference[] conferences;

    public static void main(String[] args) {
        input();
        System.out.println(solution2());
    }

    private static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        conferences = new Conference[N];
        for (int i = 0; i < N; i++) {
            conferences[i] = new Conference(sc.nextInt(), sc.nextInt());
        }
    }

    // Time Limit Exceeded
    private static int solution() {
        Arrays.sort(conferences);
        int maxCount = 1; // 자기자신포함
        for (int i = 0; i < conferences.length; i++) {
            int loopCount = 1;
            Conference target = conferences[i];
            for (int k = i + 1; k < conferences.length; k++) {
                Conference now = conferences[k];
                if (target.getEnd() <= now.getStart()) {
                    target = now;
                    loopCount++;
                }
            }
            if(loopCount > maxCount) {
                maxCount = loopCount;
            }
        }
        return maxCount;
    }

    private static int solution2() {
        Arrays.sort(conferences);
        int maxCount = 0;
        int endTime = 0;
        for(Conference conference : conferences) {
            if(conference.getStart() >= endTime) {
                maxCount++;
                endTime = conference.getEnd();
            }
        }
        return maxCount;
    }
}
