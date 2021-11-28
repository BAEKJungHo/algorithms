package thisiscodingtest.chapter4.developmentgame;

import java.util.Scanner;

// 캐릭터의 위치 정보
class Position {
    private int x;
    private int y;
    private int initX;
    private int initY;
    private Direction direction;

    public Position(int x, int y, int directionType) {
        this.x = x;
        this.y = y;
        this.initX = x;
        this.initY = y;
        this.direction = Direction.findByType(directionType);
    }

    public void move() {
        System.out.println("이동 전 위치 // x : " + x + " y : " + y + " 방향 : " + direction.name());
        Strategy strategy = Strategy.findByDirection(direction);
        x += strategy.getX();
        y += strategy.getY();
        changeDirection(); // 방향은 맵의 정보에 상관없이 이동할 때마다 바뀜
        System.out.println("이동 후 위치 // x : " + x + " y : " + y + " 방향 : " + direction.name());
    }

    // X, Y 좌표 초기화
    public void clearXY() {
        x = initX;
        y = initY;
    }

    // 초기화 좌표 수정
    public void updateInitXY() {
        initX = x;
        initY = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void changeDirection() {
        if(Direction.NORTH == direction) {
            direction = Direction.WEST;
        } else if(Direction.WEST == direction) {
            direction = Direction.SOUTH;
        } else if(Direction.SOUTH == direction) {
            direction = Direction.EAST;
        } else {
            direction = Direction.NORTH;
        }
    }
}

// 맵 정보
enum MapInfo {
    LAND(0), // 육지
    SEA(1), // 바다
    VISITED(2), // 방문
    ;

    private int type;

    MapInfo(int type) {
        this.type = type;
    }

    public static boolean isNotLand(int value) {
        return MapInfo.LAND.type != value;
    }

    public int getType() {
        return type;
    }
}

// 방향
enum Direction {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3),
    ;

    private int type;

    Direction(int type) {
        this.type = type;
    }

    public static Direction findByType(int type) {
        for(Direction direction : Direction.values()) {
            if(direction.type == type) {
                return direction;
            }
        }
        throw new IllegalArgumentException("not founded Direction ... type : " + type);
    }

    public int getType() {
        return type;
    }
}

// 이동 전략
    // 상하좌우로 움직일 수 있고, 바다에는 갈 수 없다.
    // 반 시계 방향으로 90 도 회전한 방향 부터 갈 곳을 정한다.
    // 자신이 바라보고 있는 방향(Direction) 에 따라서 90도 회전했을때의 전략이 바뀜
        // 예를 들어 북쪽을 바라보고 있는 상태에서 반시계로 90 도 회전하면, 전략은 LEFT
        // 동쪽을 바라보고 있는 상태에서 반시계로 90도 회전하면, 전략은 UP
        // 따라서 전략은 방향에 의존적임.
enum Strategy {
    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1),
    ;

    private int x;
    private int y;

    Strategy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Strategy findByDirection(Direction direction) {
        if(Direction.NORTH.equals(direction)) {
            return Strategy.LEFT;
        } else if(Direction.EAST.equals(direction)) {
            return Strategy.UP;
        } else if(Direction.SOUTH.equals(direction)) {
            return Strategy.RIGHT;
        } else if(Direction.WEST.equals(direction)) {
            return Strategy.DOWN;
        } else {
            throw new IllegalArgumentException("not founded Strategy by Direction : " + direction);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

// 게임 개발 : 시뮬레이션 문제
public class Main {

    /**
     * @param x 캐릭터의 처음 x 좌표
     * @param y 캐릭터의 처음 y 좌표
     * @param direction 캐릭터가 처음에 바라보고 있는 방향
     * @param n 맵의 가로 크기
     * @param m 맵의 세로 크기
     * @param map 맵
     * @return
     */
    public int solution(int x, int y, int direction, int n, int m, int[][] map) {
        int answer = 1; // 현재위치는 방문한 상태
        map[x][y] = MapInfo.VISITED.getType(); // 현재위치는 육지이며 방문했으니까 VISITED 처리

        Position position = new Position(x, y, direction);
        while(true) {
            position.move();
            if(MapInfo.isNotLand(map[position.getX()][position.getY()])) { // 맵이탈이거나 바다이면 방향만 바꾸고 현재 위치 자리 고수
                position.clearXY();
            } else { // 방문하지 않은 육지인 경우
                System.out.println("방문!!! 현재 좌표 // x :" + position.getX() + " y : " + position.getY());
                map[position.getX()][position.getY()] = MapInfo.VISITED.getType();
                position.updateInitXY();
                answer++;
            }
            if(validateToEnd(position.getX(), position.getY(), map)) {
                break;
            }
        }

        return answer;
    }

    /**
     * 종료 조건은 현재 자신의 위치에서 대각선을 제외한 사방이 1(바다) OR 2(방문) OR 맵 이탈 이면종료
     * @param currentX 캐릭터의 현재 X 좌표
     * @param currentY 캐릭터의 현재 Y 좌표
     * @param map 맵
     * @return 종료 여부
     */
    private static boolean validateToEnd(int currentX, int currentY, int[][] map) {
        boolean endFlag = false;
        for(Strategy strategy : Strategy.values()) {
            int x = currentX + strategy.getX();
            int y = currentY + strategy.getY();
            if(isLeaving(x, y)) { // 맵 이탈
                endFlag = true;
            } else if(MapInfo.isNotLand(map[x][y])) { // 바다 or 방문
                endFlag = true;
            } else {
                return false;
            }
        }
        return endFlag;
    }

    private static boolean isLeaving(int x, int y) {
        return x < 0 || y < 0;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int direction = sc.nextInt();
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int k=0; k<m; k++) {
                map[i][k] = sc.nextInt();
            }
        }
        System.out.println(T.solution(x, y, direction, n, m, map));
    }

}
