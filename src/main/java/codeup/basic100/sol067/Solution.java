package codeup.basic100.sol067;

import java.util.Scanner;

// 1069
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char alphabet = sc.nextLine().charAt(0);
        printResult(alphabet);
    }

    private static void printResult(char alphabet) {
        switch (alphabet) {
            case 'A' :
                System.out.println("best!!!");
                break;
            case 'B' :
                System.out.println("good!!");
                break;
            case 'C' :
                System.out.println("run!");
                break;
            case 'D' :
                System.out.println("slowly~");
                break;
            default :
                System.out.println("what?");
        }
    }

}