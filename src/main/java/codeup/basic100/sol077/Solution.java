package codeup.basic100.sol077;

import java.util.Scanner;

// 1079
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String alphabet = sc.nextLine();
        String[] alphabets = alphabet.split(" ");

        for(int i=0; i<alphabet.length(); i++) {
            System.out.println(alphabets[i]);
            if(alphabets[i].equals("q")) {
                break;
            }
        }
    }

}
