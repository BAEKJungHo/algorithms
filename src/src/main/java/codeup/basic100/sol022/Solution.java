package codeup.basic100.sol022;

import java.util.Scanner;

// 1024
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String eng = sc.nextLine();

        String[] arr = null;
        if(eng.contains("\\0")) {
            arr = eng.split("\\\\0"); // \0 은 \\\\0 으로 처리해야한다.
        } else if(eng.toLowerCase().contains("null")) {
            arr = eng.toLowerCase().split("null");
        } else {
            arr[0] = eng;
        }

        for(int i=0; i<arr[0].length(); i++) {
            System.out.println("\'"+ arr[0].charAt(i)+"\'");
        }

    }

}
