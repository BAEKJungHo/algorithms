package thisiscodingtest.chapter4.royalnights;


import java.util.Scanner;

class Position {
    private int x;
    private int y;
    private int initX;
    private int initY;

    public Position(String x, String y) {
        this.x = Integer.parseInt(x);
        this.initX = this.x;
        this.y = parse(y);
        this.initY = this.y;
    }

    // 이동
    public void move(Strategy strategy) {
        this.x += strategy.getX();
        this.y += strategy.getY();
    }

    // 밖으로 나간 좌표인지 검증
    public boolean validate() {
        return this.x > 0 && this.y > 0 && this.x <= 8 && this.y <= 8;
    }

    // 좌표 초기화
    public void clear() {
        this.x = this.initX;
        this.y = this.initY;
    }
    
    private int parse(String alphabet) {
        if("a".equals(alphabet)) {
            return 1;
        } else if("b".equals(alphabet)) {
            return 2;
        } else if("c".equals(alphabet)) {
            return 3;
        } else if("d".equals(alphabet)) {
            return 4;
        } else if("e".equals(alphabet)) {
            return 5;
        } else if("f".equals(alphabet)) {
            return 6;
        } else if("g".equals(alphabet)) {
            return 7;
        } else if("h".equals(alphabet)) {
            return 8;
        } else {
            throw new IllegalArgumentException("failed to parse ... alphabet : " + alphabet);
        }
    }
}

enum Strategy {
    A(-2, -1),
    B(-1, -2),
    C(1, -2),
    D(2, -1),
    E(2, 1),
    F(1, 2),
    G(-1, 2),
    H(-2, 1);

    private int x;
    private int y;

    Strategy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

// 왕실의 나이트
public class Main {

    // 이동 -> 검증 -> 좌표 초기화
    public int solution(String s) {
        int answer = 0;
        String[] positions = s.split("");
        Position position = new Position(positions[1], positions[0]);
        for(Strategy strategy : Strategy.values()) {
            position.move(strategy);
            if(position.validate()) {
                answer++;
            }
            position.clear();
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(T.solution(s));
    }
    
}
