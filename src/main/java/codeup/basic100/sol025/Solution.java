package codeup.basic100.sol025;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    private static final Pattern DATE_REGEX = Pattern.compile("^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$");

    public static void main(String[] args) {

        while(true) {
            Scanner sc = new Scanner(System.in);
            String date = sc.nextLine();
            String[] arr = date.split("-");

            Matcher isCorrectDateType = DATE_REGEX.matcher(date);

            if(isCorrectDateType.find()) {
                System.out.println("yyyy-MM-dd 형식으로 입력해야 합니다.");
            }
        }

    }

}
