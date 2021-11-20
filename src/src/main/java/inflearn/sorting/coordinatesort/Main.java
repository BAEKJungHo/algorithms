package inflearn.sorting.coordinatesort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * # 좌표 정렬
 *
 * 설명
 * N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
 * 정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.
 *
 * 입력
 * 첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
 * 두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.
 *
 * 출력
 * N개의 좌표를 정렬하여 출력하세요.
 *
 * 예시 입력 1
 * 5
 * 2 7
 * 1 3
 * 1 2
 * 2 5
 * 3 6
 *
 * 예시 출력 1
 * 1 2
 * 1 3
 * 2 5
 * 2 7
 * 3 6
 */
class Coordinate implements Comparable<Coordinate> {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return this.x + " " + this.y;
    }

    @Override
    public int compareTo(Coordinate o) {
        if(this.x == o.x) {
            return this.y-o.getY();
        } else {
            return this.x- o.getX();
        }
    }
}

public class Main {

    public List<Coordinate> solution(List<Coordinate> coordinates) {
        coordinates.sort(Coordinate::compareTo);
        return coordinates;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Coordinate> coordinates = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            coordinates.add(new Coordinate(x, y));
        }
        for(Coordinate coordinate : T.solution(coordinates)) {
            System.out.println(coordinate.toString());
        }
    }

}
