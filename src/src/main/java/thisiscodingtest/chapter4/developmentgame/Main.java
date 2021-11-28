package thisiscodingtest.chapter4.developmentgame;

import java.util.Scanner;

// 캐릭터의 위치 정보
class Position {
    private int x; // 현재 x 좌표
    private int y;  // 현재 y 좌표
    private int initX;
    private int initY;
    private int[][] map; // 자신이 방문한 map 의 정보
    private int answer = 1; // 자신이 방문한 칸의 횟수, 현재위치는 방문한 상태
    private Direction direction;

    public Position(int x, int y, int directionType, int[][] map) {
        this.x = x;
        this.y = y;
        this.initX = x;
        this.initY = y;
        this.direction = Direction.findByType(directionType);
        this.map = map;
    }

    // 이동
    public void move() {
        System.out.println("이동 전 위치 // x : " + x + " y : " + y + " 방향 : " + direction.name());
        Strategy strategy = Strategy.findForMove(direction);
        x += strategy.getX();
        y += strategy.getY();
        changeDirection(); // 방향은 맵의 정보에 상관없이 이동할 때마다 바뀜
        System.out.println("이동 후 위치 // x : " + x + " y : " + y + " 방향 : " + direction.name());

        int mapInfo = map[x][y];
        if(MapInfo.isLeaving(x, y) || MapInfo.isSea(mapInfo) || MapInfo.isVisited(mapInfo)) { // 맵이탈 or 바다 or 방문 했던 곳 이면 방향만 바꾸고 현재 위치 자리 고수
            restore();
        } else { // 방문하지 않은 육지인 경우
            System.out.println("방문!!! 현재 좌표 // x :" + x + " y : " + y);
            map[x][y] = MapInfo.VISITED.getType();
            updateInitCoordinates();
            answer++;
        }
    }

    // 뒤로 이동 : 방향은 유지
    public void back() {
        System.out.println("뒤로 이동 전 위치 // x : " + x + " y : " + y + " 방향 : " + direction.name());
        Strategy strategy = Strategy.findForBack(direction);
        x += strategy.getX();
        y += strategy.getY();
        System.out.println("뒤로 이동 후 위치 // x : " + x + " y : " + y + " 방향 : " + direction.name());
    }

    // X, Y 좌표 복구
    public void restore() {
        x = initX;
        y = initY;
    }

    // 초기화 좌표 수정
    public void updateInitCoordinates() {
        initX = x;
        initY = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAnswer() {
        return answer;
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

    public static boolean isSea(int value) {
        return MapInfo.SEA.type == value;
    }

    public static boolean isLeaving(int x, int y) {
        return x < 0 || y < 0;
    }

    public static boolean isVisited(int value) {
        return MapInfo.VISITED.type == value;
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

    // 90도 시계 반대방향으로 회전 후 이동하기 위한 전략
    public static Strategy findForMove(Direction direction) {
        if(Direction.NORTH.equals(direction)) {
            return Strategy.LEFT;
        } else if(Direction.EAST.equals(direction)) {
            return Strategy.UP;
        } else if(Direction.SOUTH.equals(direction)) {
            return Strategy.RIGHT;
        } else if(Direction.WEST.equals(direction)) {
            return Strategy.DOWN;
        } else {
            throw new IllegalArgumentException("not founded Strategy to Move... Direction : " + direction);
        }
    }

    // 뒤로 이동하기 위한 전략
    public static Strategy findForBack(Direction direction) {
        if(Direction.NORTH.equals(direction)) {
            return Strategy.DOWN;
        } else if(Direction.EAST.equals(direction)) {
            return Strategy.LEFT;
        } else if(Direction.SOUTH.equals(direction)) {
            return Strategy.UP;
        } else if(Direction.WEST.equals(direction)) {
            return Strategy.RIGHT;
        } else {
            throw new IllegalArgumentException("not founded Strategy to Back... Direction : " + direction);
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
        map[x][y] = MapInfo.VISITED.getType(); // 현재위치는 육지이며 방문했으니까 VISITED 처리

        Position position = new Position(x, y, direction, map.clone());
        while(true) {
            position.move();
            if(validateToBack(position.getX(), position.getY(), map)) { // 이동 후 -> 뒤로 이동해야하는지 판단
                position.back();
                int mapInfo = map[position.getX()][position.getY()];
                if(MapInfo.isLeaving(position.getX(), position.getY()) || MapInfo.isSea(mapInfo)) { // 맵이탈 or 바다이면 종료
                    break;
                } else if(MapInfo.isVisited(mapInfo)) { // 방문 했던 곳인 경우
                    position.updateInitCoordinates();
                }
            }
        }

        return position.getAnswer();
    }

    /**
     * 뒤로 이동해야하는 조건(사방이 맵이탈 or 바다 or 방문했던 곳)
     * @param currentX 캐릭터의 현재 X 좌표
     * @param currentY 캐릭터의 현재 Y 좌표
     * @param map 맵
     * @return 종료 여부
     */
    private static boolean validateToBack(int currentX, int currentY, int[][] map) {
        boolean endFlag = false;
        for(Strategy strategy : Strategy.values()) {
            int x = currentX + strategy.getX();
            int y = currentY + strategy.getY();
            if(MapInfo.isLeaving(x, y) || MapInfo.isSea(map[x][y]) || MapInfo.isVisited(map[x][y])) {
                endFlag = true;
            } else { // 방문을 아직 안한 곳인 경우
                return false;
            }
        }
        return endFlag;
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
