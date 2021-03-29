package codeup.basic100.sol096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1098
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            //가로 세로 길이를 입력받는다
            String[] hw = br.readLine().split(" ");
            //height=5 / width=5
            int height = Integer.parseInt(hw[0]);
            int width = Integer.parseInt(hw[1]);

            //입력값의 정의역
            if (height > 0 && height <= 100 &&
                    width > 0 && width <= 100) {

                //[5][5] 크기의 배열을 만든다
                String[][] arr = new String[height][width];

                //막대의 개수를 입력받는다.
                int n = Integer.parseInt(br.readLine());

                if (n >= 1 && n <=10) {

                    for (int i = 0; i < n; i++) {
                        //막대의 정보를 String배열에 입력받는다
                        //막대의길이 (length) 방향(d) 0이면 가로로 1이면 세로로
                        //좌표 (x) (y)
                        String[] stick = br.readLine().split(" ");

                        int length = Integer.parseInt(stick[0]);
                        int d = Integer.parseInt(stick[1]);
                        int x = Integer.parseInt(stick[2])-1;
                        int y = Integer.parseInt(stick[3])-1;

                        //2 0 1 1로 예를 들면
                        if (d == 0) { //막대 방향이 가로일때
                            for (int j = y; j < y + length; j++) {
                                //int j=0; j<2; j++
                                if (j < width) {
                                    //[0][0] 과 [0][1]에 1을 넣어준다
                                    arr[x][j] = "1";
                                }
                            }
                            //3 1 2 3으로 예를 들면
                        }else{ //막대 방향이 세로일때
                            for (int j = x; j < x + length; j++) {
                                //int j=1; j<4; j++
                                if (j < height) {
                                    //[1][2],[2][2],[3][2]에 1을 넣어준다
                                    arr[j][y] = "1";
                                }
                            }
                        }
                    }

                    //전체 출력 for문
                    for (int i = 0; i < arr.length; i++) {
                        for (int j = 0; j < arr[i].length; j++) {
                            if (arr[i][j] == null) {//위에 해당되는 값이 없어서 null이면
                                arr[i][j] = "0"; //0을 넣어준다
                            }
                            System.out.print(arr[i][j] + " ");
                        }
                        System.out.println();
                    }
                }else{
                    System.out.println("1 >= stick num <= 10");
                }
            }else{
                System.out.println("1 >= width & height <= 100");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

}
