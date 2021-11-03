package codeup.basic100.sol095;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 1097
public class Solution {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[][] arr = new String[19][19];

            for(int i=0; i<arr.length; i++) {
                String[] ar1 = br.readLine().split(" ");
                for(int j=0; j<arr.length; j++) {
                    arr[i][j] = ar1[j];
                }
            }

            int n = Integer.parseInt(br.readLine());

            ArrayList<String> list = new ArrayList();
            for (int i = 0; i < n; i++) {
                list.add(br.readLine());
            }
            System.out.println(list);

            for (int i = 0; i < list.size(); i++) {
                String[] point = list.get(i).split(" ");

                int x = Integer.parseInt(point[0]);
                int y = Integer.parseInt(point[1]);

                for (int j = 0; j < 19; j++) {
                    if(arr[x-1][j] == "0"){ //x가 0이면
                        arr[x-1][j] = 1 + ""; //1을 넣어준다
                    }else{
                        arr[x-1][j] = 0 + ""; //아니면 0을 넣어준다
                    }
                }
                for (int j = 0; j < 19; j++) {
                    if(arr[j][y-1] == "0"){ //y가 0이면
                        arr[j][y-1] = 1 + ""; //1을 넣어준다
                    }else{
                        arr[j][y-1] = 0 + ""; //아니면 0을 넣어준다
                    }
                }
            }

            //전체 출력 for문
            for (int i = 0; i <arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
