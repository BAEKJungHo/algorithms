package codeup.basic100.sol070;

import java.util.Scanner;

// 1072
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeatNum = sc.nextInt();
        int[] arr = new int[repeatNum];
        for(int i=0; i<repeatNum; i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<repeatNum; i++){
            System.out.println(arr[i]);
        }
    }

}
