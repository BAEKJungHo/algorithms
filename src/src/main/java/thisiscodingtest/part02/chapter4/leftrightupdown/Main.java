package thisiscodingtest.part02.chapter4.leftrightupdown;

import java.util.Scanner;

class Position {
    private int x;
    private int y;
    private int maxLength;

    public Position(int maxLength) {
        this.x = 1;
        this.y = 1;
        this.maxLength = maxLength;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getCurrentPosition() {
        return this.x + " " + this.y;
    }
}

interface MovingStrategy {
    void move(Position position); // 이동

    boolean isIgnore(Position position); // 무시되는 조건
}

class RightMovingStrategy implements MovingStrategy {
    @Override
    public void move(Position position) {
        if(!isIgnore(position)) {
            position.setY(position.getY()+1);
        }
    }

    @Override
    public boolean isIgnore(Position position) {
        return position.getY() == position.getMaxLength();
    }
}

class LeftMovingStrategy implements MovingStrategy {
    @Override
    public void move(Position position) {
        if(!isIgnore(position)) {
            position.setY(position.getY()-1);
        }
    }

    @Override
    public boolean isIgnore(Position position) {
        return position.getY() == 1;
    }
}

class UpMovingStrategy implements MovingStrategy {
    @Override
    public void move(Position position) {
        if(!isIgnore(position)) {
            position.setX(position.getX()-1);
        }
    }

    @Override
    public boolean isIgnore(Position position) {
        return position.getX() == 1;
    }
}

class DownMovingStrategy implements MovingStrategy {
    @Override
    public void move(Position position) {
        if(!isIgnore(position)) {
            position.setX(position.getX()+1);
        }
    }

    @Override
    public boolean isIgnore(Position position) {
        return position.getX() == position.getMaxLength();
    }
}

class MovingFactory {

    /**
     * @param plan 이동 계획
     */
    public static MovingStrategy of(String plan) {
        if(Plan.R.name().equals(plan))  {
            return new RightMovingStrategy();
        } else if(Plan.L.name().equals(plan)) {
            return new LeftMovingStrategy();
        } else if(Plan.U.name().equals(plan)) {
            return new UpMovingStrategy();
        } else if(Plan.D.name().equals(plan)) {
            return new DownMovingStrategy();
        } else {
            throw new IllegalArgumentException("not founded strategy by : " + plan);
        }
    }
}

enum Plan {
    L, R, U, D
}

// 상하좌우
public class Main {

    // LRUD 무시조건(ignore) / 이동
    // L : (P, 1)   L -> (0, -1)
    // R : (P, 5)   R -> (0, 1)
    // U : (1, P)   U -> (-1, 0)
    // D : (5, P)   D -> (1, 0)
    public String solution(int n, String planner) {
        Position position = new Position(n);
        String[] planners = planner.split(" ");
        for(int i=0; i<planners.length; i++) {
            MovingStrategy movingStrategy = MovingFactory.of(planners[i]);
            movingStrategy.move(position);
        }
        return position.getCurrentPosition();
    }



    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String planner = sc.nextLine();

        System.out.println(T.solution(Integer.parseInt(n), planner));
    }

}
