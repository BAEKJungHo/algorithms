package codeup.basic100.sol017;

import java.util.Scanner;

// 1019
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr  = str.split("\\.");
        System.out.println(String.format(
                "%02d.%02d.%02d",
                Integer.parseInt(arr[0]),
                Integer.parseInt(arr[1]),
                Integer.parseInt(arr[2])
        ));
    }

}
