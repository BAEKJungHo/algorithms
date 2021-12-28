package thisiscodingtest.part03.Q08_stringresort;

import java.util.Arrays;
import java.util.Scanner;

// 문자열 재정렬
public class Main {

    private static String S;
    private static int sumOfDigit = 0;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        S = sc.nextLine();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if(Character.isDigit(S.charAt(i))) {
                sumOfDigit += Character.getNumericValue(S.charAt(i));
            } else {
                stringBuilder.append(S.charAt(i));
            }
        }

        char[] alphabets = stringBuilder.toString().toCharArray();
        Arrays.sort(alphabets);
        System.out.println(new String(alphabets) + sumOfDigit);
    }

}
