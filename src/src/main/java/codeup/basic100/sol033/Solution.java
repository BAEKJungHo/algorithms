package codeup.basic100.sol033;

import java.util.Scanner;

// 1035
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int num = Integer.parseInt(str, 16);
        System.out.println(Integer.toOctalString(num));
    }

}
