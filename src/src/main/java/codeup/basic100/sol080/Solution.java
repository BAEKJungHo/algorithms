package codeup.basic100.sol080;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 1082
public class Solution {

    public static void main(String[] args) {
        final String[] hexadecimals = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        final Map<String, String> dans = new HashMap() {{
            put("A", "A");
            put("B", "B");
            put("C", "C");
            put("D", "D");
            put("E", "E");
            put("F", "F");
        }};

        Scanner sc = new Scanner(System.in);
        String hexadecimal = sc.nextLine();

        if(dans.get(hexadecimal) == null) {
            return;
        }

        for(int i=1; i<hexadecimals.length; i++){
            int multiplyResult = Integer.parseInt(hexadecimal, 16) * Integer.parseInt(hexadecimals[i], 16);
            System.out.println(
                    String.format(
                            "%S*%S=%S",
                            hexadecimal,
                            hexadecimals[i],
                            Integer.toHexString(multiplyResult)
                    ));
        }
    }

}
