package codeup.basic100.sol018;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr  = str.split("-");
        System.out.println(String.format("%s%s", arr[0], arr[1]));
    }

}
