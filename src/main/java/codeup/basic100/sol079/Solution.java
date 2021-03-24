package codeup.basic100.sol079;

import java.util.Scanner;

// 1081
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        for(int i=1; i<=n; i++) {
            for(int k=1; k<=m; k++) {
                System.out.println(String.format("%d %d", i, k));
            }
        }
    }

}
