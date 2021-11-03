package codeup.basic100.sol083;

import java.util.Scanner;

// 1085
public class Solution {

    public static void main(String[] args) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            int hz = sc.nextInt();
            int bit = sc.nextInt();
            int channel = sc.nextInt();
            int sec = sc.nextInt();

            boolean isMatchedInputCondition = (hz <= 480000) && (bit <= 32 && bit % 8 == 0) && (channel <= 5) && (sec <= 6000);
            if (!isMatchedInputCondition) {
                System.out.println("h는 48,000이하, b는 32이하(단, 8의배수), c는 5이하, s는 6,000이하의 자연수이어야 합니다.");
                continue;
            }

            System.out.println(String.format("%.1f MB", getSavingCapacity(hz, bit, channel, sec)));
            break;
        }
    }

    private static double getSavingCapacity(int hz, int bit, int channel, int sec) {
        double capacity = hz * bit * channel * sec;
        return toMb(capacity);
    }

    private static double toMb(double result) {
        double mb = 1024 * 1024 * 8;
        return result/mb;
    }

}
