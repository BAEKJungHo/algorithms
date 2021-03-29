package codeup.basic100.sol097;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1099
public class Solution {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[][]arr = new String[10][10];
            //10*10크기의 미로 상자 구조와 먹이 위치를 입력받는다
            for(int i=0; i<arr.length; i++) {
                //String 배열에 입력받는 값을 모두 잘라서 넣는다
                String[] y = br.readLine().split(" ");

                //[행][열] 잘라진 숫자들을 열인 [j]기준으로 모두 담는다
                for(int j=0; j<y.length; j++) {
                    arr[i][j] = y[j];
                }
            }

            int flag = 1; //벽
            int end = 0; //갈수있는곳

            for(int i=1; i<arr.length; i++) {
                if(end !=1) { //벽이 아니면

                    for(int j=flag; j<arr[i].length; j++) {
                        if(arr[i][j].equals("0")) {
                            arr[i][j] = "9";

                        }else if(arr[i][j].equals("2")) { //먹이발견하면
                            arr[i][j] = "9";
                            end = 1;
                            break; //더이상 움직이지 않고 머무른다
                        }else {
                            flag = j-1;
                            break;
                        }
                    }
                }else {
                    break;
                }
            }

            //전체 출력 for문
            for(int i=0; i<arr.length; i++) {
                for(int j=0; j<arr.length; j++) {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }

        }catch(Exception e) {
            new RuntimeException(e.getMessage());
        }
    }

}
