package codeup.basic100.sol068;

import java.util.Scanner;

// 1070
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        printWeather(month);
    }

    private static void printWeather(int month) {
        System.out.println(findWeather(month));
    }

    private static String findWeather(int month) {
        switch (month) {
            case 12 :
            case 1 :
            case 2 :
                return "winter";
            case 3:
            case 4:
            case 5:
                return "spring";
            case 6:
            case 7:
            case 8:
                return "summer";
            case 9:
            case 10:
            case 11:
                return "fall";
            default:
                return null;
        }
    }


}
