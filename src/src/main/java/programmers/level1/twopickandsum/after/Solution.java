package programmers.level1.twopickandsum.after;

import java.util.*;

/**
 * 월간 코드 챌린지 시즌 1
 * 두개 뽑아서 더하기
 * ==============================================
 * @author BJH
 * @history 작성일            작성자     변경내용
 * @history 2021-03-16         BJH      최초작성
 * ==============================================
 */
public class Solution {

    public int[] solution(int[] numbers) {
        TreeSet<Integer> result = new TreeSet<>();

        for(int i=0; i<numbers.length; i++) {
            for(int k=i+1; k< numbers.length; k++) {
                result.add(numbers[i] + numbers[k]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
