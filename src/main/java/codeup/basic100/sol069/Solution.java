package codeup.basic100.sol069;

import java.util.Scanner;

// 1071
public class Solution {

    public static void main(String[] args) {
       while(true) {
           Scanner sc = new Scanner(System.in);
           int num = sc.nextInt();
           if(num != 0) {
               System.out.println(num);
           } else {
               break;
           }
       }
    }

}
