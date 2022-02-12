package codingtest.square;

// 백준 2628 과 상당히 유사
class Main {

    public static void main(String[] args) {
        System.out.println(solution(3, 4, new int[]{2}, new int[]{1,2}));
    }

    static int solution(int n, int m, int[] x_axis, int[] y_axis) {
        // 가로로 자르는 경우
        int height = 0; // 크기
        int start = 0; // 시작 좌표 = 이전에 잘랐던 위치
        for(int i = 0; i < y_axis.length; i++) {

            // 1과 2가 있을때
            // 1 - 0  > 0 -> width = 1 - 0 // start = 1
            // 2 - 1
            if(y_axis[i] - start > height) {
                height = y_axis[i] - start;
            }
            start = y_axis[i];
        }

        // 현재 height 는 밑 공간(or 좌표가 여러개 주어졌을 때, 그 좌표 사이의 공간)
        // 따라서 윗 공간을 계산한 후에 비교해줘야 함
        if(m - start > height) {
            height = m - start;
        }

        int width = 0;
        start = 0;
        for(int i = 0; i < x_axis.length; i++) {
            if(x_axis[i] - start > width) {
                width = x_axis[i] - start;
            }
            start = x_axis[i];
        }

        if(n - start > width) {
            width = n - start;
        }

        return width * height;
    }
}